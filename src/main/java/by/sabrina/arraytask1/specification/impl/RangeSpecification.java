package by.sabrina.arraytask1.specification.impl;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.specification.Specification;
import by.sabrina.arraytask1.warehouse.Warehouse;

public class RangeSpecification implements Specification {
    private final int minRange;
    private final int maxRange;

    public RangeSpecification(int minRange, int maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    @Override
    public boolean specify(ArrayEntity entity) {
        return Warehouse.getInstance().get(entity.getId())
                .map(data -> data.min() >= minRange && data.max() <= maxRange)
                .orElse(false);
    }
}