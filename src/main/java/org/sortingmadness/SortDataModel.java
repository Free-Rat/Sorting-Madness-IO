package org.sortingmadness;

import jakarta.annotation.Nullable;
/**
 * Klasa modelu danych do sortowania
 * @param <T> typ danych do sortowania
 */
public class SortDataModel<T> {
    private T data;
    private String sortType;
    private Boolean descending = false;
    private Integer iterations = 0;

    public SortDataModel() {

    }
    /**
     * Konstruktor klasy SortDataModel
     * @param data dane do sortowania
     * @param sortType typ sortowania
     * @param descending czy sortować malejąco
     * @param iterations liczba iteracji
     */
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
    /**
     * Zdobywa dane do sortowania
     * @return dane do sortowania
     */
    public T getData() {
        return this.data;
    }
    /**
     * Usatwia dane do sortowania
     * @param data dane do sortowania
     */
    public void setData(T data) {
        this.data = data;
    }
    /**
     * Zdobywa typ sortowania
     * @return typ sortowania
     */
    public String getSortType() {
        return this.sortType;
    }
    /**
     * Ustawia typ sortowania
     * @param sortType typ sortowania
     */
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
    /**
     * Zdobywa informację czy sortować malejąco
     * @return informacja czy sortować malejąco
     */
    public Boolean IsDescending() {
        return this.descending;
    }
    /**
     * Ustawia informację czy sortować malejąco
     * @param descending informacja czy sortować malejąco
     */
    public void setDescending(Boolean descending) {
        this.descending = descending;
    }
    /**
     * Zdobywa liczbę iteracji
     * @return liczba iteracji
     */
    public Integer getIterations() {
        return this.iterations;
    }
    /**
     * Ustawia liczbę iteracji
     * @param iterations liczba iteracji
     */
    public void setIterations(Integer iterations) {
        this.iterations = iterations;
    }
}
