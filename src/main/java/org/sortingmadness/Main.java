package org.sortingmadness;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        Sorter sorter = new Sorter();
        sorter.setSortingStrategy(SortingStrategyEnum.BUBBLE_SORT);

        int[] array = { 5, 4, 3, 2, 1 };
        // sorter.sort(array);
        sorter.performSort(array);
    }
}
