package w2;

/**
 * Created by Matija Vižintin
 * Date: 02. 07. 2015
 * Time: 20.58
 */
public class LinkedStack<T> {
    protected Node first;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T element) {
        first = new Node(element, first);
    }

    public T pop() {
        T element = first.element;
        first = first.next;
        return element;
    }

    private class Node {
        T element;
        Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
