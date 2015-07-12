package w1;

/**
 * Created by Matija Vižintin
 * Date: 20. 06. 2015
 * Time: 18.44
 */
public class WeightedQuickUnion extends QuickUnion {
    private int[] weight;

    public WeightedQuickUnion(int n) {
        super(n);

        weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = 1;
        }
    }

    @Override public void union(int p, int q) {
        int wp = weight[p];
        int wq = weight[q];

        if (wq > wp) {
            super.union(p, q);
            weight[q] += wp;
        } else {
            super.union(q, p);
            weight[p] += wq;
        }
    }
}
