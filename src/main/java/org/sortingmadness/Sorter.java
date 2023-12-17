package org.sortingmadness;

interface SortingAlgorithm {
    void sort(int[] array);
}

class BubbleSort implements SortingAlgorithm {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void bubbleSort(String arr) {
        int n = arr.length();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.charAt(j) > arr.charAt(j + 1)) {
                    char temp = arr.charAt(j);
                    arr.charAt(j) = arr.charAt(j + 1);
                    arr.charAt(j + 1) = temp;
                }
            }
        }
    }

    public void bubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

public class Sorter {
    private SortingAlgorithm algorithm;

    public void setSortingStrategy(SortingStrategyEnum strat) {
        switch (strat) { 
            case BUBBLE_SORT: 
                this.algorithm = new BubbleSort();
                break;
        }
    }

    public SortingAlgorithm getAlgorithm() {
        return this.algorithm;
    }
}
