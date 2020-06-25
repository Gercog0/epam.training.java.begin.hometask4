package by.training.homework4_1.validator;

import by.training.homework4_1.entity.IntegerArray;
import by.training.homework4_1.exception.UserException;

public class ArrayValidator {
    public boolean validateArrayBounds(IntegerArray array, int index) {
        return index >= 0 && index <= array.getSize();
    }

    public boolean validateArrayBounds(int[] array, int index) {
        return index >= 0 && index <= array.length;
    }

    public boolean isArraySorted(IntegerArray array) throws UserException {
        if (array == null) {
            throw new UserException("Incorrect data...");
        }

        boolean isSorted = true;
        for (int i = 0; i < array.getSize() - 1; i++) {
            if (array.getElementByIndex(i) > array.getElementByIndex(i + 1)) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
}
