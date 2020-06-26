package by.training.homework4_2.comparator;

import java.util.Comparator;

public class MaxElementComparator implements Comparator<int[]> {
    public int searchMaxElement(int[] array) {
        int maxElement = array[0];
        for (int element : array) {
            if (element > maxElement) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    @Override
    public int compare(int[] arrayFirst, int[] arraySecond) {
        return searchMaxElement(arrayFirst) - searchMaxElement(arraySecond);
    }
}
