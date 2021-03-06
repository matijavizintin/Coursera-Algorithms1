package w1;

import org.junit.Test;

/**
 * Created by Matija Vižintin
 * Date: 22. 06. 2015
 * Time: 18.30
 */
public class TimeComplexityTest {

    @Test
    public void quiz() {
        double[] n = new double[9];
        int val = 32;
        for (int i = 0; i < 9; i++) {
            n[i] = val;
            val *= 2;
        }

        double[] t = new double[] {
                     0.000,
                     0.001,
                     0.015,
                     0.112,
                     1.094,
                    10.366,
                    98.472,
                   940.545,
                  8870.836
        };

        TimeComplexity.approxTimeComplexity(n, t);

        System.out.println();
        TimeComplexity.approxTeoreticTimeComplexity(n, t);
    }

    @Test
    public void test1() {
        double[] n = new double[12];
        int val = 32;
        for (int i = 0; i < 12; i++) {
            n[i] = val *= 2;
        }
        double[] t = new double[]{
                0.,
                0.002,
                0.015,
                0.114,
                0.859,
                6.712,
                51.378,
                380.572,
                2878.205,
                0,
                724.384,
                3188.816};

        TimeComplexity.approxTimeComplexity(n, t);

        System.out.println();
        TimeComplexity.approxTeoreticTimeComplexity(n, t);
    }

    public int test2(int N) {
        int sum = 0;
        for (int i = 3 * N * N * N; i > 1; i = i / 2) {
            sum++;
        }

        //String s = NumberFormat.getIntegerInstance().format(3 * N * N * N);
        //System.out.printf("%s >>> %d", s, sum);
        return sum;
    }

    @Test
    public void test3() {
        int max = 0;
        for (int i = 0 ; i < 1000; i++) {
            int sum = test2(i);
            System.out.printf("n: %d, t(n): %d\n", i, sum);
        }
    }

    @Test
    public void test4() {
        for (int i = 0; i < 10000; i++) {
            double pow = Math.pow(i, 2);
            double log = Math.log(pow);

            System.out.printf("i: %d, p: %f, l: %f\n", i, pow, log);
        }
    }
}
