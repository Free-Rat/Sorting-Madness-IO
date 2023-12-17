package org.sortingmadness;

public class SortDataModel<T> {
    private T data;
    private String sortType;

    public SortDataModel() {

    }

    public SortDataModel(T data, String sortType) {
        this.data = data;
        this.sortType = sortType;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getSortType() {
        return this.sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}
