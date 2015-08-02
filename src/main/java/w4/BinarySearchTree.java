package w4;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by Matija Vižintin
 * Date: 14. 07. 2015
 * Time: 20.23
 */
public class BinarySearchTree<KEY extends Comparable<KEY>, VALUE> implements Iterable<KEY> {
    private Node root;

    public BinarySearchTree() {
    }

    public void put(KEY key, VALUE value) {
        root = put(root, key, value);
    }

    private Node put(Node node, KEY key, VALUE value) {
        if (node == null) return new Node(key, value);      // create new node

        int compare = key.compareTo(node.key);
        if (compare < 0) {      // key smaller than node.key, go in left subtree
            node.left = put(node.left, key, value);
        } else if (compare > 0) {           // key bigger than node.key, go in right subtree
            node.right = put(node.right, key, value);
        } else {
            node.value = value;     // set new value
        }

        // update count
        node.count = 1 + size(node.left) + size(node.right);

        // return node
        return node;
    }

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

    public void delete(KEY key) {
        delete(root, key);
    }

    private Node delete(Node node, KEY key) {
        if (node == null) return null;

        int comparison = key.compareTo(node.key);
        if (comparison < 0) {       // key is smaller than the node, go left
            node.left = delete(node.left, key);
        } else if (comparison > 0) {
            node.right = delete(node.right, key);
        } else {
            // we found the node
            if (node.right == null) return node.left;       // if no right child return left
            if (node.left == null) return node.right;       // if no left child return right

            // find min in right subtree
            Node deleted = node;
            node = min(deleted.right);

            // update left and right
            node.right = deleteMin(deleted.right);      // append to new node
            node.left = deleted.left;                   // append old left to new left
        }

        // update count
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Node min() {
        return min(root);
    }

    private Node min(Node node) {
        if (node == null) return null;

        // found the minimum if there is no more left
        if (node.left == null) return node;
        else return min(node.left);
    }

    public void deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;

        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public int size() {
        return root.count;
    }

    private int size(Node node) {
        return node != null ? node.count : 0;
    }

    public int rank(KEY key) {
        return rank(key, root);
    }

    private int rank(KEY key, Node node) {
        if (node == null) {
            return 0;           // tree ended
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {      // key is smaller than the node.key
            return rank(key, node.left);    // recursively through left subtree
        } else if (compare > 0) {       // key is bigger than the node.key
            return 1 + size(node.left) + rank(key, node.right);     // node + size of left subtree + recursively through right
        } else {            // key == node.key
            return size(node.left);     // size of left subtree
        }
    }

    public Iterator<KEY> iterator() {
        return null;
    }

    public Iterable<KEY> keys() {
        Queue<KEY> q = new ArrayDeque<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node node, Queue<KEY> q) {
        if (node == null) return;

        // go through the left subtree
        inorder(node.left, q);

        // add main node
        q.add(node.key);

        // go through the right subtree
        inorder(node.right, q);
    }

    private class Node {
        private KEY key;
        private VALUE value;
        private Node left;
        private Node right;
        private int count;

        public Node(KEY key, VALUE value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }


}
