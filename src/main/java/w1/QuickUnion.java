package w1;

/**
 * Created by Matija Vižintin
 * Date: 20. 06. 2015
 * Time: 18.25
 */
public class QuickUnion {
    protected int[] array;

    public QuickUnion(int n) {
        this.array = new int[n];
        for (int i = 0; i < n; i++) {
            this.array[i] = i;
        }
    }

    public void union(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        array[rp] = array[rq];
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int p) {
        while (p != array[p]) {
            array[p] = array[array[p]];     // path compression - single pass impl
            p = array[p];
        }
        return p;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
