package org.sortingmadness;

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        sorter.setSortingStrategy(SortingStrategyEnum.BUBBLE_SORT);

        Integer[] array = { 5, 4, 3, 2, 1 };
        // sorter.sort(array);
        sorter.getAlgorithm().sort(array);
    }
}
