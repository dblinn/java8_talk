package com.vmt;

import static org.junit.Assert.assertEquals;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

public class g_MethodReferencesAndFunctionalInterfaces {
    public static class Person {
        String firstName;
        String lastName;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Person() {
            this.firstName = "Jane";
            this.lastName = "Doe";
        }

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    /**
     * Java 8 enables you to pass references of methods or constructors via the :: keyword.
     * This example shows how to reference a static method.
     */
    @FunctionalInterface // A so called functional interface must contain
                         // exactly one abstract method declaration.
    public interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    @Test
    public void TestPersonCreation() {
        // We create a reference to the Person constructor via Person::new.
        // The Java compiler automatically chooses the right constructor by
        // matching the signature of PersonFactory.create. Note that this only
        // works when PersonFactory is a functional interface.
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");

        assertEquals("Peter", person.getFirstName());
        assertEquals("Parker", person.getLastName());
    }

    // There are built in functional interfaces similar to what was
    // available in Google's Guava library
    // Here are examples of predicates and functions

    @Test
    // Predicates return a boolean
    public void testPredicateMethods() {
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));              // true
        System.out.println(predicate.negate().test("foo"));     // false
    }

    @Test
    // Functions take a single argument and return a value
    // They can be chained using syntax like "andThen"
    public void testFunctions() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        assertEquals("123", backToString.apply("123"));
    }

    @Test
    // Bifunctions take two arguments and return a value
    public void testBiFunctions() {
        BiFunction<String, Integer, Integer> adder = (a, b) -> Integer.parseInt(a) + b;

        assertEquals(new Integer(3), adder.apply("2", 1));
    }
}
