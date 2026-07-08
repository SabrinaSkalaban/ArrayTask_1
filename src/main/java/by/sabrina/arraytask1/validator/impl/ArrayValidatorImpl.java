package by.sabrina.arraytask1.validator.impl;

import by.sabrina.arraytask1.validator.ArrayValidator;
import by.sabrina.arraytask1.constant.ArrayRegex;

public class ArrayValidatorImpl implements ArrayValidator {

    @Override
    public boolean isValidLine(String lineData) {
        return lineData != null && lineData.matches(ArrayRegex.INTEGER_ARRAY_PATTERN);
    }
}