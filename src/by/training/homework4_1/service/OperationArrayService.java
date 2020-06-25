package by.training.homework4_1.service;

import by.training.homework4_1.entity.IntegerArray;
import by.training.homework4_1.exception.UserException;
import by.training.homework4_1.validator.ArrayValidator;

public class OperationArrayService {
    public boolean swapElements(IntegerArray array, int indexFirst, int indexSecond)
            throws UserException {
        if (array == null) {
            throw new UserException("Incorrect data...");
        }

        ArrayValidator validator = new ArrayValidator();

        if (!(validator.validateArrayBounds(array, indexFirst) &&
                validator.validateArrayBounds(array, indexSecond)) ||
                indexFirst == indexSecond) {
            return false;
        }
        int additionalTemp = array.getElementByIndex(indexFirst);
        array.setElementByIndex(indexFirst, array.getElementByIndex(indexSecond));
        array.setElementByIndex(indexSecond, additionalTemp);
        return true;
    }
}
