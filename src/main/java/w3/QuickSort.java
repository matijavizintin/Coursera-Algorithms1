package w3;

import intfc.Sortable;
import w2.InsertionSort;
import w2.ShuffleSort;

/**
 * Created by Matija Vižintin
 * Date: 11. 07. 2015
 * Time: 13.05
 */
public class QuickSort<T extends Comparable<T>> implements Sortable<T> {
    public static final int CUT_OFF = 10;

    @Override
    public void sort(T[] input) {
        // shuffle the input
        ShuffleSort.shuffle(input);

        // sort recursively
        sort(input, 0, input.length - 1);
    }

    protected void sort(T[] input, int lo, int hi) {
//        if (hi <= lo) return;
        if (hi <= lo + CUT_OFF - 1) {
            new InsertionSort<T>().sort(input, lo, hi);
            return;
        }

        // swap with median
        int m = medianOf3(input, lo, lo + (hi - lo) / 2, hi);
        swap(input, lo, m);

        // partition
        int part = partition(input, lo, hi);

        // sort recursively
        sort(input, lo, part - 1);
        sort(input, part + 1, hi);
    }

    protected int partition(T[] input, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (input[++i].compareTo(input[lo]) < 0) {   // loop until a[i] < a[lo]
                if (i == hi) break;
            }

            while (input[--j].compareTo(input[lo]) > 0);    // loop until a[j] > a[lo]; no need for j == lo check because a[j] cant be lower than a[j]

            // break if indices cross
            if (i >= j) break;

            // swap elements at i and j
            swap(input, i, j);
        }

        // swap elements at lo and j
        swap(input, lo, j);

        return j;
    }

    protected int medianOf3(T[] input, int i, int j, int k) {
        if (input[i].compareTo(input[j]) < 0) {
            return input[j].compareTo(input[k]) < 0 ? j : k;
        } else {
            return input[i].compareTo(input[k]) < 0 ? i : k;
        }
    }

    protected void swap(T[] input, int i, int j) {
        T tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
