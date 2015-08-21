package w6;

/**
 * Created by Matija Vižintin
 * Date: 10. 08. 2015
 * Time: 21.06
 */
public class SeparateChainingHashST<KEY, VALUE> {
    private int M;      // chain size
    private Node[] st;

    public SeparateChainingHashST() {
        this(97);
    }

    public SeparateChainingHashST(int m) {
        M = m;
        st = new Node[M];
    }

    private int hash(KEY key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public VALUE get(KEY key) {
        int i = hash(key);

        // go through the linked list at st[i]
        for(Node x = st[i]; x != null; x = x.next) {
            System.out.println("x.key = " + x.key);
            if (key.equals(x.key))      // key found, return value
                return (VALUE)x.value;
        }
        return null;        // not found
    }

    public void put(KEY key, VALUE value) {
        int i = hash(key);

        // go through the linked list at st[i]
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {     // if key found then update the value
                x.value = value;
                return;
            }
        }

        // key was not in the table, add the element in the front of the linked list at st[i]
        st[i] = new Node(key, value, st[i]);
    }

    // linked list representation with a node
    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
