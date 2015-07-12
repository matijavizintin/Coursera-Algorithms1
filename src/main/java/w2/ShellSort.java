package w2;

import intfc.Sortable;

/**
 * Created by Matija Vižintin
 * Date: 05. 07. 2015
 * Time: 11.23
 */
public class ShellSort<T extends Comparable<T>> implements Sortable<T> {

    public void sort(T[] array) {
        // calc start h
        int length = array.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // sort
            for (int i = 0; i < length; i++) {
                sortPrevious(array, i, h);
            }

            // calc new h
            h /= 3;
        }
    }

    private void sortPrevious(T[] array, int start, int h) {
        for (int i = start; i >= h; i -= h) {
            T bigger = array[i];
            T smaller = array[i - h];

            if (bigger.compareTo(smaller) >= 0) {
                break;      // sorted
            } else {
                swap(array, i, i - h);
            }
        }
    }

    private void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void print(Object[] array) {
        for (Object o : array) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
