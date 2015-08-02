package w5;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Matija Vižintin
 * Date: 29. 07. 2015
 * Time: 17.58
 */
public class RedBlackTree<KEY extends Comparable<KEY>, VALUE> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    protected Node root;

    public RedBlackTree() {
    }

    /**
     * Returns value for the specified key. It goes down the tree until the key is found.
     *
     * @param key   KEY
     * @return      VALUE
     */
    public VALUE get(KEY key) {
        Node node = root;

        // until node is not null
        while (node != null) {
            int compare = key.compareTo(node.key);
            if (compare < 0) {      // key lower than node.key, go left
                node = node.left;
            } else if (compare > 0) {       // key bigger than node.key, go right
                node = node.right;
            } else {
                return node.value;      //  found
            }
        }

        // not found
        return null;
    }

    public void put(KEY key, VALUE value) {
        root = put(root, key, value);
    }

    public Iterable<KEY> keys() {
        Queue<KEY> q = new ArrayDeque<>();
        inorder(root, q);
        return q;
    }

    public int size() {
        return root.count;
    }

    /**
     * Returns the size of the node.
     *
     * @param node      Node
     * @return          int - size of the subtree
     */
    protected int size(Node node) {
        return node != null ? node.count : 0;
    }

    /**
     * Method recursively fills the queue with keys in ascending order.
     *
     * @param node          Node
     * @param queue         Queue<KEY>
     */
    private void inorder(Node node, Queue<KEY> queue) {
        if (node == null) return;

        // go through the left subtree
        inorder(node.left, queue);

        // add main node
        queue.add(node.key);

        // go through the right subtree
        inorder(node.right, queue);
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
     * Method puts the node in the tree as the classic BST does. Then the tree is updated to be a regular red-black tree.
     *
     * @param node          Node
     * @param key           KEY
     * @param value         VALUE
     * @return              Node
     */
    private Node put(Node node, KEY key, VALUE value) {
        if (node == null) return new Node(key, value, null, null, RED);     // add new node

        int compare = key.compareTo(node.key);
        if (compare < 0) node.left = put(node.left, key, value);            // key smaller than node's, go left
        else if (compare > 0) node.right = put(node.right, key, value);     // key bigger than node's, go right
        else node.value = value;                                            // update value

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);        // right red, rotate left
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);    // left and left.left red, rotate right
        if (isRed(node.left) && isRed(node.right)) flipColors(node);                // both red, flip colors

        // update count
        node.count = 1 + size(node.left) + size(node.right);

        return node;
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

    // NOTE: for quiz purposes
    public void printRedNodes() {
        Queue<Node> nodes = new ArrayDeque<>();
        inorderNodes(root, nodes);

        for (Node node : nodes) {
            if (node != root && node.color == RED)
                System.out.print(node.key + " ");
        }
        System.out.println("\n");
    }

    @Override
    public String toString() {
        Queue<Node> nodes = new ArrayDeque<>();
        inorderNodes(root, nodes);

        StringBuilder stringBuilder = new StringBuilder();
        for (Node node : nodes) {
            stringBuilder.append("KEY: ").append(node.key).append("\n VALUE: ").append(node.value)
                    .append("\n LEFT KID: ").append(node.left != null ? node.left.key : null).append("\n RIGHT KID: ")
                    .append(node.right != null ? node.right.key : null).append("\n RED: ").append(node.color)
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public String toStringSimple() {
        Queue<Node> nodes = new ArrayDeque<>();
        inorderNodes(root, nodes);

        StringBuilder stringBuilder = new StringBuilder();
        for (Node node : nodes) {
            stringBuilder.append(node.key).append(" --> ").append(node.left != null ? node.left.key : null)
                    .append(" --> ").append(node.right != null ? node.right.key : null).append("\n");
        }
        return stringBuilder.toString();
    }

    private void inorderNodes(Node node, Queue<Node> queue) {
        if (node == null) return;

        // go through the left subtree
        inorderNodes(node.left, queue);

        // add main node
        queue.add(node);

        // go through the right subtree
        inorderNodes(node.right, queue);
    }

    class Node {
        protected KEY key;
        protected VALUE value;
        protected Node left;
        protected Node right;
        protected boolean color;
        protected int count = 1;

        public Node(KEY key, VALUE value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }
}
