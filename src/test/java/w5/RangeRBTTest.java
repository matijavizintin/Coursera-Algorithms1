package w5;

import org.junit.Assert;
import org.junit.Test;
import w2.ShuffleSort;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Matija Vižintin
 * Date: 30. 07. 2015
 * Time: 19.22
 */
public class RangeRBTTest {

    @Test
    public void test() {
        RangeRedBlackTree<Integer, Integer> tree = new RangeRedBlackTree<>();
        putShuffled(tree);

        boolean b = tree.contains(5);
        Assert.assertTrue(b);

        //int rankSize = tree.rangeSize(10, 15);
        //Assert.assertEquals(7, rankSize);

        Collection<Integer> integer = tree.range(10, 15);
        int counter = 10;
        for (int candidate : integer) {
            Assert.assertEquals(counter++, candidate);
        }
    }

    private void putShuffled(RangeRedBlackTree<Integer, Integer> tree) {
        Integer[] array = new Integer[100];
        Arrays.setAll(array, operand -> operand);
        ShuffleSort.shuffle(array);

        for (Integer integer : array) {
            tree.put(integer, integer);
        }
    }
}
