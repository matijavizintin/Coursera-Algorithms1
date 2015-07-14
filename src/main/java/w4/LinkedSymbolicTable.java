package w4;

/**
 * Created by Matija Vižintin
 * Date: 14. 07. 2015
 * Time: 18.52
 */
public class LinkedSymbolicTable<KEY, VALUE> {
    private Node first;


    public VALUE get(KEY key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        // find node
        Node found = find(key);
        return found != null ? found.value : null;
    }

    public void put(KEY key, VALUE value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }

        // find key if exists
        Node found = find(key);
        if (found != null)
            found.value = value;
        else {
            Node oldFirst = first;
            first = new Node(key, value, oldFirst);
        }
    }

    public VALUE remove(KEY key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        // find node
        Node node = find(key);
        if (node == null) return null;

        // link previous with next
        Node previous = findPrevious(key);
        if (previous != null)
            previous.next = node.next;

        return node.value;
    }

    private Node find(KEY key) {
        if (first == null) return null;

        // set first node
        Node node = first;
        while (node != null) {
            // if key equals then return
            if (key.equals(node.key)) {
                return node;
            }

            // go to next node
            node = node.next;
        }
        return null;
    }

    private Node findPrevious(KEY key) {
        if (first == null) return null;

        // set first node
        Node node = first;
        Node previous = null;
        while (node != null) {
            // if key equals then return
            if (key.equals(node.key)) {
                return previous;
            }

            // set previous and set next
            previous = node;
            node = node.next;
        }
        return null;
    }

    private class Node {
        private KEY key;
        private VALUE value;
        private Node next;

        public Node(KEY key, VALUE value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
