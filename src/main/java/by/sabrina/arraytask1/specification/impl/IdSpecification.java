package by.sabrina.arraytask1.specification.impl;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.specification.Specification;

public class IdSpecification implements Specification {
    private final long targetId;

    public IdSpecification(long targetId) {
        this.targetId = targetId;
    }

    @Override
    public boolean specify(ArrayEntity entity) {
        return entity.getId() == targetId;
    }
}