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

    @Test
    public void quiz() {
        MaxBinaryHeap<Integer> heap = new MaxBinaryHeap<>(new Integer[] {0, 99, 87, 95, 83, 63, 20, 47, 15 ,34 ,32 });
        heap.add(90);
        heap.add(55);
        heap.add(93);
        heap.print2();

        System.out.println("-------------------------");
        heap = new MaxBinaryHeap<Integer>(new Integer[] {0, 92, 89 ,67 ,68 ,73 ,54, 36, 47, 49, 21});
        heap.removeMax();
        heap.removeMax();
        heap.removeMax();
        heap.print2();


    }
}
