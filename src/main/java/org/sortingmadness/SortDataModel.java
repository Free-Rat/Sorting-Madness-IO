package org.sortingmadness;

import jakarta.annotation.Nullable;

public class SortDataModel<T> {
    private T data;
    private String sortType;
    private Boolean descending = false;
    private Integer iterations = 0;

    public SortDataModel() {

    }

    public SortDataModel(T data, String sortType, @Nullable Boolean descending, @Nullable Integer iterations) {
        this.data = data;
        this.sortType = sortType;
        if (descending != null) {
            this.descending = descending;
        }
        if (iterations != null) {
            this.iterations = iterations;
        }
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

    public Boolean IsDescending() {
        return this.descending;
    }

    public void setDescending(Boolean descending) {
        this.descending = descending;
    }

    public Integer getIterations() {
        return this.iterations;
    }

    public void setIterations(Integer iterations) {
        this.iterations = iterations;
    }
}
