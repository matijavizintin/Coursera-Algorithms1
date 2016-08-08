package w3;

import intfc.Sortable;
import org.junit.Assert;
import org.junit.Test;
import w2.ShellSort;
import w2.ShuffleSort;
import w4.HeapSort;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
    private int loops = 150;

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
        int size = 1000 * 1000 * 10;
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        ShuffleSort.shuffle(array);

        long start = System.currentTimeMillis();
        new QuickSort<Integer>().sort(array);
        long stop = System.currentTimeMillis();
        System.out.println(">>>>>" + (stop - start));
        assertSorted(array);

//        ShellSort.print(array);
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
    public void heapSort() {
        List<Integer[]> inputs = prepareInput();

        for (Integer[] input : inputs) {
            new HeapSort<Integer>().sort(input);
            try {
                assertSorted(input);
            } catch (Error e) {
                e.printStackTrace();
            }

//            ShellSort.print(input);
        }
    }
    
    @Test
    public void performanceTest() throws Exception {
        Thread.sleep(1000);     // initial delay

        // java system sort
        performSort(new JavaSystemSort<>(), prepareInput());

        // heap sort
        performSort(new HeapSort<>(), prepareInput());

        // quick sort 3-way
        performSort(new QuickSort3Way<Integer>(), prepareInput());

        // quick sort
        performSort(new QuickSort<Integer>(), prepareInput());

        // bottom-up merge sort
        performSort(new BottomUpMergeSort<Integer>(), prepareInput());

        // merge sort
        performSort(new MergeSort<Integer>(), prepareInput());

        // shell sort
        performSort(new ShellSort<Integer>(), prepareInput());

        // insertion sort
//        performSort(new InsertionSort<>(), array);

        // selection sort
//        performSort(new SelectionSort<>(), array);
    }

    private List<Integer[]> prepareInput() {
        int sizeTiny = 1000;
        int sizeSmall = 1000 * 100;
        int sizeBig = 1000 * 1000 * 5;
        List<Integer[]> result = new ArrayList<>();

        // ordered tiny
        Integer[] array = new Integer[sizeTiny];
        for (int i = 0; i < sizeTiny; i++) {
            array[i] = i;
        }
        result.add(array);

        // ordered small
        array = new Integer[sizeSmall];
        for (int i = 0; i < sizeSmall; i++) {
            array[i] = i;
        }
        result.add(array);

        // ordered big
        array = new Integer[sizeBig];
        for (int i = 0; i < sizeBig; i++) {
            array[i] = i;
        }
        result.add(array);

        // ordered tiny, duplicated keys on mod 10
        array = new Integer[sizeTiny];
        int mod = 10;
        for (int i = 0; i < sizeTiny; i++) {
            array[i] = i % mod;
        }
        result.add(array);

        // ordered small, duplicated keys on mod 100
        array = new Integer[sizeSmall];
        mod = 100;
        for (int i = 0; i < sizeSmall; i++) {
            array[i] = i % mod;
        }
        result.add(array);

        // ordered big, duplicated keys on mod 1000
        array = new Integer[sizeBig];
        mod = 1000;
        for (int i = 0; i < sizeBig; i++) {
            array[i] = i % mod;
        }
        result.add(array);

        // shuffled tiny
        array = new Integer[sizeTiny];
        for (int i = 0; i < sizeTiny; i++) {
            array[i] = i;
        }
        ShuffleSort.shuffle(array);
        result.add(array);

        // shuffled small
        array = new Integer[sizeSmall];
        for (int i = 0; i < sizeSmall; i++) {
            array[i] = i;
        }
        ShuffleSort.shuffle(array);
        result.add(array);

        // shuffled big
        array = new Integer[sizeBig];
        for (int i = 0; i < sizeBig; i++) {
            array[i] = i;
        }
        ShuffleSort.shuffle(array);
        result.add(array);

        // shuffled tiny, duplicated keys on mod 10
        array = new Integer[sizeTiny];
        mod = 10;
        for (int i = 0; i < sizeTiny; i++) {
            array[i] = i % mod;
        }
        ShuffleSort.shuffle(array);
        result.add(array);

        // shuffled small, duplicated keys on mod 100
        array = new Integer[sizeSmall];
        mod = 100;
        for (int i = 0; i < sizeSmall; i++) {
            array[i] = i % mod;
        }
        ShuffleSort.shuffle(array);
        result.add(array);

        // shuffled big, duplicated keys on mod 1000
        array = new Integer[sizeBig];
        mod = 1000;
        for (int i = 0; i < sizeBig; i++) {
            array[i] = i % mod;
        }
        ShuffleSort.shuffle(array);
        result.add(array);

        // all values the same tiny
        array = new Integer[sizeTiny];
        for (int i = 0; i < sizeTiny; i++) {
            array[i] = 0;
        }
        result.add(array);

        // all values the same small
        array = new Integer[sizeSmall];
        for (int i = 0; i < sizeSmall; i++) {
            array[i] = 0;
        }
        result.add(array);

        // all values the same big
        array = new Integer[sizeBig];
        for (int i = 0; i < sizeBig; i++) {
            array[i] = 0;
        }
        result.add(array);

        // half values the same tiny
        array = new Integer[sizeTiny];
        for (int i = 0; i < sizeTiny; i++) {
            array[i] = i % 2;
        }
        result.add(array);

        // half values the same small
        array = new Integer[sizeSmall];
        for (int i = 0; i < sizeSmall; i++) {
            array[i] = i % 2;
        }
        result.add(array);

        // half values the same big
        array = new Integer[sizeBig];
        for (int i = 0; i < sizeBig; i++) {
            array[i] = i % 2;
        }
        result.add(array);

        // descending order tiny
        array = new Integer[sizeTiny];
        for (int i = 0; i < sizeTiny; i++) {
            array[i] = sizeTiny - i;
        }
        result.add(array);

        // descending order small
        array = new Integer[sizeSmall];
        for (int i = 0; i < sizeSmall; i++) {
            array[i] = sizeSmall - i;
        }
        result.add(array);

        // descending order big
        array = new Integer[sizeBig];
        for (int i = 0; i < sizeBig; i++) {
            array[i] = sizeBig - i;
        }
        result.add(array);

        return result;
    }


    private void performSort(Sortable<Integer> algorithm, List<Integer[]> list) throws Exception {
        int differentInputs = list.size();

        ExecutorService service = Executors.newScheduledThreadPool(3);
        List<Future<Long>> handles = new ArrayList<>();
        for (int i = 0; i < loops; i++) {
            Future<Long> handle = service.submit(new TestExecutor(algorithm, list.get(i % differentInputs).clone()));
            handles.add(handle);
        }

        Long sum = 0L;
        for (Future<Long> handle : handles) {
            sum += handle.get();
        }
        System.out.printf("%s executed in %d ms\n", algorithm.getClass().getSimpleName(), sum / loops);
        Thread.sleep(1000);
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
            } catch (Error e) {
                e.printStackTrace();
            }
        }
    }
}
