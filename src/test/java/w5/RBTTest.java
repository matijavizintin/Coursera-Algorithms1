package w5;

import org.junit.Test;
import w2.ShuffleSort;
import w4.BinarySearchTree;

import java.util.Arrays;

/**
 * Created by Matija Vižintin
 * Date: 29. 07. 2015
 * Time: 19.59
 */
public class RBTTest {
    private final int MAX = 100000;

    @Test
    public void quiz() {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();
        Integer[] array = new Integer[] {60, 41, 84, 30, 56, 82 ,91 ,18, 34, 48, 75, 83, 72 };

        for (Integer integer : array) {
            tree.put(integer, integer);
        }

        tree.printRedNodes();
    }

    @Test
    public void quiz2() {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();
        Integer[] array = new Integer[] {38 ,25, 86, 16 ,35 ,59 ,89 ,29 ,41, 85};

        for (Integer integer : array) {
            tree.put(integer, integer);
        }
        tree.printRedNodes();

        array = new Integer[]{11 ,43 ,46 };
        for (Integer integer : array) {
            tree.put(integer, integer);
        }

        System.out.println(tree.toStringSimple());
    }

    @Test
    public void test1() {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();
        tree.put(3, 3);
        tree.put(4, 4);
        tree.put(5, 5);
        tree.put(11, 11);
        tree.put(6, 6);
        tree.put(8, 8);
        tree.put(10, 10);
        tree.put(2, 2);
        tree.put(9, 9);
        tree.put(1, 1);
        tree.put(7, 7);

        System.out.println("tree = " + tree);
    }

    @Test
    public void test2() {
        long start, stop;
        RedBlackTree<Integer, Integer> rbt;
        BinarySearchTree<Integer, Integer> bst;

        start = System.currentTimeMillis();
        rbt = buildRBT(true);
        stop = System.currentTimeMillis();
        System.out.printf("BUILDING RBT ASC WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));

        start = System.currentTimeMillis();
        getShuffledValuesFromRBT(rbt);
        stop = System.currentTimeMillis();
        System.out.printf("GET RBT ASC WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));

        start = System.currentTimeMillis();
        bst = buildBST(true);
        stop = System.currentTimeMillis();
        System.out.printf("BUILDING BST ASC WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));

        start = System.currentTimeMillis();
        getShuffledValuesFromBST(bst);
        stop = System.currentTimeMillis();
        System.out.printf("GET BST ASC WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));

        start = System.currentTimeMillis();
        rbt = buildRBT(false);
        stop = System.currentTimeMillis();
        System.out.printf("BUILDING RBT DESC WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));

        start = System.currentTimeMillis();
        getShuffledValuesFromRBT(rbt);
        stop = System.currentTimeMillis();
        System.out.printf("GET RBT DESC WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));

        start = System.currentTimeMillis();
        bst = buildBST(false);
        stop = System.currentTimeMillis();
        System.out.printf("BUILDING BST DESC WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));

        start = System.currentTimeMillis();
        getShuffledValuesFromBST(bst);
        stop = System.currentTimeMillis();
        System.out.printf("GET BST DESC WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));

        start = System.currentTimeMillis();
        rbt = shuffleRBT();
        stop = System.currentTimeMillis();
        System.out.printf("BUILDING RBT SHFL WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));

        start = System.currentTimeMillis();
        getShuffledValuesFromRBT(rbt);
        stop = System.currentTimeMillis();
        System.out.printf("GET RBT SHFL WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));

        start = System.currentTimeMillis();
        bst = shuffleBST();
        stop = System.currentTimeMillis();
        System.out.printf("BUILDING BST SHFL WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));

        start = System.currentTimeMillis();
        getShuffledValuesFromBST(bst);
        stop = System.currentTimeMillis();
        System.out.printf("GET BST SHFL WITH %d NODES >>> TIME: %d\n", MAX, (stop - start));
    }

    private RedBlackTree<Integer, Integer> buildRBT(boolean ascending) {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();

        for (int i = 0; i < MAX; i++) {
            tree.put(ascending ? i : MAX - i, ascending ? i : MAX - i);
        }
        return tree;
    }

    private BinarySearchTree<Integer, Integer> buildBST(boolean ascending) {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();

        for (int i = 0; i < MAX; i++) {
            tree.put(ascending ? i : MAX - i, ascending ? i : MAX - i);
        }
        return tree;
    }

    private RedBlackTree<Integer, Integer> shuffleRBT() {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();

        Integer[] array = new Integer[MAX];
        Arrays.setAll(array, operand -> operand);
        ShuffleSort.shuffle(array);

        for (Integer integer : array) {
            tree.put(integer, integer);
        }
        return tree;
    }

    private BinarySearchTree<Integer, Integer> shuffleBST() {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();

        Integer[] array = new Integer[MAX];
        Arrays.setAll(array, operand -> operand);
        ShuffleSort.shuffle(array);

        for (Integer integer : array) {
            tree.put(integer, integer);
        }
        return tree;
    }

    private void getShuffledValuesFromRBT(RedBlackTree<Integer, Integer> tree) {
        Integer[] array = new Integer[MAX];
        Arrays.setAll(array, operand -> operand);
        ShuffleSort.shuffle(array);

        for (Integer integer : array) {
            tree.get(integer);
        }
    }

    private void getShuffledValuesFromBST(BinarySearchTree<Integer, Integer> tree) {
        Integer[] array = new Integer[MAX];
        Arrays.setAll(array, operand -> operand);
        ShuffleSort.shuffle(array);

        for (Integer integer : array) {
            tree.get(integer);
        }
    }
}
