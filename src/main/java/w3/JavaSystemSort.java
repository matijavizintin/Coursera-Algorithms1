package w3;

import intfc.Sortable;

import java.util.Arrays;

/**
 * Created by Matija Vižintin
 * Date: 12. 07. 2015
 * Time: 11.09
 */
public class JavaSystemSort<T extends Comparable<T>> implements Sortable<T> {
    @Override
    public void sort(T[] input) {
        Arrays.sort(input);
    }
}
