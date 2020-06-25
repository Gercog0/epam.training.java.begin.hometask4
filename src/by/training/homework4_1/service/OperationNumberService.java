package by.training.homework4_1.service;

public class OperationNumberService {
    public boolean isNumberPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * A positive integer x is a Fibonacci number if
     * and only if one of 5x ^ 2 + 4 or 5x ^ 2 - 4 is a perfect square.
     */
    public boolean isNumberFibonacci(int number) {
        if (number <= 0) {
            return false;
        }
        int valueByFirstFormula = (int) (5 * Math.pow(number, 2) + 4);
        int valueBySecondFormula = (int) (5 * Math.pow(number, 2) - 4);
        return Math.sqrt(valueByFirstFormula) % 1 == 0 ||
                Math.sqrt(valueBySecondFormula) % 1 == 0;
    }

    /**
     * For ease of setting the method name:
     * excellent number - number with no
     * identical digits in the decimal notation.
     */
    public boolean isNumberExcellent(int number) {
        if (number <= 0) {
            return false;
        }

        StringBuilder digits = new StringBuilder();
        while (number != 0) {
            String digit = Integer.toString(number % 10);
            if (digits.toString().contains(digit)) {
                return false;
            }
            digits.append(digit);
            number /= 10;
        }
        return true;
    }
}
