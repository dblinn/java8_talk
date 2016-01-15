package com.vmt;

import static junit.framework.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

// Optionals are a useful type to avoid NPEs and improve
// readability of code by avoiding null checks
public class f_Optionals {
    @Test
    public void testBasicOptional() {
        Optional<String> optional = Optional.of("bam");

        System.out.println(optional.isPresent());           // true
        System.out.println(optional.get());                 // "bam"
        System.out.println(optional.orElse("fallback"));    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }

    // Taken from Monadic Java presentation
    // http://www.slideshare.net/mariofusco/monadic-java
    public class Person {
        private Car car;
        public Car getCar() { return car; }
        public Person() { car = new Car(new Insurance(30.0f)); }
    }

    public class Car {
        private Insurance insurance;
        public Insurance getInsurance() { return insurance; }
        public Car(Insurance insurance) { this.insurance = insurance; }
    }

    public class Insurance {
        private Float cost;
        public Float getCost() { return cost; }
        public Insurance(Float cost) { this.cost = cost; }
    }

    Person getPerson() {
        return new Person();
//        return null;
    }

    // Not uncommon to see code like this when working with nullable values
    Float getInsuranceCostJava7() {
        Person person = getPerson();

        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getCost();
                }
            }
        }

        return 0.0f;
    }

    @Test
    public void testJava7NullChecks() {
        assertEquals(30.0f, getInsuranceCostJava7());
    }

    @Test
    public void testOptionalAvoidNullChecks() {
        Optional<Person> person = Optional.ofNullable(getPerson());
        Float cost = person
            .map(p -> p.getCar())
            .map(car -> car.getInsurance())
            .map(insurance -> insurance.getCost())
            .orElse(0.0f);

        assertEquals(30.0f, cost);
    }

    // Java optionals will throw an NPE if you try to create one with NULL
    @Test
    public void testOptionalWithNull() {
        Optional.of(null); // Null pointer exception
    }
}
