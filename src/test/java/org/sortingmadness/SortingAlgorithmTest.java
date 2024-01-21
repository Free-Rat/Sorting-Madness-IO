package org.sortingmadness;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SortingAlgorithmTest {

    @Test
    void bubbleSortAsc() {
        int[] refArray = { 5, 4, 3, 2, 1 };
        int[] expectedArray = { 1, 2, 3, 4, 5 };
        int[] bubbleArray = refArray.clone();

        var sorter = mock(Sorter.class);
        Mockito.when(sorter.getAlgorithm()).thenReturn(new BubbleSort());

        var bubbleSorter = sorter.getAlgorithm();
        bubbleSorter.setSortingAlgorithmDirection(true);
        bubbleSorter.sort(bubbleArray);

        assertArrayEquals(expectedArray, bubbleArray);
    }

    @Test
    void bubbleSortDesc() {
        int[] refArray = { 1, 2, 3, 4, 5 };
        int[] expectedArray = { 5, 4, 3, 2, 1 };
        int[] bubbleArray = refArray.clone();

        var sorter = mock(Sorter.class);
        Mockito.when(sorter.getAlgorithm()).thenReturn(new BubbleSort());

        var bubbleSorter = sorter.getAlgorithm();
        bubbleSorter.setSortingAlgorithmDirection(false);
        bubbleSorter.sort(bubbleArray);

        assertArrayEquals(expectedArray, bubbleArray);
    }

    @Test
    void mergeSortAsc() {
        int[] refArray = { 5, 4, 3, 2, 1 };
        int[] expectedArray = { 1, 2, 3, 4, 5 };
        int[] mergeArray = refArray.clone();

        var sorter = mock(Sorter.class);
        Mockito.when(sorter.getAlgorithm()).thenReturn(new MergeSort());

        var mergeSorter = sorter.getAlgorithm();
        mergeSorter.setSortingAlgorithmDirection(true);
        mergeSorter.sort(mergeArray);

        assertArrayEquals(expectedArray, mergeArray);
    }

    @Test
    void mergeSortDesc() {
        int[] refArray = { 1, 2, 3, 4, 5 };
        int[] expectedArray = { 5, 4, 3, 2, 1 };
        int[] mergeArray = refArray.clone();

        var sorter = mock(Sorter.class);
        Mockito.when(sorter.getAlgorithm()).thenReturn(new MergeSort());

        var mergeSorter = sorter.getAlgorithm();
        mergeSorter.setSortingAlgorithmDirection(false);
        mergeSorter.sort(mergeArray);

        assertArrayEquals(expectedArray, mergeArray);
    }

    @Test
    void quickSortAsc() {
        int[] refArray = { 5, 4, 3, 2, 1 };
        int[] expectedArray = { 1, 2, 3, 4, 5 };
        int[] quickArray = refArray.clone();

        var sorter = mock(Sorter.class);
        Mockito.when(sorter.getAlgorithm()).thenReturn(new QuickSort());

        var quickSorter = sorter.getAlgorithm();
        quickSorter.setSortingAlgorithmDirection(true);
        quickSorter.sort(quickArray);

        assertArrayEquals(expectedArray, quickArray);
    }

    @Test
    void quickSortDesc() {
        int[] refArray = { 1, 2, 3, 4, 5 };
        int[] expectedArray = { 5, 4, 3, 2, 1 };
        int[] quickArray = refArray.clone();

        var sorter = mock(Sorter.class);
        Mockito.when(sorter.getAlgorithm()).thenReturn(new QuickSort());

        var quickSorter = sorter.getAlgorithm();
        quickSorter.setSortingAlgorithmDirection(false);
        quickSorter.sort(quickArray);

        assertArrayEquals(expectedArray, quickArray);
    }

}