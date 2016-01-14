package com.vmt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MethodReferences {
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
     * This example shows how to reference a static method. But we can also reference object methods:
     */
    @FunctionalInterface
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
}
