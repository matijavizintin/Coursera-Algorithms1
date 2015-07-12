package w3;

import w2.ShellSort;

/**
 * Created by Matija Vižintin
 * Date: 11. 07. 2015
 * Time: 09.16
 */
public class BottomUpMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    private int counter = 0;

    @Override
    public void sort(T[] array) {
        int length = array.length;
        T[] aux = (T[])new Comparable[length];

        for (int step = 1; step < length; step *= 2) {       // double the step: 1, 2, 4, 8, ...

            // go through sub-arrays of size step and make merges
            for (int i = 0; i < length - step; i += 2 * step) {
                // make merge for left and right sub-array of size step
                merge(array, aux, i, i + step - 1, Math.min(i + 2 * step - 1, length - 1));

//                System.out.printf("Iter: %d ", ++counter);
//                ShellSort.print(array);
            }
        }
    }
}
