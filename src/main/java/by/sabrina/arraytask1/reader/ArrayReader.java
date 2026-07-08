package by.sabrina.arraytask1.reader;

import by.sabrina.arraytask1.exception.ArrayTaskException;
import java.util.List;

public interface ArrayReader {
    List<String> readLines(String filePath) throws ArrayTaskException;
}