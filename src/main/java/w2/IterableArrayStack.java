package w2;

import java.util.Iterator;

/**
 * Created by Matija Vižintin
 * Date: 03. 07. 2015
 * Time: 20.26
 */
public class IterableArrayStack<T> extends ArrayStack<T> implements Iterable<T> {
    @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override public boolean hasNext() {
                return !isEmpty();
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
