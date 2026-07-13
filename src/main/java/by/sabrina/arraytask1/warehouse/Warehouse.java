package by.sabrina.arraytask1.warehouse;

import by.sabrina.arraytask1.entity.ArrayData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private final Map<Long, ArrayData> storage = new HashMap<>();

    private Warehouse() {}

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public ArrayData put(long id, ArrayData data) {
        logger.info("Updating warehouse for array ID: {}", id);
        return storage.put(id, data);
    }

    public Optional<ArrayData> get(long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public void remove(long id) {
        storage.remove(id);
    }
}