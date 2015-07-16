package w4;

import org.junit.Assert;
import org.junit.Test;
import w2.ShuffleSort;

/**
 * Created by Matija Vižintin
 * Date: 15. 07. 2015
 * Time: 21.29
 */
public class HeapSortTest {

    @Test
    public void heapSort() {
        int N = 1000;
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }
        ShuffleSort.shuffle(array);

        new HeapSort<Integer>().sort(array);

        // assert sorted
        assertSorted(array);
    }

    @Test
    public void heapSortOrdered() {
        int N = 10000;
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }

        // sort already ordered
        new HeapSort<Integer>().sort(array);

        // assert sorted
        assertSorted(array);
    }

    @Test
    public void heapSortReverseOrdered() {
        int N = 10000;
        Integer[] array = new Integer[N];
        for (int i = N - 1; i >= 0; i--) {
            array[i] = i;
        }

        // sort already ordered
        new HeapSort<Integer>().sort(array);

        // assert sorted
        assertSorted(array);
    }

    private void assertSorted(Integer[] array) {
        // assert sorted
        for (int i = 0; i < array.length - 1; i++) {
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }
}
