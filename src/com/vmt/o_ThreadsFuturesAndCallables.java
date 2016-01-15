package com.vmt;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

// See http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
public class o_ThreadsFuturesAndCallables {
    /**
     * The Concurrency API introduces the concept of an ExecutorService as a higher level replacement for
     * working with threads directly. Executors are capable of running asynchronous tasks and typically manage
     * a pool of threads, so we don't have to create new threads manually. All threads of the internal pool
     * will be reused under the hood for revenant tasks, so we can run as many concurrent tasks as we want
     * throughout the life-cycle of our application with a single executor service.
     */
    @Test
    public void testSingleThreadExecutor() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
        shutdownExecutor(executor);
    }

    @Test
    public void testFuturesInvokeAll() throws Exception{
        // Creates a work-stealing thread pool using all available processors as its target parallelism level.
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
            () -> "task1",
            () -> "task2",
            () -> "task3"
        );

        executor.invokeAll(callables)
            .stream()
            .map(future -> {
                try {
                    return future.get();
                }
                catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            })
            .forEach(System.out::println);

        shutdownExecutor(executor);
    }

    @Test
    public void testTimeouts() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        future.get(1, TimeUnit.SECONDS);
    }

    void shutdownExecutor(ExecutorService executor) {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
