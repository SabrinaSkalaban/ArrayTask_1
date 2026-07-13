package by.sabrina.arraytask1.comparator;

import by.sabrina.arraytask1.entity.ArrayEntity;
import java.util.Arrays;
import java.util.Comparator;

public enum ArrayComparator implements Comparator<ArrayEntity> {

    BY_ID(Comparator.comparingLong(ArrayEntity::getId)),
    BY_SIZE(Comparator.comparingInt(a -> a.getValues().length)),
    BY_SUM(Comparator.comparingInt(a -> Arrays.stream(a.getValues()).sum())),
    BY_AVG(Comparator.comparingDouble(a -> Arrays.stream(a.getValues()).average().orElse(0.0))),
    BY_MIN(Comparator.comparingInt(a -> Arrays.stream(a.getValues()).min().orElse(0))),
    BY_MAX(Comparator.comparingInt(a -> Arrays.stream(a.getValues()).max().orElse(0)));

    private final Comparator<ArrayEntity> comparator;

    ArrayComparator(Comparator<ArrayEntity> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(ArrayEntity o1, ArrayEntity o2) {
        return comparator.compare(o1, o2);
    }
}