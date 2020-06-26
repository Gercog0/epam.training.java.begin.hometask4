package homework_2.comparator;

import by.training.homework4_2.comparator.MaxElementComparator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxElementComparatorTest {
    MaxElementComparator comparator;

    @BeforeClass
    public void setUp() {
        comparator = new MaxElementComparator();
    }

    @DataProvider(name = "arraysData")
    public Object[][] createArraysValid() {
        return new Object[][]{
                {new int[]{12, 5, 4, 0}, new int[]{22, 8, 9, 12, 1}},
                {new int[]{2, 5, 4, 9}, new int[]{5, 8, 19, 12, 8}},
                {new int[]{12, 5, 4}, new int[]{22, 3, 9, 2, 0}},
                {new int[]{21}, new int[]{2, 8, 9, 31, 1}}};
    }

    @Test
    public void searchMaxElementValid() {
        int expected = 5;
        int actual = comparator.searchMaxElement(new int[]{5, 2, 3, 1, 0});
        assertEquals(expected, actual);
    }

    @Test
    public void searchMaxElementInvalid() {
        int expected = 0;
        int actual = comparator.searchMaxElement(new int[]{5, 2, 3, 1, 0});
        assertNotEquals(expected, actual);
    }

    @Test(dataProvider = "arraysData")
    public void compareTestValid(int[] arrayFirst, int[] arraySecond) {
        int expected = -10;
        int actual = comparator.compare(arrayFirst, arraySecond);
        assertEquals(expected,actual);
    }

    @Test(dataProvider = "arraysData")
    public void compareTestInvalid(int[] arrayFirst, int[] arraySecond) {
        int expected = 0;
        int actual = comparator.compare(arrayFirst, arraySecond);
        assertNotEquals(expected,actual);
    }

    @AfterClass
    public void tierDown() {
        comparator = null;
    }
}
