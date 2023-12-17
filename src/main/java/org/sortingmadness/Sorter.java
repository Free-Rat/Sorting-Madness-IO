package org.sortingmadness;

/**
 * Klasa Sorter jest odpowiedzialna za wybór algorytmu sortowania, jego kierunku oraz limitu
 */
public class Sorter {

    /**
     * algorytm sortowania
     */
    private SortingAlgorithm algorithm;

    /**
     * Metoda setSortingStrategy() ustawia algorytm sortowania
     * @param strat - strategia sortowania
     */
    public void setSortingStrategy(SortingStrategyEnum strat) {
        switch (strat) { 
            case BUBBLE_SORT: 
                this.algorithm = new BubbleSort();
                break;
            case QUICK_SORT:
                this.algorithm = new QuickSort();
                break;
            case MERGE_SORT:
                this.algorithm = new MergeSort();
                break;
        }
    }

    /**
     * Metoda getAlgorithm() zwraca obiekt algorytmu sortowania
     * @return SortingAlgorithm
     */
    public SortingAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    /**
     * Metoda setSortingAlgorithmDirection() ustawia kierunek sortowania
     * @param isAscending - kierunek sortowania
     */
    public void setSortingAlgorithmDirection(Boolean isAscending) {
        this.algorithm.ascending = isAscending;
    }

    /**
     * Metoda setSortingAlgorithmLimit() ustawia limit sortowania
     * @param limit - limit sortowania
     */
    public void setSortingAlgorithmLimit(int limit) {
        this.algorithm.limit = limit;
    }
}

/**
 * Interfejs SortingAlgorithm jest wspólny dla wszystkich algorytmów sortowania
 */
interface SortingAlgorithm {

    /**
     * ascending - kierunek sortowania
     * limit - limit sortowania
     */
    public Boolean ascending = true;
    public int limit = 0;

    /**
     * Metoda sort() sortuje tablicę int[]
     * @param array - tablica int[]
     */
    void sort(int[] array);

    /**
     * Metoda sort() sortuje tablicę char[]
     * @param array - tablica char[]
     */
    void sort(char[] array);

    /**
     * Metoda sort() sortuje tablicę double[]
     * @param array - tablica double[]
     */
    void sort(double[] array);
}

/**
 * Klasa BubbleSort implementuje interfejs setSortingAlgorithmLimit
 * oraz sortuje tablice int[], char[] i double[] w zależności od kierunku sortowania
 */
class BubbleSort implements SortingAlgorithm {

    /**
     * Metoda sort() sortuje tablicę int[]
     * @param arr - tablica int[]
     */
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending ? arr[j] > arr[j + 1] : arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp;
                }
            }
            if (limit != 0 && i == limit - 1) break;
        }
    }

    /**
     * Metoda sort() sortuje tablicę char[]
     * @param arr - tablica char[]
     */
    public void sort(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending ? arr[j] > arr[j + 1] : arr[j] < arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp;
                }
            }
            if (limit != 0 && i == limit - 1) break;
        }
    }

    /**
     * Metoda sort() sortuje tablicę double[]
     * @param arr - tablica double[]
     */
    public void sort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending ? arr[j] > arr[j + 1] : arr[j] < arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (limit != 0 && i == limit - 1) break;
        }
    }
}

/**
 * Klasa QuickSort implementuje interfejs SortingAlgorithm
 * oraz sortuje tablice int[], char[] i double[] w zależności od kierunku sortowania
 */
class QuickSort implements SortingAlgorithm {

    /**
     * recursiveDepth - głębokość rekurencji
     */
    private int recursiveDepth = 0;

    /**
     * Metoda sort() odpowiada za wywołanie funkcji quickSort()
     * @param arr - tablica int[]
     */
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Metoda quickSort() odpowiada za rekurencyjne wywołanie sortowania szybkiego
     * oraz za wywołanie funkcji partition(), która dzieli tablicę na dwie części
     * @param arr - tablica int[]
     * @param low - indeks pierwszego elementu
     * @param high - indeks ostatniego elementu
     */
    private void quickSort(int[] arr, int low, int high) {
        if (limit != 0 && recursiveDepth == limit) return;
        recursiveDepth++;
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    /**
     * Metoda partition() dzieli tablicę na dwie części, zwraca indeks elementu pivot
     * @param arr - tablica int[]
     * @param low - indeks pierwszego elementu
     * @param high - indeks ostatniego elementu
     * @return int
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (ascending ? arr[j] < pivot : arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    /**
     * Metoda sort() odpowiada za wywołanie funkcji quickSort()
     * @param arr - tablica char[]
     */
    public void sort(char[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Metoda quickSort() odpowiada za rekurencyjne wywołanie sortowania szybkiego
     * oraz za wywołanie funkcji partition(), która dzieli tablicę na dwie części
     * @param arr - tablica char[]
     * @param low - indeks pierwszego elementu
     * @param high - indeks ostatniego elementu
     */
    private void quickSort(char[] arr, int low, int high) {
        if (limit != 0 && recursiveDepth == limit) return;
        recursiveDepth++;
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    /**
     * Metoda partition() dzieli tablicę na dwie części, zwraca indeks elementu pivot
     * @param arr - tablica char[]
     * @param low - indeks pierwszego elementu
     * @param high - indeks ostatniego elementu
     * @return int
     */
    private int partition(char[] arr, int low, int high) {
        char pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (ascending ? arr[j] < pivot : arr[j] > pivot) {
                i++;
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        char temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    /**
     * Metoda sort() odpowiada za wywołanie funkcji quickSort()
     * @param arr - tablica double[]
     */
    public void sort(double[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Metoda quickSort() odpowiada za rekurencyjne wywołanie sortowania szybkiego
     * oraz za wywołanie funkcji partition(), która dzieli tablicę na dwie części
     * @param arr - tablica double[]
     * @param low - indeks pierwszego elementu
     * @param high - indeks ostatniego elementu
     */
    private void quickSort(double[] arr, int low, int high) {
        if (limit != 0 && recursiveDepth == limit) return;
        recursiveDepth++;
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    /**
     * Metoda partition() dzieli tablicę na dwie części, zwraca indeks elementu pivot
     * @param arr - tablica double[]
     * @param low - indeks pierwszego elementu
     * @param high - indeks ostatniego elementu
     * @return int
     */
    private int partition(double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (ascending ? arr[j] < pivot : arr[j] > pivot) {
                i++;
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

/**
 * Klasa MergeSort implementuje interfejs SortingAlgorithm
 * oraz sortuje tablice int[], char[] i double[] w zależności od kierunku sortowania
 */
class MergeSort implements SortingAlgorithm {

    /**
     * recursiveDepth - głębokość rekurencji
     */
    private int recursiveDepth = 0;

    /**
     * Metoda sort() odpowiada za wywołanie funkcji mergeSort()
     * @param arr - tablica int[]
     */
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Metoda mergeSort() odpowiada za rekurencyjne wywołanie sortowania przez scalanie
     * @param arr - tablica int[]
     * @param left - indeks pierwszego elementu
     * @param right - indeks ostatniego elementu
     */
    private void mergeSort(int[] arr, int left, int right) {
        if (limit != 0 && recursiveDepth == limit) return;
        recursiveDepth++;
        if (ascending ? left < right : left > right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * Metoda merge() scala dwie podtablice
     * @param arr - tablica int[]
     * @param left - indeks pierwszego elementu
     * @param mid - indeks środkowego elementu
     * @param right - indeks ostatniego elementu
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /**
     * Metoda sort() odpowiada za wywołanie funkcji mergeSort()
     * @param arr - tablica double[]
     */
    public void sort(double[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Metoda mergeSort() odpowiada za rekurencyjne wywołanie sortowania przez scalanie
     * @param arr - tablica double[]
     * @param left - indeks pierwszego elementu
     * @param right - indeks ostatniego elementu
     */
    private void mergeSort(double[] arr, int left, int right) {
        if (limit != 0 && recursiveDepth == limit) return;
        recursiveDepth++;
        if (ascending ? left < right : left > right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * Metoda merge() scala dwie podtablice
     * @param arr - tablica double[]
     * @param left - indeks pierwszego elementu
     * @param mid - indeks środkowego elementu
     * @param right - indeks ostatniego elementu
     */
    private void merge(double[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];

        for (int i = 0; i < n1; ++i) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /**
     * Metoda sort() odpowiada za wywołanie funkcji mergeSort()
     * @param arr - tablica char[]
     */
    public void sort(char[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Metoda mergeSort() odpowiada za rekurencyjne wywołanie sortowania przez scalanie
     * @param arr - tablica char[]
     * @param left - indeks pierwszego elementu
     * @param right - indeks ostatniego elementu
     */
    private void mergeSort(char[] arr, int left, int right) {
        if (limit != 0 && recursiveDepth == limit) return;
        recursiveDepth++;
        if (ascending ? left < right : left > right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * Metoda merge() scala dwie podtablice
     * @param arr - tablica char[]
     * @param left - indeks pierwszego elementu
     * @param mid - indeks środkowego elementu
     * @param right - indeks ostatniego elementu
     */
    private void merge(char[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        char[] leftArr = new char[n1];
        char[] rightArr = new char[n2];

        for (int i = 0; i < n1; ++i) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
