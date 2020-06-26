package homework_1.creator;

import by.training.homework4_1.creator.IntegerArrayCreator;
import by.training.homework4_1.entity.IntegerArray;
import by.training.homework4_1.exception.UserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IntegerArrayCreatorTest {
    IntegerArrayCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new IntegerArrayCreator();
    }

    @Test
    public void createArrayByFileValid() {
        try {
            IntegerArray expected = new IntegerArray(5, 10, 2);
            IntegerArray actual = creator.createArrayByFile("data.txt");
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception");
        }
    }

    @Test
    public void createArrayByFileInvalid() {
        try {
            IntegerArray expected = new IntegerArray(5, 10, 5);
            IntegerArray actual = creator.createArrayByFile("data.txt");
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void createArrayByFileException() throws UserException {
        creator.createArrayByFile(null);
    }

    @AfterClass
    public void tierDown() {
        creator = null;
    }
}

