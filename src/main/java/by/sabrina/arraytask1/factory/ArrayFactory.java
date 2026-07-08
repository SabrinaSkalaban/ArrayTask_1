package by.sabrina.arraytask1.factory;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.exception.ArrayTaskException;

public interface ArrayFactory {
    ArrayEntity createArray(int[] values) throws ArrayTaskException;
}