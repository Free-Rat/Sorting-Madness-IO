package org.sortingmadness;

public class SortDataModel<T> {
    private T data;

    public SortDataModel(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
