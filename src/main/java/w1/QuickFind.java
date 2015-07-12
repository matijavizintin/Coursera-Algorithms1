package w1;

/**
 * Created by Matija Vižintin
 * Date: 20. 06. 2015
 * Time: 18.39
 */
public class QuickFind {
    private int[] array;

    public QuickFind(int n) {
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public void union(int p, int q) {
        int px = array[p];
        int qx = array[q];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == px) {
                array[i] = qx;
            }
        }
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
