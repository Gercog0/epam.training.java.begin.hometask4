package homework_1.service;

import by.training.homework4_1.entity.IntegerArray;
import by.training.homework4_1.exception.UserException;
import by.training.homework4_1.service.OperationArrayService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OperationArrayServiceTest {
    OperationArrayService operationArrayService;

    @BeforeClass
    public void setUp() {
        operationArrayService = new OperationArrayService();
    }

    @DataProvider(name = "arrayData")
    public Object[] createArrayData() {
        return new Object[]{
                new IntegerArray(5, 12, 4, 13, 5),
                new IntegerArray(53, 112, 324, 14333, 5213),
                new IntegerArray(4, 1213, 21, 23, 0)};
    }

    @Test(dataProvider = "arrayData")
    public void swapElementValid(IntegerArray array) {
        try {
            assertTrue(operationArrayService.swapElements(array, 1, 2));
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(dataProvider = "arrayData")
    public void swapElementInvalid(IntegerArray array) {
        try {
            assertFalse(operationArrayService.swapElements(array, -1, 20));
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void swapElementException() throws UserException {
        operationArrayService.swapElements(null, 1, 0);
    }

    @AfterClass
    public void tierDown() {
        operationArrayService = null;
    }
}
