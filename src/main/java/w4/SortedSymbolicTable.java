package w4;

import java.util.Arrays;

/**
 * Created by Matija Vižintin
 * Date: 14. 07. 2015
 * Time: 19.11
 */
public class SortedSymbolicTable<KEY extends Comparable<KEY>, VALUE> {
    private KEY[] keys;
    private VALUE[] values;
    private int pointer;

    public SortedSymbolicTable() {
        keys = (KEY[])new Comparable[2];
        values = (VALUE[])new Comparable[2];
        pointer = 0;
    }

    public VALUE get(KEY key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        // find index of key
        int keyIndex = findIndex(key);
        return keyIndex < 0 ? null : values[keyIndex];
    }

    public void put(KEY key, VALUE value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }

        // insertion position
        int index = findIndex(key);
        if (index < 0) {    // new key
            // ensure capacity
            ensureCapacity();

            // find index to insert and insert to position
            index = findInsertPosition(key);
            insertAtPosition(key, value, index);
        } else {
            values[index] = value;      // replace value
        }
    }

    public VALUE remove(KEY key) {
        throw new UnsupportedOperationException();
    }

    private int findIndex(KEY key) {
        int lo = 0;
        int hi = pointer - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int comparison = keys[mid].compareTo(key);
            if (comparison < 0) {
                lo = mid + 1;
            } else if (comparison > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int findInsertPosition(KEY key) {
        int lo = 0;
        int hi = pointer;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int comparison = keys[mid].compareTo(key);
            if (comparison < 0) {
                lo = mid + 1;
            } else if (comparison > 0) {
                hi = mid - 1;
            } else {
                throw new InternalError();
            }
        }
        return lo;
    }

    private void insertAtPosition(KEY key, VALUE value, int index) {
        // move key and values
        for (int i = pointer; i > index; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        pointer++;      // increment pointer

        // set key and values at position index
        keys[index] = key;
        values[index] = value;
    }

    private void ensureCapacity() {
        if (pointer == keys.length) {
            keys = Arrays.copyOf(keys, keys.length * 2);
            values = Arrays.copyOf(values, values.length * 2);
        }
    }

    private void shrinkIfUnderThreshold() {
        if (pointer == keys.length / 4) {
            keys = Arrays.copyOf(keys, keys.length / 2);
            values = Arrays.copyOf(values, values.length / 2);
        }
    }
}
