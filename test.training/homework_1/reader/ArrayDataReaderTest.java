package homework_1.reader;

import by.training.homework4_1.exception.UserException;
import by.training.homework4_1.reader.ArrayDataReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayDataReaderTest {
    ArrayDataReader reader;

    @BeforeClass
    public void setUp() {
        reader = new ArrayDataReader();
    }

    @Test
    public void dataReaderValid() {
        try {
            String[] expected = new String[]{"5", "10", "2"};
            String[] actual = reader.dataReader("data.txt");
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test
    public void dataReaderInvalid() {
        try {
            String[] expected = new String[]{"5", "10", "3"};
            String[] actual = reader.dataReader("data.txt");
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("Exception...");
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void dataReaderException() throws UserException {
        reader.dataReader(null);
    }


    @AfterClass
    public void tierDown() {
        reader = null;
    }
}
