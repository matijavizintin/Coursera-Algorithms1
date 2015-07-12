package w4;

import intfc.Sortable;

/**
 * Created by Matija Vižintin
 * Date: 12. 07. 2015
 * Time: 17.20
 */
public class HeapSort<T extends Comparable<T>> implements Sortable<T> {
    @Override
    public void sort(T[] input) {
        // create max heap
        int N = input.length;
        int i = N / 2;
        while (i >= 1) {
            sink(input, i, N);
            i--;
        }

        // sort down
        int idx = input.length;
        while(idx >= 1) {
            swap(input, 1, idx);
            sink(input, 1, --idx);
        }
    }

    private void sink(T[] array, int k, int N) {
        // loop till the end
        while (2 * k <= N) {
            // pick bigger child
            int j = firstChild(k);
            if (secondChild(k) <= N && elementAt(array, j).compareTo(elementAt(array, j + 1)) < 0) {
                j++;        // pick second child
            }

            // if parent bigger or equals than bigger child then stop
            if (elementAt(array,k).compareTo(elementAt(array, j)) >= 0) {
                break;
            }

            // swap with child and set child as parent
            swap(array, k, j);
            k = j;
        }
    }

    private T elementAt(T[] array, int k) {
        return array[k - 1];        // 0-based array
    }

    private void setElementAt(T[] array, T element, int k) {
        array[k - 1] = element;
    }

    private int firstChild(int k) {
        return k * 2;
    }

    private int secondChild(int k) {
        return k * 2 + 1;
    }

    private void swap(T[] array, int i, int j) {
        T tmp = elementAt(array, i);
        setElementAt(array, elementAt(array, j), i);
        setElementAt(array, tmp, j);
    }
}
