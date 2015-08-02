package w5;

import java.util.ArrayDeque;
import java.util.Collection;

/**
 * Created by Matija Vižintin
 * Date: 02. 08. 2015
 * Time: 10.50
 */
public class IntervalSearchTree<KEY extends Comparable<KEY>, VALUE> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    public IntervalSearchTree() {
    }

    public void put(KEY lo, KEY hi, VALUE value) {
        root = put(root, lo, hi, value);

        // update max
        if (root.right != null && root.maxInSubTree.compareTo(root.right.maxInSubTree) < 0)
            root.maxInSubTree = root.right.maxInSubTree;
    }

    /**
     * Method puts the node in the tree as the classic BST does. Then the tree is updated to be a regular red-black tree.
     *
     * @param node          Node
     * @param lo            KEY
     * @param hi            KEY
     * @param value         VALUE
     * @return              Node
     */
    private Node put(Node node, KEY lo, KEY hi, VALUE value) {
        if (node == null) return new Node(lo, hi, value, RED);     // add new node

        int compare = lo.compareTo(node.lo);
        if (compare < 0) node.left = put(node.left, lo, hi, value);            // key smaller than node's, go left
        else if (compare > 0) node.right = put(node.right, lo, hi, value);     // key bigger than node's, go right
        else node.value = value;                                            // update value

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);        // right red, rotate left
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);    // left and left.left red, rotate right
        if (isRed(node.left) && isRed(node.right)) flipColors(node);                // both red, flip colors

        // update max
        if (node.right != null && node.maxInSubTree.compareTo(node.right.maxInSubTree) < 0)
            node.maxInSubTree = node.right.maxInSubTree;

        return node;
    }

    /**
     * The node is red if is not null and it's incoming connection is red.
     *
     * @param node          Node
     * @return              boolean is node red
     */
    private boolean isRed(Node node) {
        return node != null && node.color; // == RED
    }

    /**
     * Return the first interval that matches input criteria.
     *
     * @param lo        KEY
     * @param hi        KEY
     * @return          VALUE
     */
    public VALUE get(KEY lo, KEY hi) {
        Node x = root;
        Interval target = new Interval(lo, hi);

        while (x != null) {
            if (x.interval.intersects(target)) return x.value;      // if intersects than return
            else if (x.left == null) x = x.right;                   // if left == null go right
            else if (x.left.maxInSubTree.compareTo(lo) < 0) x = x.right;    // if left.max < lo go right
            else x = x.left;
        }

        return null;        // not found
    }

    /**
     *       2                  4
     *      / \     ==>        / \
     *     1   4              2   5
     *        / \            / \
     *       3   5          1   3
     *
     * @param node      Node to get rotated
     * @return          Node new rotated root
     */
    private Node rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        return right;
    }

    /**
     *        4                 2
     *       / \               / \
     *      2   5   ==>       1   4
     *     / \                   / \
     *    1   3                 3   5
     *
     * @param node      Node to get rotated
     * @return          Node new rotated root
     */
    private Node rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;
        return left;
    }

    /**
     * Red links are double marked.
     *
     *           5                  5
     *          /                  //
     *         2      ==>          2
     *       // \\                / \
     *      1    3               1   3
     *
     * @param node      Node
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void delete(KEY lo, KEY hi) {
        throw new UnsupportedOperationException();
    }

    /**
     * Return all intervals that matches input criteria.
     *
     * @param lo        KEY
     * @param hi        KEY
     * @return          VALUE
     */
    public Collection<VALUE> intersects(KEY lo, KEY hi) {
        Collection<VALUE> queue = new ArrayDeque<>();

        intersects(new Interval(lo, hi), queue, root);

        return queue;
    }

    public void intersects(Interval target, Collection<VALUE> values, Node node) {
        if (node == null) return;

        if (node.left != null && node.left.maxInSubTree.compareTo(target.low) > 0) {    // if left.max > low go into left subtree
            intersects(target, values, node.left);
        }

        if (node.interval.intersects(target))       // if node and target intersects add to values
            values.add(node.value);

        if (node.right != null && node.lo.compareTo(target.high) < 0)     // high > node.lo go into right subtree
            intersects(target, values, node.right);
    }

    private class Node {
        private KEY lo;
        private Interval interval;
        private KEY maxInSubTree;
        private VALUE value;
        private Node left;
        private Node right;
        private boolean color;

        public Node(KEY lo, KEY hi, VALUE value, boolean color) {
            this.lo = lo;
            this.interval = new Interval(lo, hi);
            this.maxInSubTree = hi;
            this.value = value;
            this.color = color;
        }
    }

    private class Interval {
        private KEY low;
        private KEY high;

        public Interval(KEY low, KEY high) {
            this.low = low;
            this.high = high;
        }

        public boolean intersects(Interval interval) {
            return low.compareTo(interval.high) < 0 && high.compareTo(interval.low) > 0;
        }
    }
}
