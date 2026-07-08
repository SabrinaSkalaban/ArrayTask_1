package by.sabrina.arraytask1.service;

import by.sabrina.arraytask1.service.impl.ArraySortServiceImpl;
import by.sabrina.arraytask1.entity.ArrayEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortServiceImplTest {

    private ArraySortServiceImpl sortService;

    @BeforeEach
    void setUp() {
        sortService = new ArraySortServiceImpl();
    }

    @Test
    void testBubbleSortSuccess() {
        ArrayEntity array = new ArrayEntity(new int[]{5, -2, 0, 3, 1});
        sortService.bubbleSort(array);

        int[] expected = {-2, 0, 1, 3, 5};
        assertArrayEquals(expected, array.getValues());
    }

    @Test
    void testSelectionSortSuccess() {
        ArrayEntity array = new ArrayEntity(new int[]{10, 4, 1, 8, 2});
        sortService.selectionSort(array);

        int[] expected = {1, 2, 4, 8, 10};
        assertArrayEquals(expected, array.getValues());
    }

    @Test
    void testBubbleSortWithNullArray() {
        assertDoesNotThrow(() -> sortService.bubbleSort(null));
    }
}