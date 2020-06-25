package by.training.homework4_1.parser;

import by.training.homework4_1.exception.UserException;

public class FileParser {
    public int[] parseStringToIntegerArray(String[] stringArray) throws UserException {
        if (stringArray == null) {
            throw new UserException("Incorrect data...");
        }

        int size = stringArray.length;
        int[] integerArray = new int[size];

        for (int i = 0; i < size; i++) {
            integerArray[i] = Integer.parseInt(stringArray[i]);
        }
        return integerArray;
    }
}
