package w2;

import intfc.Sortable;

/**
 * Created by Matija Vižintin
 * Date: 05. 07. 2015
 * Time: 09.57
 */
public class SelectionSort<T extends Comparable<T>> implements Sortable<T> {

    public void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    private boolean less(T first, T second) {
        return first.compareTo(second) < 0;
    }

    private void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
