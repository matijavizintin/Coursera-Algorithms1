package w3;

import intfc.Sortable;
import w2.InsertionSort;
import w2.ShellSort;

import java.util.Objects;

/**
 * Created by Matija Vižintin
 * Date: 10. 07. 2015
 * Time: 19.41
 */
public class MergeSort<T extends Comparable<T>> implements Sortable<T> {
    private static final int CUT_OFF = 7;

    private int counter = 0;

    public void sort(T[] array) {
        sort(array, (T[])new Comparable[array.length], 0, array.length - 1);
    }

    private void sort(T[] input, T[] aux, int lo, int hi) {
        if (hi <= lo + CUT_OFF - 1) {
            new InsertionSort<T>().sort(input, lo, hi);
            return;
        }
//        if (hi <= lo) {
//            return;
//        }

        // calc mid
        int mid = lo + (hi - lo) / 2;

        // recursively sort each half
        sort(input, aux, lo, mid);
        sort(input, aux, mid + 1, hi);

        // merge halves if not already sorted
        if (compare(input[mid], input[mid + 1]) >= 0) {
            merge(input, aux, lo, mid, hi);
        }
//        System.out.printf("Iter: %d ", ++counter);
//        ShellSort.print(input);
    }

    protected void merge(T[] input, T[] aux, int lo, int mid, int hi) {
        // copy to auxiliary array
        for (int i = lo; i <= hi; i++) {
            aux[i] = input[i];
        }

        // merge from two halves
        int left = lo;
        int right = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (left > mid) input[i] = aux[right++];
            else if (right > hi) input[i] = aux[left++];
            else if (compare(aux[left], aux[right]) > 0) input[i] = aux[right++];
            else input[i] = aux[left++];
        }
    }

    private int compare(T left, T right) {
        return Objects.compare(left, right, (o1, o2) -> {
            if (o1 == null) return 1;
            else if (o2 == null) return -1;
            else return o1.compareTo(o2);
        });
    }
}
