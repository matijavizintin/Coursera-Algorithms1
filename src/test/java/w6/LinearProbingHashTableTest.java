package w6;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Matija Vižintin
 * Date: 21. 08. 2015
 * Time: 20.15
 */
public class LinearProbingHashTableTest {

    @Test
    public void quiz() {
        LinearProbingHashTable<String, Integer> ht = new LinearProbingHashTable<>(10);

        ht.put("R", 2);
        ht.put("Y", 9);
        ht.put("N", 8);
        ht.put("Z", 0);
        ht.put("C", 7);
        ht.put("A", 5);
        ht.put("K", 5);
        ht.put("V", 6);
        ht.put("S", 3);
        ht.put("E", 9);

        ht.printKeys();
    }

    @Test
    public void test1() {
        LinearProbingHashTable<Integer, Integer> hashTable = new LinearProbingHashTable<>();

        for (int i = 0; i < 10; i++) {
            hashTable.put(i, i);
        }

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, (int)hashTable.get(i));
        }
    }

    @Test
    public void test2() {
        LinearProbingHashTable<Integer, Integer> hashTable = new LinearProbingHashTable<>();
        Integer value = hashTable.get(1);
        Assert.assertEquals(null, value);

        hashTable.put(10, 10);
        hashTable.put(10, 11);
        Assert.assertEquals(11, (int)hashTable.get(10));
    }

    @Test
    public void test3() {
        int size = 1000;
        int inputSize = 100;
        LinearProbingHashTable<ArtificialKey, Integer> hashTable = new LinearProbingHashTable<>(size);

        for (int i = 0; i < inputSize; i++) {
            hashTable.put(new ArtificialKey(i), i);
        }

        for (int i = 0; i < inputSize; i++) {
            Assert.assertEquals(i, (int) hashTable.get(new ArtificialKey(i)));
        }
    }

    public class ArtificialKey {
        int value;

        public ArtificialKey(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ArtificialKey that = (ArtificialKey) o;

            return value == that.value;

        }

        @Override
        public int hashCode() {
            return 0;       // fake hash code
        }
    }
}
