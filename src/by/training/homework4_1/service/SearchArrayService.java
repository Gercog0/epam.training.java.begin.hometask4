package by.training.homework4_1.service;

import by.training.homework4_1.entity.IntegerArray;
import by.training.homework4_1.exception.UserException;
import by.training.homework4_1.validator.ArrayValidator;

import java.util.ArrayList;

public class SearchArrayService {
    private static final int INDEX_NOT_FOUND = -1;

    public int searchMaxElement(IntegerArray array) throws UserException {
        if (array == null) {
            throw new UserException("Incorrect data...");
        }

        int maxElement = array.getElementByIndex(0);

        for (int i = 0; i < array.getSize(); i++) {
            int currentElement = array.getElementByIndex(i);

            if (currentElement > maxElement) {
                maxElement = currentElement;
            }
        }
        return maxElement;
    }

    public int searchMinElement(IntegerArray array) throws UserException {
        if (array == null) {
            throw new UserException("Incorrect data...");
        }

        int minElement = array.getElementByIndex(0);

        for (int i = 0; i < array.getSize(); i++) {
            int currentElement = array.getElementByIndex(i);

            if (currentElement < minElement) {
                minElement = currentElement;
            }
        }
        return minElement;
    }

    public int searchBinary(int element, IntegerArray array) throws UserException {
        ArrayValidator validator = new ArrayValidator();

        if (array == null || !validator.isArraySorted(array)) {
            throw new UserException("Array is not sorted or not exist...");
        }

        int firstIndex = 0;
        int lastIndex = array.getSize() - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array.getElementByIndex(middleIndex) == element) {
                return middleIndex;
            } else if (array.getElementByIndex(middleIndex) < element) {
                firstIndex = middleIndex + 1;
            } else if (array.getElementByIndex(middleIndex) > element) {
                lastIndex = middleIndex - 1;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public IntegerArray searchPrimeNumbers(IntegerArray array) throws UserException {
        if (array == null) {
            throw new UserException("Incorrect data...");
        }
        OperationNumberService service = new OperationNumberService();
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        int size = array.getSize();

        for (int i = 0; i < size; i++) {
            int currentElement = array.getElementByIndex(i);
            if (service.isNumberPrime(currentElement)) {
                primeNumbers.add(currentElement);
            }
        }
        return new IntegerArray(primeNumbers);
    }

    public IntegerArray searchFibonacciNumbers(IntegerArray array) throws UserException {
        if (array == null) {
            throw new UserException("Incorrect data...");
        }
        OperationNumberService service = new OperationNumberService();
        ArrayList<Integer> fibonacciNumbers = new ArrayList<>();
        int size = array.getSize();

        for (int i = 0; i < size; i++) {
            int currentElement = array.getElementByIndex(i);
            if (service.isNumberFibonacci(currentElement)) {
                fibonacciNumbers.add(currentElement);
            }
        }
        return new IntegerArray(fibonacciNumbers);
    }

    public IntegerArray searchExcellentNumbers(IntegerArray array) throws UserException {
        if (array == null) {
            throw new UserException("Incorrect data...");
        }
        OperationNumberService service = new OperationNumberService();
        ArrayList<Integer> excellentNumbers = new ArrayList<>();
        int size = array.getSize();

        for (int i = 0; i < size; i++) {
            int currentElement = array.getElementByIndex(i);
            if (service.isNumberExcellent(currentElement)) {
                excellentNumbers.add(currentElement);
            }
        }

        return new IntegerArray(excellentNumbers);
    }

}