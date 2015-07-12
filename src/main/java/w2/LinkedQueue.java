package w2;

/**
 * Created by Matija Vižintin
 * Date: 03. 07. 2015
 * Time: 19.05
 */
public class LinkedQueue<T> {
    private Node first;
    private Node last;

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(T element) {
        Node last = new Node(element, null);
        if (isEmpty()) {
            first = last;
            this.last = last;
        } else {
            this.last.next = last;
            this.last = last;
        }
    }

    public T dequeue() {
        Node node = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return node.value;
    }


    private class Node {
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
