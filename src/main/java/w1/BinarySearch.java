package w1;

import java.util.Collections;

/**
 * Created by Matija Vižintin
 * Date: 21. 06. 2015
 * Time: 20.03
 */
public class BinarySearch {

    public int binarySearch(int[] ordered, int key) {
        int lowerIndex = 0;
        int higherIndex = ordered.length - 1;
        int loopCounter = 0;

        while (lowerIndex <= higherIndex) {
            int midIndex = lowerIndex + (higherIndex - lowerIndex) / 2;
            System.out.printf("LC: %d >> Lower: %d, Middle: %d, Higher: %d\n", ++loopCounter, lowerIndex, midIndex, higherIndex);

            if (key < ordered[midIndex]) {
                higherIndex = midIndex - 1;
            } else if (key > ordered[midIndex]) {
                lowerIndex = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }
}
