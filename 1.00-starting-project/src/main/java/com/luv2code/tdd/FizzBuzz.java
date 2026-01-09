package com.luv2code.tdd;

public class FizzBuzz {
    // If number is divisible by 3, print Fizz
    // If number is divisible by 5, print Buzz
    // If number is divisible by 3 and 5, print FizzBuzz
    // If number in NOT divisible by 3 or 5, then print the number

    public static String compute(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }
        else if (number % 3 == 0) {
            return "Fizz";
        }
        else if (number % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(number);
    }
}
