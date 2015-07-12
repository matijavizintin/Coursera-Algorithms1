package w1;

/**
 * Created by Matija Vižintin
 * Date: 22. 06. 2015
 * Time: 18.27
 */
public class TimeComplexity {

    public static void approxTimeComplexity(double[] n, double[] t) {
        for (int i = 1; i < n.length; i++) {
            double t1 = t[i];
            double t2 = t[i - 1];
            double ratio = t1 / t2;
            double log_r = Math.log(ratio) / Math.log(2);

            double a = t1 / Math.pow(n[i], log_r);

            System.out.printf("n: %f, t: %f, r: %f, log_r: %f, a: %f\n", n[i], t1, ratio, log_r, a);
        }
        System.out.println();
    }

    public static void approxTeoreticTimeComplexity(double[] n, double[] t) {
        for (int i = 1; i < n.length; i++) {
            double x1 = Math.log(n[i]) / Math.log(2);
            double x2 = Math.log(n[i - 1]) / Math.log(2);
            double y1 = Math.log(t[i]) / Math.log(2);
            double y2 = Math.log(t[i - 1]) / Math.log(2);

            double k = (y1 - y2) / (x1 - x2);

            System.out.printf("x1: %f, y1: %f, x2: %f, y2: %f, k: %f\n", x1, y1, x2, y2, k);
        }
        System.out.println();
    }
}
