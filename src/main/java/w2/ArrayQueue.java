package w2;

import java.util.Arrays;

/**
 * Created by Matija Vižintin
 * Date: 03. 07. 2015
 * Time: 19.17
 */
public class ArrayQueue<T> {
    private Object[] array;
    private int first;
    private int last;

    public ArrayQueue() {
        array = new Object[10];
        first = 0;
        last = 0;
    }

    public void enqueue(T element) {
        ensureCapacity();
        array[last++] = element;
    }

    public T dequeue() {
        shrink();
        return (T)array[first++];
    }

    public boolean isEmpty() {
        return first == last;
    }

    private void ensureCapacity() {
        if (last == array.length) {
            System.out.printf("Resizing from %d to %d\n", array.length, array.length * 2);
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    private void shrink() {
        if (last - first < array.length / 2) {
            System.out.printf("Shrinking from %d to %d\n", array.length, last - first);
            array = Arrays.copyOfRange(array, first, last);
            last -= first;
            first = 0;
        }
    }
}
