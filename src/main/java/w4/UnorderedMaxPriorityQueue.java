package w4;

/**
 * Created by Matija Vižintin
 * Date: 15. 07. 2015
 * Time: 20.30
 */
public class UnorderedMaxPriorityQueue<KEY extends Comparable<KEY>> {
    private KEY[] array;
    private int index;

    public UnorderedMaxPriorityQueue(int size) {
        array = (KEY[])new Comparable[size];
        index = 0;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void insert(KEY key) {
        array[index++] = key;
    }

    public KEY deleteMax() {
        int max = 0;
        for (int i = 1; i < index; i++) {
            if (array[i].compareTo(array[max]) > 0) {
                max = i;        // new max
            }
        }

        // swap max with last so we don't have nulls
        swap(max, --index);

        // get max, remove it and return
        KEY maxKey = array[index];
        array[index] = null;
        return maxKey;
    }

    private void swap(int i, int j) {
        KEY tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
