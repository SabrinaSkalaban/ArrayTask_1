package by.sabrina.arraytask1.specification.impl;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.specification.Specification;

public class LengthSpecification implements Specification {
    private final int length;

    public LengthSpecification(int length) {
        this.length = length;
    }

    @Override
    public boolean specify(ArrayEntity entity) {
        return entity.getValues().length == length;
    }
}