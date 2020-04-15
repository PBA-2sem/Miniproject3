package sorting_algorithms;

public class QuickSort {

    public static void quickSort(String[] array, int low, int high) {
        int i = low, j = high;

        String pivot = array[low + (high - low) / 2];
        while (i <= j) {
            while (array[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }
            while (array[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                exchange(array, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(array, low, j);
        }
        if (i < high) {
            quickSort(array, i, high);
        }
    }

    private static void exchange(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
