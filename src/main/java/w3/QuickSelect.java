package w3;

import w2.ShuffleSort;

import java.util.Comparator;

/**
 * Created by Matija Vižintin
 * Date: 11. 07. 2015
 * Time: 16.02
 */
public class QuickSelect<T extends Comparable<T>> extends QuickSort<T> {

    public T select(T[] input, int position) {
        // shuffle
        ShuffleSort.shuffle(input);

        int lo = 0;
        int hi = input.length - 1;
        while (hi > lo) {
            // partition
            int part = partition(input, lo, hi);

            // adjust lo, hi
            if (part < position) lo = part + 1;
            else if (part > position) hi = part - 1;
            else return input[position];
        }

        return input[position];
    }
}
