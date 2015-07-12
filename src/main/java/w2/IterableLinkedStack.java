package w2;

import java.util.Iterator;

/**
 * Created by Matija Vižintin
 * Date: 03. 07. 2015
 * Time: 20.17
 */
public class IterableLinkedStack<T> extends LinkedStack<T> implements Iterable<T> {
    @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override public boolean hasNext() {
                return first != null;
            }

            @Override public T next() {
                return pop();
            }

            @Override
            public void remove() {

            }


        };
    }
}
