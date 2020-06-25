package homework_1.service;

import by.training.homework4_1.entity.IntegerArray;
import by.training.homework4_1.exception.UserException;
import by.training.homework4_1.service.SortArrayService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortArrayServiceTest {
    SortArrayService service;

    @BeforeClass
    public void setUp() {
        service = new SortArrayService();
    }

    @DataProvider(name = "dataToSortValid")
    public Object[][] createDataToSortValid() {
        return new Object[][]{
                {new IntegerArray(9, 8, 7, 6, 5), new IntegerArray(5, 6, 7, 8, 9)},
                {new IntegerArray(95, 8, 33, 321, 100), new IntegerArray(8, 33, 95, 100, 321)},
                {new IntegerArray(0, -1, 18, 4, 324), new IntegerArray(-1, 0, 4, 18, 324)},
                {new IntegerArray(1, 1, 1, 0, 0), new IntegerArray(0, 0, 1, 1, 1)}};
    }

    @DataProvider(name = "dataToSortInvalid")
    public Object[][] createDataToSortInvalid() {
        return new Object[][]{
                {new IntegerArray(9, 8, 7, 6, 5), new IntegerArray(6, 5, 9, 7, 8)},
                {new IntegerArray(95, 8, 33, 321, 100), new IntegerArray(95, 8, 33, 100, 321)},
                {new IntegerArray(0, -1, 18, 4, 324), new IntegerArray(18, 0, 4, -1, 324)},
                {new IntegerArray(1, 1, 1, 0, 0), new IntegerArray(0, 1, 0, 1, 1)}};
    }

    @Test(dataProvider = "dataToSortValid")
    public void bubbleSortValid(IntegerArray array, IntegerArray checkArray) {
        try {
            service.bubbleSort(array);
            assertEquals(array, checkArray);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "dataToSortInvalid")
    public void bubbleSortInvalid(IntegerArray array, IntegerArray checkArray) {
        try {
            service.bubbleSort(array);
            assertNotEquals(array, checkArray);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void bubbleSortException() throws UserException {
        service.bubbleSort(null);
    }

    @Test(dataProvider = "dataToSortValid")
    public void insertionSortValid(IntegerArray array, IntegerArray checkArray) {
        try {
            service.insertionSort(array);
            assertEquals(array, checkArray);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "dataToSortInvalid")
    public void insertionSortInvalid(IntegerArray array, IntegerArray checkArray) {
        try {
            service.insertionSort(array);
            assertNotEquals(array, checkArray);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void insertionSortException() throws UserException {
        service.insertionSort(null);
    }

    @Test(dataProvider = "dataToSortValid")
    public void selectionSortValid(IntegerArray array, IntegerArray checkArray) {
        try {
            service.selectionSort(array);
            assertEquals(array, checkArray);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "dataToSortInvalid")
    public void selectionSortInvalid(IntegerArray array, IntegerArray checkArray) {
        try {
            service.selectionSort(array);
            assertNotEquals(array, checkArray);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void selectionSortException() throws UserException {
        service.selectionSort(null);
    }


    @AfterClass
    public void tierDown() {
        service = null;
    }
}
