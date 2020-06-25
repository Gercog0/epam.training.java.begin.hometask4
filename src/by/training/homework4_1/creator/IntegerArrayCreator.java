package by.training.homework4_1.creator;

import by.training.homework4_1.console.InputData;
import by.training.homework4_1.console.OutputData;
import by.training.homework4_1.entity.IntegerArray;
import by.training.homework4_1.exception.UserException;
import by.training.homework4_1.parser.FileParser;
import by.training.homework4_1.reader.ArrayDataReader;

import java.util.Random;

public class IntegerArrayCreator {
    private static final int BOUND_ARRAY = 10000;

    public IntegerArray createArrayByConsole() {
        OutputData.print("Input size of an array:");
        int arraySize = InputData.inputInt();

        int[] newArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            OutputData.print("Index" + i + ". Input a value:");
            newArray[i] = InputData.inputInt();
        }
        return new IntegerArray(newArray);
    }

    public IntegerArray createRandomArray(int arraySize) {
        Random random = new Random();
        int[] newArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            newArray[i] = random.nextInt(BOUND_ARRAY);
        }
        return new IntegerArray(newArray);
    }

    public IntegerArray createArrayByFile(String nameFile) throws UserException {
        if (nameFile == null) {
            throw new UserException("Name file is not correct...");
        }
        ArrayDataReader dataReader = new ArrayDataReader();
        FileParser fileParser = new FileParser();

        String[] data = dataReader.dataReader(nameFile);
        int[] newArray = fileParser.parseStringToIntegerArray(data);
        return new IntegerArray(newArray);
    }
}
