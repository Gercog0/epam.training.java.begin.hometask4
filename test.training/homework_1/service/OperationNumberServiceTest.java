package homework_1.service;

import by.training.homework4_1.service.OperationNumberService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OperationNumberServiceTest {
    OperationNumberService operationNumberService;

    @BeforeClass
    public void setUp() {
        operationNumberService = new OperationNumberService();
    }

    @Test
    public void isNumberPrimeValid() {
        boolean condition = operationNumberService.isNumberPrime(31);
        assertTrue(condition);
    }

    @Test
    public void isNumberPrimeInvalid() {
        boolean condition = operationNumberService.isNumberPrime(8);
        assertFalse(condition);
    }

    @Test
    public void isNumberFibonacciValid() {
        boolean condition = operationNumberService.isNumberFibonacci(5);
        assertTrue(condition);
    }

    @Test
    public void isNumberFibonacciInvalid() {
        boolean condition = operationNumberService.isNumberFibonacci(4);
        assertFalse(condition);
    }

    @Test
    public void isNumberExcellentValid() {
        boolean condition = operationNumberService.isNumberExcellent(123);
        assertTrue(condition);
    }

    @Test
    public void isNumberExcellentInvalid() {
        boolean condition = operationNumberService.isNumberExcellent(121);
        assertFalse(condition);
    }

    @AfterClass
    public void tierDown() {
        operationNumberService = null;
    }
}
