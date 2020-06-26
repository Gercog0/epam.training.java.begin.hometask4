package by.training.homework4_2.comparator;

import java.util.Comparator;

public class MinElementComparator implements Comparator<int[]> {
    public int searchMinElement(int[] array) {
        int minElement = array[0];
        for (int element : array) {
            if (element < minElement) {
                minElement = element;
            }
        }
        return minElement;
    }

    @Override
    public int compare(int[] arrayFirst, int[] arraySecond) {
        return searchMinElement(arrayFirst) - searchMinElement(arraySecond);
    }
}
