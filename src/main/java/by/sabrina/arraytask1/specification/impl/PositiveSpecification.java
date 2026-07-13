package by.sabrina.arraytask1.specification.impl;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.specification.Specification;
import by.sabrina.arraytask1.warehouse.Warehouse;

public class PositiveSpecification implements Specification {

    @Override
    public boolean specify(ArrayEntity entity) {
        return Warehouse.getInstance().get(entity.getId())
                .map(data -> data.min() > 0)
                .orElse(false);
    }
}