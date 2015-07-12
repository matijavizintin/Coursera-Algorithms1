package w2;


import intfc.Sortable;

/**
 * Created by Matija Vižintin
 * Date: 05. 07. 2015
 * Time: 10.27
 */
public class InsertionSort<T extends Comparable<T>> implements Sortable<T> {
    public void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            sortTillBeginning(array, i);
        }
    }

    public void sort(T[] array, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            sortTillBeginning(array, i, lo);
        }
    }

    private void sortTillBeginning(T[] array, int index) {
        for (int i = index; i > 0; i--) {
            T bigger = array[i];
            T smaller = array[i - 1];

            if (bigger.compareTo(smaller) >= 0) {
                break;      // sorted
            } else {
                swap(array, i, i - 1);
            }
        }
    }

    private void sortTillBeginning(T[] array, int index, int lo) {
        for (int i = index; i > lo; i--) {
            T bigger = array[i];
            T smaller = array[i - 1];

            if (bigger.compareTo(smaller) >= 0) {
                break;      // sorted
            } else {
                swap(array, i, i - 1);
            }
        }
    }

    private void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
