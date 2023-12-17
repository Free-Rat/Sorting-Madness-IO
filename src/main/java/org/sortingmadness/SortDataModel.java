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

    public T GetData() {
        return this.data;
    }

    public String GetSortType() {
        return this.sortType;
    }

    public Boolean IsDescending() {
        return this.descending;
    }

    public Integer Iterations() {
        return this.iterations;
    }

    public void SetData(T data) {
        this.data = data;
    }
}
