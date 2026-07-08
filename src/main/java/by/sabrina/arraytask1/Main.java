package by.sabrina.arraytask1;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.exception.ArrayTaskException;
import by.sabrina.arraytask1.factory.ArrayFactory;
import by.sabrina.arraytask1.factory.impl.ArrayFactoryImpl;
import by.sabrina.arraytask1.parser.ArrayParser;
import by.sabrina.arraytask1.parser.impl.ArrayParserImpl;
import by.sabrina.arraytask1.reader.ArrayReader;
import by.sabrina.arraytask1.reader.impl.ArrayReaderImpl;
import by.sabrina.arraytask1.service.ArrayCalculationService;
import by.sabrina.arraytask1.service.impl.ArrayCalculationServiceImpl;
import by.sabrina.arraytask1.service.ArraySortService;
import by.sabrina.arraytask1.service.impl.ArraySortServiceImpl;
import by.sabrina.arraytask1.validator.ArrayValidator;
import by.sabrina.arraytask1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public void run() {
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParser parser = new ArrayParserImpl();
        ArrayReader reader = new ArrayReaderImpl();
        ArrayFactory factory = new ArrayFactoryImpl();
        ArrayCalculationService calculationService = new ArrayCalculationServiceImpl();
        ArraySortService sortService = new ArraySortServiceImpl();

        try {
            List<String> lines = reader.readLines("data/input.txt");
            int index = 1;
            for (String line : lines) {
                processLine(line, index, validator, parser, factory, calculationService, sortService);
                index++;
            }
        } catch (ArrayTaskException e) {
            LOGGER.error("Application processing failed due to critical error: {}", e.getMessage(), e);
        }
    }

    private void processLine(
            String lineData,
            int index,
            ArrayValidator validator,
            ArrayParser parser,
            ArrayFactory factory,
            ArrayCalculationService calculationService,
            ArraySortService sortService) {

        if (lineData != null && !lineData.isBlank() && validator.isValidLine(lineData)) {
            try {
                int[] parsedValues = parser.parse(lineData);
                ArrayEntity arrayEntity = factory.createArray(parsedValues);

                LOGGER.info("Line {}: Created array: {}", index, arrayEntity);

                calculationService.findMin(arrayEntity).ifPresent(v -> LOGGER.info("Minimum: {}", v));
                calculationService.findMax(arrayEntity).ifPresent(v -> LOGGER.info("Maximum: {}", v));
                calculationService.sum(arrayEntity).ifPresent(v -> LOGGER.info("Sum: {}", v));
                calculationService.average(arrayEntity).ifPresent(v -> LOGGER.info("Average: {}", v));

                sortService.bubbleSort(arrayEntity);
                LOGGER.info("Bubble sorted: {}", arrayEntity);

            } catch (ArrayTaskException e) {
                LOGGER.error("Line {} failed during processing: {}", index, e.getMessage());
            }
        } else {
            LOGGER.warn("Line {} was skipped: Invalid or empty data", index);
        }
    }

    public static void main(String[] args) {
        Main application = new Main();
        application.run();
    }
}