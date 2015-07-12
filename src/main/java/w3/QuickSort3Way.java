package w3;

/**
 * Created by Matija Vižintin
 * Date: 11. 07. 2015
 * Time: 16.42
 */
public class QuickSort3Way<T extends Comparable<T>> extends QuickSort<T> {

    @Override
    protected void sort(T[] input, int lo, int hi) {
        if (hi <= lo) return;

        // partition; between lt and gt will be the same values as v --> already sorted
        int i = lo;
        int lt = lo;
        int gt = hi;
        T v = input[lo];
        while (i <= gt) {
            if (input[i].compareTo(v) < 0) swap(input, lt++, i++);     // swap lt and i, increment lt and i
            else if (input[i].compareTo(v) > 0) swap(input, gt--, i);     // swap gt and i, decrement gt
            else i++;   // increment i
        }

        // sort recursively
        sort(input, lo, lt -1);
        sort(input, gt + 1, hi);
    }

    protected void partition3Way(T[] input, int lo, int hi) {
        // partition; between lt and gt will be the same values as v --> already sorted
        int i = lo;
        int lt = lo;
        int gt = hi;
        T v = input[lo];
        while (i <= gt) {
            if (input[i].compareTo(v) < 0) swap(input, lt++, i++);     // swap lt and i, increment lt and i
            else if (input[i].compareTo(v) > 0) swap(input, gt--, i);     // swap gt and i, decrement gt
            else i++;   // increment i
        }
    }
}
