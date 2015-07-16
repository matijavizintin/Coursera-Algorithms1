package w4;

import org.junit.Test;

/**
 * Created by Matija Vižintin
 * Date: 15. 07. 2015
 * Time: 19.19
 */
public class BSTTest {

    @Test
    public void quiz() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        bst.put(98, 1);
        bst.put(35, 1);
        bst.put(61, 1);
        bst.put(86, 1);
        bst.put(20, 1);
        bst.put(13, 1);
        bst.put(42, 1);
        bst.put(36, 1);
        bst.put(53, 1);
        bst.put(32, 1);

        for (Integer integer : bst.keys()) {
            System.out.println("integer = " + integer);
        }

    }

    @Test
    public void quiz2() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        bst.put(83, 1);
        bst.put(35, 1);
        bst.put(99, 1);
        bst.put(13, 1);
        bst.put(57, 1);
        bst.put(98, 1);
        bst.put(28, 1);
        bst.put(39, 1);
        bst.put(61, 1);
        bst.put(31, 1);
        bst.put(50, 1);
        bst.put(65, 1);

        bst.delete(65);
        bst.delete(28);
        bst.delete(35);

        for (Integer integer : bst.keys()) {
            System.out.println("integer = " + integer);
        }

    }
}
