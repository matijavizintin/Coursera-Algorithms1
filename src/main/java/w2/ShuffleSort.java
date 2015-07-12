package w2;

import java.util.Random;

/**
 * Created by Matija Vižintin
 * Date: 05. 07. 2015
 * Time: 12.00
 */
public class ShuffleSort {

    public static <T> void shuffle(T[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(i + 1);

            T tmp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = tmp;
        }
    }
}
