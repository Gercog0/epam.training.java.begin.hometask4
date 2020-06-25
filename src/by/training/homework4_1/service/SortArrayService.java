package by.training.homework4_1.service;

import by.training.homework4_1.entity.IntegerArray;
import by.training.homework4_1.exception.UserException;
import by.training.homework4_1.validator.ArrayValidator;

public class SortArrayService {
    public boolean bubbleSort(IntegerArray array) throws UserException {
        ArrayValidator validator = new ArrayValidator();
        OperationArrayService service = new OperationArrayService();

        if (array == null) {
            throw new UserException("Incorrect data...");
        }

        if (validator.isArraySorted(array)) {
            return false;
        }

        int size = array.getSize();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array.getElementByIndex(j) > array.getElementByIndex(j + 1)) {
                    service.swapElements(array, j, j + 1);
                }
            }
        }
        return true;
    }

    public boolean insertionSort(IntegerArray array) throws UserException {
        ArrayValidator validator = new ArrayValidator();

        if (array == null) {
            throw new UserException("Incorrect data...");
        }

        if (validator.isArraySorted(array)) {
            return false;
        }

        int size = array.getSize();
        for (int i = 1; i < size; i++) {
            int currentElement = array.getElementByIndex(i);
            int j = i - 1;
            while (j >= 0 && currentElement < array.getElementByIndex(j)) {
                array.setElementByIndex(j + 1, array.getElementByIndex(j));
                j--;
            }
            array.setElementByIndex(j + 1, currentElement);
        }
        return true;
    }

    public boolean selectionSort(IntegerArray array) throws UserException {
        ArrayValidator validator = new ArrayValidator();

        if (array == null) {
            throw new UserException("Incorrect data...");
        }

        if (validator.isArraySorted(array)) {
            return false;
        }

        int size = array.getSize();
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            int minElement = array.getElementByIndex(i);
            for (int j = i + 1; j < size; j++) {
                if (array.getElementByIndex(j) < minElement) {
                    minIndex = j;
                    minElement = array.getElementByIndex(j);
                }
            }
            array.setElementByIndex(minIndex, array.getElementByIndex(i));
            array.setElementByIndex(i, minElement);
        }
        return true;
    }
}
