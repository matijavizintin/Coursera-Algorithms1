package w2;

import java.util.Arrays;

/**
 * Created by Matija Vižintin
 * Date: 02. 07. 2015
 * Time: 21.09
 */
public class ArrayStack<T> {
    protected Object[] array;
    protected int pointer;

    public ArrayStack() {
        array = new Object[10];
        pointer = 0;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public void push(T element) {
        ensureCapacity();
        array[pointer++] = element;
    }

    public T pop() {
        T element = (T)array[--pointer];
        array[pointer] = null;
        shrinkIfUnderThreshold();
        return element;
    }

    private void ensureCapacity() {
        if (pointer == array.length) {
            //System.out.printf("Resizing from %d to %d\n", array.length, array.length * 2);
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    private void shrinkIfUnderThreshold() {
        if (pointer == array.length / 4) {
            //System.out.printf("Shrinking from %d to %d\n", array.length, array.length / 2);
            array = Arrays.copyOf(array, array.length / 2);
        }
    }
}
