package w4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Matija Vižintin
 * Date: 12. 07. 2015
 * Time: 16.49
 */
public class PriorityQTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void unorderedMaxPQ() {
        UnorderedMaxPriorityQueue<Integer> pq = new UnorderedMaxPriorityQueue<>(100);

        // insert from 0 to 99
        for (int i = 0; i < 100; i++) {
            pq.insert(i);
        }

        // remove max and assert
        Assert.assertEquals(new Integer(99), pq.deleteMax());
        Assert.assertEquals(new Integer(98), pq.deleteMax());
        Assert.assertEquals(new Integer(97), pq.deleteMax());
        Assert.assertEquals(new Integer(96), pq.deleteMax());
        Assert.assertEquals(new Integer(95), pq.deleteMax());
        Assert.assertEquals(new Integer(94), pq.deleteMax());
        Assert.assertEquals(new Integer(93), pq.deleteMax());
        Assert.assertEquals(new Integer(92), pq.deleteMax());
        Assert.assertEquals(new Integer(91), pq.deleteMax());

        // delete 10 items
        for (int i = 0; i < 10; i++) {
            pq.deleteMax();
        }

        // add 100
        pq.insert(100);

        // assert 100 is biggest and 80 the second biggest
        Assert.assertEquals(new Integer(100), pq.deleteMax());
        Assert.assertEquals(new Integer(80), pq.deleteMax());

        // assert empty
        for (int i = 0; i < 80; i++) {
            pq.deleteMax();
        }
        Assert.assertTrue(pq.isEmpty());

        // assert can't remove from empty Q
        pq.deleteMax();     // exception expected
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void maxBinaryHeapPQ() {
        MaxBinaryHeapPriorityQueue<Integer> heap = new MaxBinaryHeapPriorityQueue<>();

        // add 10 elements to heap
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

        // assert max is 10
        Assert.assertEquals(new Integer(10), heap.getMax());

        // pop max and assert
        int max = heap.removeMax();
        Assert.assertEquals(10, max);
        max = heap.removeMax();
        Assert.assertEquals(9, max);

        // pop all remaining elements
        for (int i = 8; i > 0; i--) {
            max = heap.removeMax();
            Assert.assertEquals(i, max);
        }

        // assert that remove
        heap.removeMax();       // exception expected
    }

    @Test
    public void quiz() {
        MaxBinaryHeapPriorityQueue<Integer> heap = new MaxBinaryHeapPriorityQueue<>(new Integer[] {0, 99, 87, 95, 83, 63, 20, 47, 15 ,34 ,32 });
        heap.add(90);
        heap.add(55);
        heap.add(93);
        heap.print2();

        System.out.println("-------------------------");
        heap = new MaxBinaryHeapPriorityQueue<Integer>(new Integer[] {0, 92, 89 ,67 ,68 ,73 ,54, 36, 47, 49, 21});
        heap.removeMax();
        heap.removeMax();
        heap.removeMax();
        heap.print2();
    }
}
