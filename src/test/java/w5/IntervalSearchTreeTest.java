package w5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by Matija Vižintin
 * Date: 02. 08. 2015
 * Time: 13.44
 */
public class IntervalSearchTreeTest {

    @Test
    public void test() {
        IntervalSearchTree<Integer, String> tree = new IntervalSearchTree<>();

        tree.put(1, 2, "1-2");
        tree.put(4, 7, "4-7");
        tree.put(10, 15, "10-15");
        tree.put(18, 22, "18-22");
        tree.put(11, 19, "11-19");

        String value = tree.get(2, 3);
        Assert.assertEquals(null, value);

        value = tree.get(4,5);
        Assert.assertEquals("4-7", value);

        value = tree.get(1,2);
        Assert.assertEquals("1-2", value);

        value = tree.get(12, 13);
        Assert.assertTrue(value.equals("11-19") || value.equals("10-15"));

        value = tree.get(10, 11);
        Assert.assertEquals("10-15", value);

        // range
        Collection<String> intersects = tree.intersects(0, 10);
        Assert.assertEquals(2, intersects.size());
        System.out.println("Range: 0 - 10");
        for (String intersect : intersects) {
            System.out.println(intersect);
        }
        System.out.println();

        intersects = tree.intersects(10, 11);
        Assert.assertEquals(1, intersects.size());
        System.out.println("Range: 10 - 11");
        for (String intersect : intersects) {
            System.out.println(intersect);
        }
        System.out.println();

        intersects = tree.intersects(0, 24);
        Assert.assertEquals(5, intersects.size());
        System.out.println("Range: 0 - 24");
        for (String intersect : intersects) {
            System.out.println(intersect);
        }
        System.out.println();
    }

    @Test
    public void quit() {
        IntervalSearchTree<Integer, String> tree = new IntervalSearchTree<>();
        tree.put(24, 32, "A");
        tree.put(4, 31, "B");
        tree.put(18, 26, "C");
        tree.put(3, 33, "D");
        tree.put(10, 27, "E");
        tree.put(11, 37, "F");
        tree.put(12, 25, "G");
        tree.put(35, 39, "H");

        System.out.println(tree.toString());

    }
}
