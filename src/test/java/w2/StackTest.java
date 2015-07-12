package w2;

import org.junit.Test;

/**
 * Created by Matija Vižintin
 * Date: 02. 07. 2015
 * Time: 21.02
 */
public class StackTest {

    @Test
    public void linked() {
        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    @Test
    public void arrayStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 10000; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    @Test
    public void iterableLinkedStack() {
        IterableLinkedStack<Integer> stack = new IterableLinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }

    @Test
    public void iterableArrayStack() {
        IterableArrayStack<Integer> stack = new IterableArrayStack<>();

        for (int i = 0; i < 100; i++) {
            System.out.println("Pushing " + i);
            stack.push(i);
        }

        for (Integer integer : stack) {
            System.out.println("Poping " + integer);
        }
    }
}
