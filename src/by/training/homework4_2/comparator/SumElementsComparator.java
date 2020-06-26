package by.training.homework4_2.comparator;

import java.util.Comparator;

public class SumElementsComparator implements Comparator<int[]> {
    public int calculateSumElements(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    @Override
    public int compare(int[] arrayFirst, int[] arraySecond) {
        return calculateSumElements(arrayFirst) - calculateSumElements(arraySecond);
    }
}
