package by.sabrina.arraytask1.service.impl;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySortServiceImpl implements ArraySortService {

    private static final Logger LOGGER = LogManager.getLogger(ArraySortServiceImpl.class);

    @Override
    public void bubbleSort(ArrayEntity array) {
        if (isInvalid(array)) {
            return;
        }
        LOGGER.info("Starting bubble sort");
        int[] v = array.getValues();
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
        array.setValues(v);
        LOGGER.info("Bubble sort finished successfully");
    }

    @Override
    public void selectionSort(ArrayEntity array) {
        if (isInvalid(array)) {
            return;
        }
        LOGGER.info("Starting selection sort");
        int[] v = array.getValues();
        for (int i = 0; i < v.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = v[i];
            v[i] = v[minIndex];
            v[minIndex] = temp;
        }
        array.setValues(v);
        LOGGER.info("Selection sort finished successfully");
    }

    private boolean isInvalid(ArrayEntity array) {
        if (array == null || array.getValues() == null || array.getValues().length == 0) {
            LOGGER.warn("Sorting skipped: ArrayEntity is empty or null");
            return true;
        }
        return false;
    }
}