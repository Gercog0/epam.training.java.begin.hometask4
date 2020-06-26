package homework_2.comparator;

import by.training.homework4_2.comparator.MinElementComparator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class MinElementComparatorTest {
    MinElementComparator comparator;

    @BeforeClass
    public void setUp() {
        comparator = new MinElementComparator();
    }

    @DataProvider(name = "arraysData")
    public Object[][] createArraysValid() {
        return new Object[][]{
                {new int[]{12, 5, 4, 0}, new int[]{22, 8, 9, 12, 1}},
                {new int[]{2, 5, 4, 9}, new int[]{3, 8, 19, 12, 8}},
                {new int[]{12, 5, 4}, new int[]{22, 5, 9, 25, 50}},
                {new int[]{21}, new int[]{22, 82, 91, 31, 133}}};
    }

    @Test
    public void searchMinElementValid() {
        int expected = 0;
        int actual = comparator.searchMinElement(new int[]{5, 2, 3, 1, 0});
        assertEquals(expected, actual);
    }

    @Test
    public void searchMinElementInvalid() {
        int expected = 5;
        int actual = comparator.searchMinElement(new int[]{5, 2, 3, 1, 0});
        assertNotEquals(expected, actual);
    }

    @Test(dataProvider = "arraysData")
    public void compareTestValid(int[] arrayFirst, int[] arraySecond) {
        int expected = -1;
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
