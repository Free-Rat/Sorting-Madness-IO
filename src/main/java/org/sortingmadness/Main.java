package org.sortingmadness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Klasa główna aplikacji
 */
@SpringBootApplication
public class Main {
    /**
     * Metoda główna aplikacji
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Sorter sorter = new Sorter();
        sorter.setSortingStrategy(SortingStrategyEnum.BUBBLE_SORT);

        int[] array = { 5, 4, 3, 2, 1 };
        sorter.getAlgorithm().sort(array);
    }
}
