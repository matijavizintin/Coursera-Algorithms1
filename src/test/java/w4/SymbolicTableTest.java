package w4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Matija Vižintin
 * Date: 14. 07. 2015
 * Time: 19.07
 */
public class SymbolicTableTest {

    @Test
    public void testLinkedST() {
        LinkedSymbolicTable<String, String> linkedSymbolicTable = new LinkedSymbolicTable<>();

        linkedSymbolicTable.put("abc", "cba");
        linkedSymbolicTable.put("abcd", "dcba");
        linkedSymbolicTable.put("abcde", "edcba");
        linkedSymbolicTable.put("abcdef", "fedcba");
        linkedSymbolicTable.put("abcdefg", "gfedcba");

        String value = linkedSymbolicTable.get("abc");
        Assert.assertEquals("cba", value);

        value = linkedSymbolicTable.remove("abc");
        Assert.assertEquals("cba", value);

        value = linkedSymbolicTable.get("abc");
        Assert.assertEquals(null, value);

        linkedSymbolicTable.put("abc", "bbb");
        value = linkedSymbolicTable.get("abc");
        Assert.assertEquals("bbb", value);
    }

    @Test
    public void testSortedST() {
        SortedSymbolicTable<String, String> st = new SortedSymbolicTable<>();

        st.put("abc", "cba");
        st.put("abcd", "dcba");
        st.put("abcde", "edcba");
        st.put("abcdef", "fedcba");
        st.put("abcdefg", "gfedcba");
        st.put("a", "a1");

        String value = st.get("abc");
        Assert.assertEquals("cba", value);

        st.put("abc", "bbb");
        value = st.get("abc");
        Assert.assertEquals("bbb", value);
    }
}
