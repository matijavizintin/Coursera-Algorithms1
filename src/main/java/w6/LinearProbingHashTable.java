package w6;

/**
 * Created by Matija Vižintin
 * Date: 21. 08. 2015
 * Time: 19.56
 */
public class LinearProbingHashTable<KEY, VALUE> {
    private int M;
    private KEY[] keys;
    private VALUE[] values;

    public LinearProbingHashTable() {
        this(100);
    }

    public LinearProbingHashTable(int m) {
        M = m;
        keys = (KEY[])new Object[m];
        values = (VALUE[])new Object[m];
    }

    public void put(KEY key, VALUE value) {
        int position = hash(key);

        // find empty position
        while (keys[position] != null && !key.equals(keys[position])) {
            position = (position + 1) % M;
        }

        // insert values
        keys[position] = key;
        values[position] = value;
    }

    public VALUE get(KEY key) {
        int position = hash(key);

        // find position with key
        while (keys[position] != null && !key.equals(keys[position])) {
            position = (position + 1) % M;
        }

        // return at position
        return values[position];
    }

    private int hash(KEY key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void printKeys() {
        for (KEY key : keys) {
            System.out.print(key + " ");
        }
    }
}
