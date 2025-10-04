package Classworks.Activity;

public class Calculator {
    public static int addition(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static int division(int a, int b) {
        return a / b;
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double ln(double a) {
        return Math.log(a);
    }

    public static double sqrt(double a) {
        return Math.sqrt(a);
    }

    public static int factorial(int a) {
        int result = 1;
        for (int i = 2; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
