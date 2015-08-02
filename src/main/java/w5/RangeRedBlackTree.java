package w5;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/**
 * Created by Matija Vižintin
 * Date: 30. 07. 2015
 * Time: 18.22
 */
public class RangeRedBlackTree<KEY extends Comparable<KEY>, VALUE> extends RedBlackTree<KEY, VALUE> {

    public int rank(KEY key) {
        return rank(key, root);
    }

    /**
     * This method returns the rank of the node with the associated key.
     *
     * @param key           KEY
     * @param node          Node
     * @return              int
     */
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

    public int rangeSize(KEY lower, KEY higher) {
        return rank(higher) - rank(lower) + (contains(higher) ? 1 : 0);
    }

    public boolean contains(KEY key) {
        return contains(key, root);
    }

    public Collection<KEY> range(KEY lower, KEY higher) {
        Queue<KEY> q = new ArrayDeque<>();
        range(q, lower, higher, root);

        return q;
    }

    /**
     * This method goes through the tree.
     *
     * - if current node is bigger than the lower limit it goes in the left subtree
     * - if the node is between lower and higher limit then is included in the collection
     * - if current node is smaller than the higher limit it goes in the right subtree
     *
     * @param collection        Collection<KEY>
     * @param lower             KEY
     * @param higher            KEY
     * @param node              Node
     */
    private void range(Collection<KEY> collection, KEY lower, KEY higher, Node node) {
        if (node == null) return;

        // if lower smaller than current node go left
        if (node.key.compareTo(lower) > 0) {
            range(collection, lower, higher, node.left);
        }

        // if current node in [lower, higher] then add to iterable
        if (node.key.compareTo(lower) >= 0 && node.key.compareTo(higher) <= 0) {
            collection.add(node.key);
        }

        // if higher bigger than current node go right
        if (node.key.compareTo(higher) < 0) {
            range(collection, lower, higher, node.right);
        }
    }

    /**
     * This method goes through the tree and checks if there is a node in the tree with the specified key.
     *
     * @param key       KEY
     * @param node      Node
     * @return          boolean
     */
    private boolean contains(KEY key, Node node) {
        if (node == null) return false;

        int compare = key.compareTo(node.key);
        if (compare < 0) return contains(key, node.left);       // go left
        else if (compare > 0) return contains(key, node.right); // go right
        else return true;
    }
}
