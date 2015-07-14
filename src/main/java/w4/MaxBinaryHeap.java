package w4;

import java.util.Arrays;

/**
 * Created by Matija Vižintin
 * Date: 12. 07. 2015
 * Time: 15.53
 */
public class MaxBinaryHeap<T extends Comparable<T>> {
    private T[] array;
    private int pointer;

    public MaxBinaryHeap() {
        array = (T[])new Comparable[2];
        pointer = 1;        // leave element at 0 empty
    }

    public MaxBinaryHeap(T[] predefined) {
        array = predefined;
        pointer = predefined.length;
    }

    public boolean isEmpty() {
        return pointer == 1;
    }

    public void add(T element) {
        // ensure capacity
        ensureCapacity();

        // add to pointer == last element in array
        array[pointer] = element;
        swim(pointer);

        // increment pointer
        pointer++;
    }

    public T removeMax() {
        T max = getMax();

        // swap first with last
        swap(1, --pointer);
        sink(1);

        // free memory
        array[pointer] = null;
        shrinkIfUnderThreshold();

        return max;
    }

    public T getMax() {
        return array[1];
    }

    private void swim(int k) {
        // loop while k is bigger than its parent or it reaches the root
        while (k > 1 && array[k].compareTo(array[parent(k)]) > 0) {
            swap(k, parent(k));     // swap with parent
            k = parent(k);          // set k to parent
        }
    }

    private void sink(int k) {
        // loop till the end
        while (2 * k < pointer) {
            // pick bigger child
            int j = firstChild(k);
            if (secondChild(k) < pointer && array[j].compareTo(array[j + 1]) < 0) {
                j++;        // pick second child
            }

            // if parent bigger or equals than bigger child then stop
            if (array[k].compareTo(array[j]) >= 0) {
                break;
            }

            // swap with child and set child as parent
            swap(k, j);
            k = j;
        }
    }

    private void ensureCapacity() {
        if (pointer == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    private int parent(int k) {
        return k / 2;
    }

    private int firstChild(int k) {
        return k * 2;
    }

    private int secondChild(int k) {
        return k * 2 + 1;
    }

    private void swap(int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private void shrinkIfUnderThreshold() {
        if (pointer == array.length / 4) {
            array = Arrays.copyOf(array, array.length / 2);
        }
    }

    public void print() {
        System.out.println();

        int newLineThreshold = 2;
        for (int i = 1; i < pointer; i++) {
            if (i == newLineThreshold) {
                System.out.println();
                for (int j = 0; j < newLineThreshold; j++) {
                    System.out.print("| ");
                }
                System.out.println();
                newLineThreshold *= 2;
            }

            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void print2() {
        for (T t : array) {
            System.out.print(t + " ");
        }
    }
}
