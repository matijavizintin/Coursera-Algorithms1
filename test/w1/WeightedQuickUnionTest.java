package w1;

import org.junit.Test;

/**
 * Created by Matija Vižintin
 * Date: 20. 06. 2015
 * Time: 18.49
 */
public class WeightedQuickUnionTest {

    @Test
    public void test1() {
        WeightedQuickUnion wqu = new WeightedQuickUnion(10);
        wqu.union(2, 3);
        wqu.union(1, 6);
        wqu.union(4, 0);
        wqu.union(9, 2);
        wqu.union(4, 6);
        wqu.union(2, 7);
        wqu.union(7, 8);
        wqu.union(5, 7);
        wqu.union(7, 6);
        wqu.print();
    }
}
