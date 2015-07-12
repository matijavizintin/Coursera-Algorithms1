package w2;

import org.junit.Test;

/**
 * Created by Matija Vižintin
 * Date: 03. 07. 2015
 * Time: 19.11
 */
public class QueueTest {

    @Test
    public void linked() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
            System.out.println("Enqueu: " + i);
        }

        for (int i = 0; i < 100; i++) {
            Integer x = queue.dequeue();
            System.out.println("Dequeue: " + x);
        }

        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
            System.out.println("Enqueu: " + i);
        }

        for (int i = 0; i < 100; i++) {
            Integer x = queue.dequeue();
            System.out.println("Dequeue: " + x);
        }
    }

    @Test
    public void array() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
            System.out.println("Enqueu: " + i);
        }

        for (int i = 0; i < 100; i++) {
            Integer x = queue.dequeue();
            System.out.println("Dequeue: " + x);
        }

        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
            System.out.println("Enqueu: " + i);
        }

        for (int i = 0; i < 100; i++) {
            Integer x = queue.dequeue();
            System.out.println("Dequeue: " + x);
        }
    }
}
