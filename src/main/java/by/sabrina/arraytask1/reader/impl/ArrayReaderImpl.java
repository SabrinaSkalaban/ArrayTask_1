package by.sabrina.arraytask1.reader.impl;

import by.sabrina.arraytask1.exception.ArrayTaskException;
import by.sabrina.arraytask1.reader.ArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {

    private static final Logger LOGGER = LogManager.getLogger(ArrayReaderImpl.class);

    @Override
    public List<String> readLines(String filePath) throws ArrayTaskException {
        if (filePath == null || filePath.isEmpty()) {
            LOGGER.error("File path is null or empty");
            throw new ArrayTaskException("File path cannot be null or empty");
        }

        try {
            Path path = Path.of(filePath);
            List<String> lines = Files.readAllLines(path);
            LOGGER.info("Successfully read {} lines from {}", lines.size(), filePath);
            return lines;
        } catch (IOException e) {
            LOGGER.error("Error occurred while reading file: {}", filePath, e);
            throw new ArrayTaskException("Cannot read file: " + filePath, e);
        }
    }
}