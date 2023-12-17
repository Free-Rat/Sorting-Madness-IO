package org.sortingmadness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Sorter sorter = new Sorter();
        sorter.setSortingStrategy(SortingStrategyEnum.BUBBLE_SORT);

        Integer[] array = { 5, 4, 3, 2, 1 };
        // sorter.sort(array);
        sorter.getAlgorithm().sort(array);
    }
}
