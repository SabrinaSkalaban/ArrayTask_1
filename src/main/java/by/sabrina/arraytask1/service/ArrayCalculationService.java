package by.sabrina.arraytask1.service;

import by.sabrina.arraytask1.entity.ArrayEntity;
import java.util.Optional;

public interface ArrayCalculationService {
    Optional<Integer> findMin(ArrayEntity array);
    Optional<Integer> findMax(ArrayEntity array);
    Optional<Integer> sum(ArrayEntity array);
    Optional<Double> average(ArrayEntity array);
}