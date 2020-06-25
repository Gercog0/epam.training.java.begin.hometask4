package by.training.homework4_1.reader;

import by.training.homework4_1.exception.UserException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArrayDataReader {
    public String[] dataReader(String fileName) throws UserException {
        if (fileName == null) {
            throw new UserException("File name is not correct...");
        }
        String[] stringArray = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                stringArray = temp.split("\\s");
            }
        } catch (IOException exp) {
            throw new RuntimeException("File not found...");
        }
        return stringArray;
    }
}
