package by.sabrina.arraytask1.entity;

import java.util.Arrays;

public class ArrayEntity {
    private int[] values;

    public ArrayEntity() {
        this.values = new int[0];
    }

    public ArrayEntity(int[] values) {
        this.values = (values != null) ? values.clone() : new int[0];
    }

    public int[] getValues() {
        return values.clone();
    }

    public void setValues(int[] values) {
        this.values = (values != null) ? values.clone() : new int[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayEntity that = (ArrayEntity) o;
        return Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}