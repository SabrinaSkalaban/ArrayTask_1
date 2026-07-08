package by.sabrina.arraytask1.service;

import by.sabrina.arraytask1.service.impl.ArrayCalculationServiceImpl;
import by.sabrina.arraytask1.entity.ArrayEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCalculationServiceImplTest {

    private ArrayCalculationServiceImpl service;
    private ArrayEntity validArray;
    private ArrayEntity emptyArray;

    @BeforeEach
    void setUp() {
        service = new ArrayCalculationServiceImpl();
        validArray = new ArrayEntity(new int[]{3, 1, 4, 1, 5});
        emptyArray = new ArrayEntity(new int[]{});
    }

    @Test
    void testFindMinSuccess() {
        Optional<Integer> result = service.findMin(validArray);
        assertTrue(result.isPresent());
        assertEquals(1, result.get());
    }

    @Test
    void testFindMinEmpty() {
        Optional<Integer> result = service.findMin(emptyArray);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindMaxSuccess() {
        Optional<Integer> result = service.findMax(validArray);
        assertTrue(result.isPresent());
        assertEquals(5, result.get());
    }

    @Test
    void testSumSuccess() {
        Optional<Integer> result = service.sum(validArray);
        assertTrue(result.isPresent());
        assertEquals(14, result.get());
    }

    @Test
    void testAverageSuccess() {
        Optional<Double> result = service.average(validArray);
        assertTrue(result.isPresent());
        assertEquals(2.8, result.get(), 0.001);
    }

    @Test
    void testFindMinWithNullArray() {
        Optional<Integer> result = service.findMin(null);
        assertTrue(result.isEmpty());
    }
}