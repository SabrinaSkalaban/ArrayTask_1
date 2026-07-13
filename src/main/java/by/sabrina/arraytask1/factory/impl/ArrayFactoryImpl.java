package by.sabrina.arraytask1.factory.impl;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.exception.ArrayTaskException;
import by.sabrina.arraytask1.factory.ArrayFactory;
import java.util.concurrent.atomic.AtomicLong;

public class ArrayFactoryImpl implements ArrayFactory {

    private static final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public ArrayEntity createArray(int[] values) throws ArrayTaskException {
        if (values == null) {
            throw new ArrayTaskException("Cannot create ArrayEntity with null array values");
        }

        long id = idGenerator.getAndIncrement();
        return new ArrayEntity(id, values);
    }
}