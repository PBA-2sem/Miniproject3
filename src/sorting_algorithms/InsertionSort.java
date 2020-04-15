package sorting_algorithms;

/**
 *
 * @author stanislavnovitski
 */
public class InsertionSort {

    public static void sort(String[] arr) {

        for (int i = 1; i < arr.length; i++) {
            String element = arr[i];
            int j;
            for (j = i - 1; j >= 0 && element.compareTo(arr[j]) <= 0; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = element;
        }
    }

}
