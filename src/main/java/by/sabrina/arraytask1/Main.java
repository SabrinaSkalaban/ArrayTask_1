package by.sabrina.arraytask1;

import by.sabrina.arraytask1.comparator.ArrayComparator;
import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.exception.ArrayTaskException;
import by.sabrina.arraytask1.factory.ArrayFactory;
import by.sabrina.arraytask1.factory.impl.ArrayFactoryImpl;
import by.sabrina.arraytask1.parser.ArrayParser;
import by.sabrina.arraytask1.parser.impl.ArrayParserImpl;
import by.sabrina.arraytask1.reader.ArrayReader;
import by.sabrina.arraytask1.reader.impl.ArrayReaderImpl;
import by.sabrina.arraytask1.repository.Repository;
import by.sabrina.arraytask1.repository.impl.RepositoryImpl;
import by.sabrina.arraytask1.service.ArrayCalculationService;
import by.sabrina.arraytask1.service.impl.ArrayCalculationServiceImpl;
import by.sabrina.arraytask1.specification.impl.SumSpecification;
import by.sabrina.arraytask1.validator.ArrayValidator;
import by.sabrina.arraytask1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public void run() {
        // Инициализация компонентов
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParser parser = new ArrayParserImpl();
        ArrayReader reader = new ArrayReaderImpl();
        ArrayFactory factory = new ArrayFactoryImpl();
        ArrayCalculationService calcService = new ArrayCalculationServiceImpl();
        Repository repository = new RepositoryImpl();

        try {
            // 1. Чтение данных
            List<String> lines = reader.readLines("data/input.txt");

            // 2. Обработка данных и добавление в репозиторий
            for (String line : lines) {
                if (validator.isValidLine(line)) {
                    int[] values = parser.parse(line);
                    ArrayEntity entity = factory.createArray(values);
                    repository.add(entity);
                    LOGGER.info("Successfully added to repository: {}", entity);
                }
            }

            // 3. Демонстрация спецификации (поиск массивов с суммой > 50)
            LOGGER.info("--- Querying repository (Sum > 50) ---");
            List<ArrayEntity> filtered = repository.query(new SumSpecification(50));
            filtered.forEach(e -> LOGGER.info("Found: {}", e));

            // 4. Демонстрация сортировки через компаратор
            LOGGER.info("--- Sorting repository by Size ---");
            List<ArrayEntity> all = repository.getAll();
            all.sort(ArrayComparator.BY_SIZE);
            all.forEach(e -> LOGGER.info("Sorted: {}", e));

        } catch (ArrayTaskException e) {
            LOGGER.error("Critical error in application: {}", e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}