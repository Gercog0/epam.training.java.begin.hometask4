package homework_1.validator;

import by.training.homework4_1.entity.IntegerArray;
import by.training.homework4_1.exception.UserException;
import by.training.homework4_1.validator.ArrayValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayValidatorTest {
    ArrayValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new ArrayValidator();
    }

    @DataProvider(name = "arrayWithValidIndex")
    public static Object[] createDataValid() {
        return new Object[][]{
                {new IntegerArray(15, -5, 12, 3, 5, 0), 2},
                {new IntegerArray(12, -7, 32, 100, 974), 3},
                {new IntegerArray(0, 1, 12, 17, 45), 4},
                {new IntegerArray(2, -2, 8, 20174, 435), 0},
                {new IntegerArray(45, 21, 18, 10001, 9749), 1}};
    }

    @DataProvider(name = "arrayWithInvalidIndex")
    public static Object[] createDataInvalid() {
        return new Object[][]{
                {new IntegerArray(1532, -235, 112, 33, 215, 330), 13},
                {new IntegerArray(1286, -723, 322, 1004, 9744), 20},
                {new IntegerArray(0, 1, 12, 17, 45), -1111},
                {new IntegerArray(2423, -46782, 85435, 2017453, 435), -2},
                {new IntegerArray(453, 211, 1228, 130001, 9749), -2}};
    }

    @DataProvider(name = "arraySorted")
    public static Object[] createSortArray() {
        return new Object[]{
                new IntegerArray(1, 2, 3, 4, 5),
                new IntegerArray(-5, 0, 5, 10, 20),
                new IntegerArray(1000, 2000, 3000, 4000, 5000),
                new IntegerArray(0, 0, 1, 1, 1),
                new IntegerArray(21, 210, 21000, 210000, 500000)};
    }

    @DataProvider(name = "arrayNotSorted")
    public static Object[] createNotSortArray() {
        return new Object[]{
                new IntegerArray(23, 1, 4, 0, 1),
                new IntegerArray(1, 1, 1, 0, 0, 4),
                new IntegerArray(3000, 2000, 3000, 6000, 5000),
                new IntegerArray(0, 0, 1, 1, -5),
                new IntegerArray(21, -210, 21000, 10000, 500000)};
    }

    @Test(dataProvider = "arrayWithValidIndex")
    public void ValidateArrayBoundsValid(IntegerArray array, int index) {
        assertTrue(validator.validateArrayBounds(array, index));
    }

    @Test(dataProvider = "arrayWithInvalidIndex")
    public void ValidateArrayBoundsInvalid(IntegerArray array, int index) {
        assertFalse(validator.validateArrayBounds(array, index));
    }

    @Test(dataProvider = "arraySorted")
    public void isArraySortedValid(IntegerArray array) {
        try {
            assertTrue(validator.isArraySorted(array));
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "arrayNotSorted")
    public void isArraySortedInvalid(IntegerArray array) {
        try {
            assertFalse(validator.isArraySorted(array));
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void isArraySortedException() throws UserException {
        validator.isArraySorted(null);
    }


    @AfterClass
    public void tierDown() {
        validator = null;
    }
}
