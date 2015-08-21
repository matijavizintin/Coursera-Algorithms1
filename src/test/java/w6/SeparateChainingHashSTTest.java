package w6;

import org.junit.Assert;
import org.junit.Test;
import w4.SortedSymbolicTable;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Created by Matija Vižintin
 * Date: 11. 08. 2015
 * Time: 22.55
 */
public class SeparateChainingHashSTTest {

    @Test
    public void quiz() {
        SeparateChainingHashST<String, Integer> ht = new SeparateChainingHashST<>(3);
        ht.put("F", 1);
        ht.put("Q", 0);
        ht.put("I", 1);
        ht.put("E", 0);
        ht.put("G", 2);
        ht.put("M", 2);
        ht.put("D", 2);
        ht.put("K", 0);
        ht.put("U", 1);
        ht.put("R", 1);
        ht.put("P", 2);
        ht.put("V", 2);

        Integer res = ht.get("N");
        System.out.println("res = " + res);
    }

    @Test
    public void test() {
        SeparateChainingHashST<Integer, String> hashTable = new SeparateChainingHashST<>();

        hashTable.put(1, "a");
        hashTable.put(2, "b");
        hashTable.put(3, "c");
        hashTable.put(4, "d");
        hashTable.put(5, "e");
        hashTable.put(6, "f");
        hashTable.put(7, "g");

        String value = hashTable.get(1);
        Assert.assertEquals("a", value);

        value = hashTable.get(2);
        Assert.assertEquals("b", value);

        value = hashTable.get(3);
        Assert.assertEquals("c", value);

        value = hashTable.get(4);
        Assert.assertEquals("d", value);

        value = hashTable.get(5);
        Assert.assertEquals("e", value);

        value = hashTable.get(6);
        Assert.assertEquals("f", value);

        value = hashTable.get(7);
        Assert.assertEquals("g", value);
    }

    @Test
    public void duplicatedValues() {
        SeparateChainingHashST<Integer, String> hashTable = new SeparateChainingHashST<>();

        hashTable.put(1, "1");
        hashTable.put(1, "2");

        String value = hashTable.get(1);
        Assert.assertEquals("2", value);
    }

    @Test
    public void test1k() {
        Instant start = Clock.systemUTC().instant();

        SeparateChainingHashST<Integer, Integer> hashTable = new SeparateChainingHashST<>(200);
        for (int i = 0; i < 1000; i++) {
            hashTable.put(i, i);
        }

        for (int i = 0; i < 1000; i++) {
            int value = hashTable.get(i);
            Assert.assertEquals(value, i);
        }

        Instant stop = Clock.systemUTC().instant();
        long elapsed = ChronoUnit.MILLIS.between(start, stop);
        System.out.println(elapsed);
    }

    @Test
    public void test100k() {
        Instant start = Clock.systemUTC().instant();

        SeparateChainingHashST<Integer, Integer> hashTable = new SeparateChainingHashST<>(20000);
        for (int i = 0; i < 100000; i++) {
            hashTable.put(i, i);
        }

        for (int i = 0; i < 100000; i++) {
            int value = hashTable.get(i);
            Assert.assertEquals(value, i);
        }

        Instant stop = Clock.systemUTC().instant();
        long elapsed = ChronoUnit.MILLIS.between(start, stop);
        System.out.println(elapsed);
    }

    @Test
    public void test1M() {
        Instant start = Clock.systemUTC().instant();

        int size = 1000 * 1000;
        int hashSize = 1000 * 300;

        SeparateChainingHashST<Integer, Integer> hashTable = new SeparateChainingHashST<>(hashSize);
        for (int i = 0; i < size; i++) {
            hashTable.put(i, i);
        }

        for (int i = 0; i < size; i++) {
            int value = hashTable.get(i);
            Assert.assertEquals(value, i);
        }

        Instant stop = Clock.systemUTC().instant();
        long elapsed = ChronoUnit.MILLIS.between(start, stop);
        System.out.println(elapsed);
    }

    @Test
    public void test1kSST() {
        Instant start = Clock.systemUTC().instant();

        SortedSymbolicTable<Integer, Integer> hashTable = new SortedSymbolicTable<>();
        for (int i = 0; i < 1000; i++) {
            hashTable.put(i, i);
        }

        for (int i = 0; i < 1000; i++) {
            int value = hashTable.get(i);
            Assert.assertEquals(value, i);
        }

        Instant stop = Clock.systemUTC().instant();
        long elapsed = ChronoUnit.MILLIS.between(start, stop);
        System.out.println(elapsed);
    }

    @Test
    public void test100kSST() {
        Instant start = Clock.systemUTC().instant();

        SortedSymbolicTable<Integer, Integer> hashTable = new SortedSymbolicTable<>();
        for (int i = 0; i < 100000; i++) {
            hashTable.put(i, i);
        }

        for (int i = 0; i < 100000; i++) {
            int value = hashTable.get(i);
            Assert.assertEquals(value, i);
        }

        Instant stop = Clock.systemUTC().instant();
        long elapsed = ChronoUnit.MILLIS.between(start, stop);
        System.out.println(elapsed);
    }

    @Test
    public void test1MSST() {
        Instant start = Clock.systemUTC().instant();

        int size = 1000 * 1000;
        SortedSymbolicTable<Integer, Integer> hashTable = new SortedSymbolicTable<>();
        for (int i = 0; i < size; i++) {
            hashTable.put(i, i);
        }

        for (int i = 0; i < size; i++) {
            int value = hashTable.get(i);
            Assert.assertEquals(value, i);
        }

        Instant stop = Clock.systemUTC().instant();
        long elapsed = ChronoUnit.MILLIS.between(start, stop);
        System.out.println(elapsed);
    }
}
