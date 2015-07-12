package w2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created by Matija Vižintin
 * Date: 05. 07. 2015
 * Time: 10.02
 */
public class SortTest {

    @Test public void selectionSortTest() {
        Integer[] array = new Integer[]{1, 4, 5, 3, 9, 6, 7, 3, 2, 5, -1, -5, -14, -55, 55, 1234, 2134234, 234234, -1234, -2234, 234, 234, 22};

        new SelectionSort().sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }

    @Test
    public void insertionSortTest() {
        Integer[] array = new Integer[]{9, 2, 2, 8, 3, 1};

        new InsertionSort().sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }

    @Test
    public void shellSortTest() {
        Integer[] array = new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = new Random().nextInt();
        }

        new ShellSort().sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }

    @Test
    public void shuffleSortTest() {
        Integer[] array = new Integer[10];
        for (int i = 0; i < 10; i++) {
            array[i] = new Random().nextInt(100);
        }

        ShellSort.print(array);

        new ShellSort().sort(array);

        ShellSort.print(array);

        ShuffleSort.shuffle(array);

        ShellSort.print(array);
    }

    @Test
    public void selectionSortQuiz() {
        new SelectionSort().sort(new Integer[]{22, 74, 80, 99, 27, 93, 90, 18, 78, 51});
    }

    @Test
    public void insertionSortQuiz() {
        new InsertionSort().sort(new Integer[]{29, 34, 48, 50, 99, 38, 45, 33, 31, 83});
    }

    @Test
    public void shellSortQuit() {
        new ShellSort().sort(new Integer[]{79, 73, 98, 57, 50, 18, 82, 20, 86, 25});
    }

    @Test
    public void shellSortExample() {
        Character[] array = new Character[16];
        int counter = 0;
        for (char c : "SHELLSORTEXAMPLE".toCharArray()) {
            array[counter++] =  c;
        }
        new ShellSort().sort(array);
    }
}
