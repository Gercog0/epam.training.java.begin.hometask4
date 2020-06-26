package homework_1.parser;

import by.training.homework4_1.exception.UserException;
import by.training.homework4_1.parser.FileParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileParserTest {
    FileParser parser;

    @BeforeClass
    public void setUp() {
        parser = new FileParser();
    }

    @Test
    public void parseStringToIntegerArrayValid() {
        try {
            int[] expected = new int[]{5, 10, 2};
            int[] actual = parser.parseStringToIntegerArray(
                    new String[]{"5", "10", "2"});
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test
    public void parseStringToIntegerArrayInvalid() {
        try {
            int[] expected = new int[]{-2, 0, 3};
            int[] actual = parser.parseStringToIntegerArray(
                    new String[]{"5", "10", "2"});
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void parseStringToIntegerArrayException() throws UserException {
        parser.parseStringToIntegerArray(null);
    }

    @AfterClass
    public void tierDown() {
        parser = null;
    }
}
