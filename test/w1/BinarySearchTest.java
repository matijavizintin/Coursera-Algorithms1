package w1;

import org.junit.Test;

/**
 * Created by Matija Vižintin
 * Date: 21. 06. 2015
 * Time: 20.11
 */
public class BinarySearchTest {

    @Test
    public void testBinary() {
        int[] array = new int[]{3, 5, 6, 7, 8, 9, 12, 15, 16, 17, 19, 22, 25, 26, 27, 29, 33, 35, 36, 39, 42, 45, 46, 49, 55, 57, 59, 61, 62, 63, 77};
        int result = new BinarySearch().binarySearch(array, 1500);
        System.out.println(result);
    }
}
