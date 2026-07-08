package by.sabrina.arraytask1.service.impl;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.service.ArrayCalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {

    private static final Logger LOGGER = LogManager.getLogger(ArrayCalculationServiceImpl.class);

    @Override
    public Optional<Integer> findMin(ArrayEntity array) {
        if (array == null) {
            LOGGER.error("ArrayEntity is null, returning Optional.empty()");
            return Optional.empty();
        }

        int[] values = array.getValues();
        if (values == null || values.length == 0) {
            LOGGER.warn("Array values are empty, returning Optional.empty()");
            return Optional.empty();
        }

        int min = values[0];
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }
        return Optional.of(min);
    }

    @Override
    public Optional<Integer> findMax(ArrayEntity array) {
        if (array == null) {
            LOGGER.error("ArrayEntity is null, returning Optional.empty()");
            return Optional.empty();
        }

        int[] values = array.getValues();
        if (values == null || values.length == 0) {
            LOGGER.warn("Array values are empty, returning Optional.empty()");
            return Optional.empty();
        }

        int max = values[0];
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return Optional.of(max);
    }

    @Override
    public Optional<Integer> sum(ArrayEntity array) {
        if (array == null) {
            LOGGER.error("ArrayEntity is null, returning Optional.empty()");
            return Optional.empty();
        }

        int[] values = array.getValues();
        if (values == null || values.length == 0) {
            LOGGER.warn("Array values are empty, returning Optional.empty()");
            return Optional.empty();
        }

        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> average(ArrayEntity array) {
        if (array == null) {
            LOGGER.error("ArrayEntity is null, returning Optional.empty()");
            return Optional.empty();
        }

        int[] values = array.getValues();
        if (values == null || values.length == 0) {
            LOGGER.warn("Array values are empty, returning Optional.empty()");
            return Optional.empty();
        }

        double sum = 0;
        for (int value : values) {
            sum += value;
        }
        return Optional.of(sum / values.length);
    }
}