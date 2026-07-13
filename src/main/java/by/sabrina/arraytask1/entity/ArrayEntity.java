package by.sabrina.arraytask1.entity;

import by.sabrina.arraytask1.observer.Observer;

import java.util.Arrays;

public class ArrayEntity {
    private final long id;
    private int[] values;
    private Observer observer;

    public ArrayEntity(long id, int[] values) {
        this.id = id;
        this.values = (values != null) ? values.clone() : new int[0];
    }


    public long getId() {
        return id;
    }

    public int[] getValues() {
        return values.clone();
    }

    public void setValues(int[] values) {
        this.values = (values != null) ? values.clone() : new int[0];
        notifyObserver();
    }

    public void setElement(int index, int value) {
        if (index >= 0 && index < values.length) {
            this.values[index] = value;
            notifyObserver();
        }
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    private void notifyObserver() {
        if (observer != null) {
            observer.onUpdate(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayEntity that = (ArrayEntity) o;
        return id == that.id && Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = Long.hashCode(id);
        result = prime * result + Arrays.hashCode(values);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayEntity{id=" + id + ", values=" + Arrays.toString(values) + "}";
    }
}