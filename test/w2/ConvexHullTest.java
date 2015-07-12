package w2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Matija Vižintin
 * Date: 07. 07. 2015
 * Time: 21.19
 */
public class ConvexHullTest {
    private Random random = new Random();


    @Test
    public void test1() {
        Point2D[] array = new Point2D[] {new Point2D(4, 0), new Point2D(3, 1), new Point2D(2, 2), new Point2D(1, 1)};
        shuffle(array);

        List<Point2D> result = new ConvexHull().calculate(array);

        for (Point2D point2D : result) {
            System.out.println(point2D);
        }
    }

    @Test
    public void test2() {
        Point2D[] array =
                new Point2D[]{new Point2D(4, 0), new Point2D(5, 3), new Point2D(3, 1), new Point2D(2, 2), new Point2D(1, 1), new Point2D(1, 0)};
        shuffle(array);

        List<Point2D> result = new ConvexHull().calculate(array);

        for (Point2D point2D : result) {
            System.out.println(point2D);
        }
    }

    private void shuffle(Object[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + uniform(N-i);     // between i and N-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    private int uniform(int N) {
        if (N <= 0) throw new IllegalArgumentException("Parameter N must be positive");
        return random.nextInt(N);
    }
}
