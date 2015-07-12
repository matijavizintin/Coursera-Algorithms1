package intfc;

/**
 * Created by Matija Vižintin
 * Date: 10. 07. 2015
 * Time: 22.03
 */
public interface Sortable<T extends Comparable> {
    public void sort(T[] input);
}
