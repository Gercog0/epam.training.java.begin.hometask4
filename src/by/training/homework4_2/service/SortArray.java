package by.training.homework4_2.service;

import by.training.homework4_1.exception.UserException;

import java.util.Comparator;

public class SortArray {
    public int[][] bubbleSort(int[][] array, Comparator<int[]> comparator) throws UserException {
        if (array == null) {
            throw new UserException();
        }

        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                if (comparator.compare(array[i], array[j]) > 0) {
                    int[] temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
