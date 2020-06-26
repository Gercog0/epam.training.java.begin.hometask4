package homework_2.comparator;

import by.training.homework4_2.comparator.SumElementsComparator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SumElementsComparatorTest {
    SumElementsComparator comparator;

    @BeforeClass
    public void setUp() {
        comparator = new SumElementsComparator();
    }

    @DataProvider(name = "arraysData")
    public Object[][] createArraysValid() {
        return new Object[][]{
                {new int[]{12, 5, 4, 0}, new int[]{22, 0, 0, 0, 1}},
                {new int[]{2, 5, 4, 9}, new int[]{3, 3, 3, 9, 4}},
                {new int[]{12, 5, 4}, new int[]{2, 5, 9, 4, 3}},
                {new int[]{21}, new int[]{7, 7, 7, 2, 0}}};
    }

    @Test
    public void calculateSumElementsValid() {
        int expected = 11;
        int actual = comparator.calculateSumElements(new int[]{5, 2, 3, 1, 0});
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSumElementsInvalid() {
        int expected = 5;
        int actual = comparator.calculateSumElements(new int[]{5, 2, 3, 1, 0});
        assertNotEquals(expected, actual);
    }

    @Test(dataProvider = "arraysData")
    public void compareTestValid(int[] arrayFirst, int[] arraySecond) {
        int expected = -2;
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
