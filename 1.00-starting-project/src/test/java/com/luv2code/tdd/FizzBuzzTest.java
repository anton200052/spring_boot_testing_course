package com.luv2code.tdd;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {
    // If number is divisible by 3, print Fizz
    // If number is divisible by 5, print Buzz
    // If number is divisible by 3 and 5, print FizzBuzz
    // If number in NOT divisible by 3 or 5, then print the number

    @Test
    @Order(1)
    @DisplayName("Divisible by Three")
    void testForDivisibleByThree() {
        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    @Test
    @Order(2)
    @DisplayName("Divisible by Five")
    void testForDivisibleByFive() {
        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    @Test
    @Order(3)
    @DisplayName("Divisible by Three and Five")
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    @Test
    @Order(4)
    @DisplayName("Not divisible")
    void testForNotDivisible() {
        assertNotEquals("Fizz", FizzBuzz.compute(1), "Should not be divisible");
        assertNotEquals("Buzz", FizzBuzz.compute(1), "Should not be divisible");
        assertNotEquals("FizzBuzz", FizzBuzz.compute(1), "Should not be divisible");
    }
}
