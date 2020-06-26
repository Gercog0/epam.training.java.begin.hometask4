package homework_2.service;

import by.training.homework4_1.exception.UserException;
import by.training.homework4_2.comparator.MaxElementComparator;
import by.training.homework4_2.comparator.MinElementComparator;
import by.training.homework4_2.comparator.SumElementsComparator;
import by.training.homework4_2.service.SortArray;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Comparator;

import static org.testng.Assert.*;

public class SortArrayTest {
    SortArray sort;

    @BeforeClass
    public void setUp() {
        sort = new SortArray();
    }

    @DataProvider(name = "dataComparator")
    public Object[] createDataTypeSort() {
        return new Object[]{
                new MaxElementComparator(),
                new MinElementComparator(),
                new SumElementsComparator()};
    }

    @Test(dataProvider = "dataComparator")
    public void bubbleSortValid(Comparator<int[]> comparator) {
        try {
            int[][] expected = new int[][]{
                    {1, 5, 30}, {40, 2}, {3, 70, 20, 50}};

            int[][] actual = sort.bubbleSort(new int[][]{{3, 70, 20, 50}, {40, 2}, {1, 5, 30}},
                    comparator);

            boolean condition = true;

            for (int i = 0; i < expected.length; i++) {
                for (int j = 0; j < expected[i].length; j++) {
                    if (expected[i][j] != actual[i][j]) {
                        condition = false;
                    }
                }
            }

            assertTrue(condition);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "dataComparator")
    public void bubbleSortInvalid(Comparator<int[]> comparator) {
        try {
            int[][] expected = new int[][]{
                    {1, 5, 30, 15}, {40, 40, 40, 200}, {3, 70, 20, 50}};

            int[][] actual = sort.bubbleSort(new int[][]{{1, 5, 30, 15}, {3, 70, 20, 50}, {40, 2, 4, 200}},
                    comparator);

            boolean condition = true;

            for (int i = 0; i < expected.length; i++) {
                for (int j = 0; j < expected[i].length; j++) {
                    if (expected[i][j] != actual[i][j]) {
                        condition = false;
                    }
                }
            }

            assertFalse(condition);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void bubbleSortException() throws UserException {
        sort.bubbleSort(null, new MinElementComparator());
    }

    @AfterClass
    public void tierDown() {
        sort = null;
    }
}
