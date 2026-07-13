package by.sabrina.arraytask1.repository.impl;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.repository.Repository;
import by.sabrina.arraytask1.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryImpl implements Repository {
    private static final Logger logger = LogManager.getLogger();
    private final List<ArrayEntity> storage = new ArrayList<>();

    @Override
    public void add(ArrayEntity entity) {
        storage.add(entity);
        logger.info("Added to repository: ID={}", entity.getId());
    }

    @Override
    public void remove(ArrayEntity entity) {
        storage.remove(entity);
        logger.info("Removed from repository: ID={}", entity.getId());
    }

    @Override
    public List<ArrayEntity> query(Specification spec) {
        logger.info("Executing query with: {}", spec.getClass().getSimpleName());
        return storage.stream()
                .filter(spec::specify)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArrayEntity> getAll() {
        return Collections.unmodifiableList(storage);
    }
}