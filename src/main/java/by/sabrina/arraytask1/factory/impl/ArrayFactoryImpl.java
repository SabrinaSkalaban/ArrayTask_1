package by.sabrina.arraytask1.factory.impl;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.exception.ArrayTaskException;
import by.sabrina.arraytask1.factory.ArrayFactory;

public class ArrayFactoryImpl implements ArrayFactory {

    @Override
    public ArrayEntity createArray(int[] values) throws ArrayTaskException {
        if (values == null) {
            throw new ArrayTaskException("Cannot create ArrayEntity with null array values");
        }
        return new ArrayEntity(values);
    }
}