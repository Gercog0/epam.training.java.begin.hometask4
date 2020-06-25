package homework_1.service;

import by.training.homework4_1.entity.IntegerArray;
import by.training.homework4_1.exception.UserException;
import by.training.homework4_1.service.SearchArrayService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchArrayServiceTest {
    SearchArrayService service;

    @BeforeClass
    public void setUp() {
        service = new SearchArrayService();
    }

    @DataProvider(name = "arrayWithMaxElementValid")
    public Object[][] createArrayDataWithMaxElementValid() {
        return new Object[][]{
                {new IntegerArray(5, 12, 4, 13, 5), 13},
                {new IntegerArray(53, 112, 324, 14333, 5213), 14333},
                {new IntegerArray(4, 1213, 21, 23, 0), 1213}};
    }

    @DataProvider(name = "arrayWithMaxElementInvalid")
    public Object[][] createArrayDataWithMaxElementInvalid() {
        return new Object[][]{
                {new IntegerArray(5, 12, 4, 13, 5), 4},
                {new IntegerArray(53, 112, 324, 14333, 5213), 53},
                {new IntegerArray(4, 1213, 21, 23, 0), 4}};
    }

    @DataProvider(name = "arrayWithMinElementValid")
    public Object[][] createArrayDataWithMinElementValid() {
        return new Object[][]{
                {new IntegerArray(5, 12, 4, 13, 5), 4},
                {new IntegerArray(53, 112, 324, 14333, 5213), 53},
                {new IntegerArray(4, 1213, 21, 23, 0), 0}};
    }

    @DataProvider(name = "arrayWithMinElementInvalid")
    public Object[][] createArrayDataWithMinElementInvalid() {
        return new Object[][]{
                {new IntegerArray(5, 12, 4, 13, 5), 13},
                {new IntegerArray(53, 112, 324, 14333, 5213), 112},
                {new IntegerArray(4, 1213, 21, 23, 0), 4}};
    }

    @Test(dataProvider = "arrayWithMaxElementValid")
    public void searchMaxElementValid(IntegerArray array, int maxElement) {
        try {
            int expected = maxElement;
            int actual = service.searchMaxElement(array);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "arrayWithMaxElementInvalid")
    public void searchMaxElementInvalid(IntegerArray array, int maxElement) {
        try {
            int expected = maxElement;
            int actual = service.searchMaxElement(array);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void searchMaxElementException() throws UserException {
        service.searchMaxElement(null);
    }

    @Test(dataProvider = "arrayWithMinElementValid")
    public void searchMinElementValid(IntegerArray array, int minElement) {
        try {
            int expected = minElement;
            int actual = service.searchMinElement(array);
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "arrayWithMinElementInvalid")
    public void searchMinElementInvalid(IntegerArray array, int minElement) {
        try {
            int expected = minElement;
            int actual = service.searchMinElement(array);
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void searchMinElementException() throws UserException {
        service.searchMinElement(null);
    }

    @Test
    public void searchBinaryValid() {
        try {
            int expected = 1;
            int actual = service.searchBinary(5,
                    new IntegerArray(0, 5, 10, 40, 50, 500, 900, 1000));
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test
    public void searchBinaryInvalid() {
        try {
            int expected = 1;
            int actual = service.searchBinary(5,
                    new IntegerArray(0, 6, 10, 40, 50, 500, 900, 1000));
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void searchBinaryException() throws UserException {
        service.searchBinary(5, null);
    }

    @Test
    public void searchPrimeNumbersValid() {
        try {
            IntegerArray expected = new IntegerArray(7, 11, 31, 37);
            IntegerArray actual = service.searchPrimeNumbers(
                    new IntegerArray(540, 7, 292, 11, 0, 31, 44, 37, 800));
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test
    public void searchPrimeNumbersInvalid() {
        try {
            IntegerArray expected = new IntegerArray(7, 11, 31, 37);
            IntegerArray actual = service.searchPrimeNumbers(
                    new IntegerArray(540, 5, 292, 11, 0, 31, 44, 37, 800));
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void searchPrimeNumbersException() throws UserException {
        service.searchPrimeNumbers(null);
    }

    // TODO: 25.06.2020  
    // fibonacci and excellent numbers tests

    @AfterClass
    public void tierDown() {
        service = null;
    }
}
