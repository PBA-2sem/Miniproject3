package sorting_algorithms;

/**
 *
 * @author stanislavnovitski
 */
public class SelectionSort {

    public static void sort(String[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i].compareTo(arr[j]) > 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
