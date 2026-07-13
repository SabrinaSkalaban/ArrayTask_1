package by.sabrina.arraytask1.specification.impl;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.specification.Specification;
import by.sabrina.arraytask1.warehouse.Warehouse;

public class SumSpecification implements Specification {
    private final int sumValue;

    public SumSpecification(int sumValue) {
        this.sumValue = sumValue;
    }

    @Override
    public boolean specify(ArrayEntity entity) {
        return Warehouse.getInstance().get(entity.getId())
                .map(data -> data.sum() == sumValue)
                .orElse(false);
    }
}