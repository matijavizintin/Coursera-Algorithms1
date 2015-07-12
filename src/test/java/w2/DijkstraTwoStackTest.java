package w2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Matija Vižintin
 * Date: 03. 07. 2015
 * Time: 21.44
 */
public class DijkstraTwoStackTest {

    @Test
    public void test() {
        Double result = new DijkstraTwoStack().calculate("2 + (2 * 2)");
        Assert.assertEquals(result, 6, 0.01);

        result = new DijkstraTwoStack().calculate("(5 * 6) + ((6 / 3) % 3)");
        Assert.assertEquals(32, result, 0.1);
    }
}
