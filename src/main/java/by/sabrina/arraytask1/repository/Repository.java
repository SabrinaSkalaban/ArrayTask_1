package by.sabrina.arraytask1.repository;

import by.sabrina.arraytask1.entity.ArrayEntity;
import by.sabrina.arraytask1.specification.Specification;
import java.util.List;

public interface Repository {
    void add(ArrayEntity entity);
    void remove(ArrayEntity entity);
    List<ArrayEntity> query(Specification spec);
    List<ArrayEntity> getAll();
}