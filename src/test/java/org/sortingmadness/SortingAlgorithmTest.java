package org.sortingmadness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmTest {

    @Test
    void bubbleSortAsc() {
        int[] refArray = { 5, 4, 3, 2, 1 };
        int[] expectedArray = { 1, 2, 3, 4, 5 };
        int[] bubbleArray = refArray.clone();

        var bubbleSorter = new BubbleSort();
        bubbleSorter.setSortingAlgorithmDirection(true);
        bubbleSorter.sort(bubbleArray);

        assertArrayEquals(expectedArray, bubbleArray);
    }

    @Test
    void bubbleSortDesc() {
        int[] refArray = { 1, 2, 3, 4, 5 };
        int[] expectedArray = { 5, 4, 3, 2, 1 };
        int[] bubbleArray = refArray.clone();

        var bubbleSorter = new BubbleSort();
        bubbleSorter.setSortingAlgorithmDirection(false);
        bubbleSorter.sort(bubbleArray);

        assertArrayEquals(expectedArray, bubbleArray);
    }

    @Test
    void mergeSortAsc() {
        int[] refArray = { 5, 4, 3, 2, 1 };
        int[] expectedArray = { 1, 2, 3, 4, 5 };
        int[] mergeArray = refArray.clone();

        var mergeSorter = new MergeSort();
        mergeSorter.setSortingAlgorithmDirection(true);
        mergeSorter.sort(mergeArray);

        assertArrayEquals(expectedArray, mergeArray);
    }

    @Test
    void mergeSortDesc() {
        int[] refArray = { 1, 2, 3, 4, 5 };
        int[] expectedArray = { 5, 4, 3, 2, 1 };
        int[] mergeArray = refArray.clone();

        var mergeSorter = new MergeSort();
        mergeSorter.setSortingAlgorithmDirection(false);
        mergeSorter.sort(mergeArray);

        assertArrayEquals(expectedArray, mergeArray);
    }

    @Test
    void quickSortAsc() {
        int[] refArray = { 5, 4, 3, 2, 1 };
        int[] expectedArray = { 1, 2, 3, 4, 5 };
        int[] quickArray = refArray.clone();

        var quickSorter = new QuickSort();
        quickSorter.setSortingAlgorithmDirection(true);
        quickSorter.sort(quickArray);

        assertArrayEquals(expectedArray, quickArray);
    }

    @Test
    void quickSortDesc() {
        int[] refArray = { 1, 2, 3, 4, 5 };
        int[] expectedArray = { 5, 4, 3, 2, 1 };
        int[] quickArray = refArray.clone();

        var quickSorter = new QuickSort();
        quickSorter.setSortingAlgorithmDirection(false);
        quickSorter.sort(quickArray);

        assertArrayEquals(expectedArray, quickArray);
    }

}