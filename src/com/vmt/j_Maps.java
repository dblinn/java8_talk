package com.vmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class j_Maps {
    Map<Integer, String> map;

    @Before
    public void setup() {
         map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
    }

    @Test
    public void testJava7MapIteration() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    @Test
    public void testJava8MapIteration() {
        map.forEach((k, v) -> System.out.println(k + " =>" + v));
    }

    @Test
    public void testRemoveByKeyValuePair() {
        // By passing a second value, the map will only remove the entry for the key parameter if
        // the entry value matches the value parameter
        map.remove(3, "foo");
        System.out.println(map.get(3));

        map.remove(3, "val3");
        System.out.println(map.get(3));
    }

    @Test
    public void testDefault() {
        System.out.println(map.getOrDefault(4, "not found"));
        System.out.println(map.getOrDefault(42, "not found"));
    }
}
