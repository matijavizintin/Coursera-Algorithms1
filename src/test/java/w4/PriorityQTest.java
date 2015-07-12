package w4;

import org.junit.Assert;
import org.junit.Test;
import w2.ShuffleSort;

/**
 * Created by Matija Vižintin
 * Date: 12. 07. 2015
 * Time: 16.49
 */
public class PriorityQTest {

    @Test
    public void maxBinaryHeap() {
        MaxBinaryHeap<Integer> heap = new MaxBinaryHeap<>();

        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);
        heap.add(9);
        heap.add(10);

        heap.print();

        int max = heap.removeMax();
        Assert.assertEquals(10, max);

        max = heap.removeMax();
        Assert.assertEquals(9, max);

        heap.print();

        max = heap.removeMax();
        max = heap.removeMax();
        max = heap.removeMax();
        max = heap.removeMax();
        max = heap.removeMax();
        max = heap.removeMax();
        max = heap.removeMax();
        heap.print();
    }

    @Test
    public void heapSort() {
        int N = 10;
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }
        ShuffleSort.shuffle(array);

        new HeapSort<Integer>().sort(array);

        // assert sorted
        for (int i = 0; i < N - 1; i++) {
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }
}
