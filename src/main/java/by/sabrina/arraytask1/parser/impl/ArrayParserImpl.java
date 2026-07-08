package by.sabrina.arraytask1.parser.impl;

import by.sabrina.arraytask1.exception.ArrayTaskException;
import by.sabrina.arraytask1.parser.ArrayParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.sabrina.arraytask1.constant.ArrayRegex;

public class ArrayParserImpl implements ArrayParser {

    private static final Logger LOGGER = LogManager.getLogger(ArrayParserImpl.class);


    @Override
    public int[] parse(String lineData) throws ArrayTaskException {
        if (lineData == null || lineData.isBlank()) {
            LOGGER.error("Line for parsing is null or empty");
            throw new ArrayTaskException("String line to parse cannot be null or empty");
        }

        LOGGER.info("Starting to parse line: {}", lineData);
        String[] stringNumbers = lineData.split(ArrayRegex.DELIMITER_REGEX);
        int[] result = new int[stringNumbers.length];

        try {
            for (int i = 0; i < stringNumbers.length; i++) {
                result[i] = Integer.parseInt(stringNumbers[i]);
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Failed to parse number in line: {}", lineData, e);
            throw new ArrayTaskException("Error while parsing numbers in line: " + lineData, e);
        }

        LOGGER.info("Successfully parsed {} elements into int array", result.length);
        return result;
    }
}