package w1;

import org.junit.Test;

/**
 * Created by Matija Vižintin
 * Date: 20. 06. 2015
 * Time: 18.32
 */
public class QuickFindTest {

    @Test
    public void test1() {
        QuickFind qf = new QuickFind(10);
        qf.union(5, 0);
        qf.union(7, 3);
        qf.union(0, 6);
        qf.union(5, 1);
        qf.union(9, 4);
        qf.union(3, 4);
        qf.print();
    }
}
