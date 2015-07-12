package w3;

import intfc.Sortable;
import org.junit.Assert;
import org.junit.Test;
import w2.ShellSort;
import w2.ShuffleSort;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Matija Vižintin
 * Date: 10. 07. 2015
 * Time: 20.18
 */
public class SortTest {
    private int loops = 7;

    @Test
    public void quiz() {
        Integer[] array = new Integer[] {70, 22, 71, 20, 54, 18, 85, 23, 77, 97, 96, 27 };
        new MergeSort<Integer>().sort(array);
        assertSorted(array);

        System.out.println("--------");
        Integer[] array2 = new Integer[] {25, 94, 79, 41, 19, 84, 66, 67, 90, 37 };
        new BottomUpMergeSort<Integer>().sort(array2);
        assertSorted(array);
    }

    @Test
    public void quiz2() {
        Integer[] array = new Integer[] {32, 40, 58, 74, 10, 88, 78, 91, 15, 14, 76, 41 };
        new QuickSort<Integer>().partition(array, 0, array.length - 1);

        ShellSort.print(array);

        Character[] array2 = new Character[]{'B', 'A', 'B', 'A', 'B', 'A', 'A' ,'A', 'B', 'B', 'A', 'A' };
        new QuickSort<Character>().partition(array2, 0, array.length - 1);

        ShellSort.print(array2);

        Integer[] array3 = new Integer[] {44, 54, 67, 44, 81, 44, 37, 57, 73, 43};
        new QuickSort3Way<Integer>().partition3Way(array3, 0, array3.length - 1);

        ShellSort.print(array3);
    }

    @Test
    public void mergeSort() {
        Integer[] array = new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = i;
        }
        ShuffleSort.shuffle(array);

        new MergeSort().sort(array);
        assertSorted(array);

        ShellSort.print(array);
    }

    @Test
    public void bottomUpMergeSort() {
        Integer[] array = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i;
        }
        ShuffleSort.shuffle(array);

        new BottomUpMergeSort<Integer>().sort(array);
        assertSorted(array);

        ShellSort.print(array);
    }

    @Test
    public void quickSort() {
        Integer[] array = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i;
        }
        ShuffleSort.shuffle(array);

        new QuickSort<Integer>().sort(array);
        assertSorted(array);

        ShellSort.print(array);
    }

    @Test
    public void quickSelect() {
        Integer[] array = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i;
        }
        ShuffleSort.shuffle(array);

        int element = 566;
        int val = new QuickSelect<Integer>().select(array, element);
        ShellSort.print(array);


        Assert.assertEquals(element, val);
    }
    
    @Test
    public void performanceTest() throws Exception {
        Thread.sleep(1000);     // initial delay

        // create array
        int mod = 1000;
        int size = 1000 * 1000 * 5;
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i % mod;
        }

        // quick sort 3-way
        performSort(new QuickSort3Way<Integer>(), array);

        // quick sort
        performSort(new QuickSort<Integer>(), array);

        // bottom-up merge sort
        performSort(new BottomUpMergeSort<Integer>(), array);

        // merge sort
        performSort(new MergeSort<Integer>(), array);

        // shell sort
        performSort(new ShellSort<Integer>(), array);

        // insertion sort
//        performSort(new InsertionSort<>(), array);

        // selection sort
//        performSort(new SelectionSort<>(), array);
    }


    private void performSort(Sortable<Integer> algorithm, Integer[] array) throws Exception {
        ExecutorService service = Executors.newScheduledThreadPool(7);
        List<Future<Long>> handles = new ArrayList<>();
        for (int i = 0; i < loops; i++) {
            Future<Long> handle = service.submit(new TestExecutor(algorithm, array.clone()));
            handles.add(handle);
        }

        Long sum = 0L;
        for (Future<Long> handle : handles) {
            sum += handle.get();
        }
        System.out.printf("%s executed in %d ms\n", algorithm.getClass().getSimpleName(), sum / loops);
    }

    private class TestExecutor implements Callable<Long> {
        private Sortable<Integer> algorithm;
        private Integer[] array;

        public TestExecutor(Sortable<Integer> algorithm, Integer[] array) {
            this.algorithm = algorithm;
            this.array = array;
        }

        @Override
        public Long call() throws Exception {
            Instant start = Clock.systemUTC().instant();
            ShuffleSort.shuffle(array);
            algorithm.sort(array);
            assertSorted();
            Instant stop = Clock.systemUTC().instant();
            return ChronoUnit.MILLIS.between(start, stop);
        }

        private void assertSorted() {
            for (int i = 0; i < array.length -1; i++) {
                try {
                    Assert.assertTrue(array[i] <= array[i + 1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void assertSorted(Integer[] array) {
        for (int i = 0; i < array.length -1; i++) {
            try {
                Assert.assertTrue(array[i] <= array[i + 1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
