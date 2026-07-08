package by.sabrina.arraytask1.parser;

import by.sabrina.arraytask1.exception.ArrayTaskException;

public interface ArrayParser {
    int[] parse(String lineData) throws ArrayTaskException;
}