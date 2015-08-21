package w5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matija Vižintin
 * Date: 05. 08. 2015
 * Time: 20.41
 */
public class OrthogonalLineSegmentTest1 {

    @Test
    public void quiz() {
        List<Line> lines = new ArrayList<>();

        lines.add(new Line("A", 6, 13, 6, 18));
        lines.add(new Line("B", 12, 14, 12, 19));
        lines.add(new Line("C", 16, 15, 16, 18));
        lines.add(new Line("D", 3, 2, 19, 2));
        lines.add(new Line("E", 4, 1, 13, 1));
        lines.add(new Line("F", 15, 4, 18, 4));
        lines.add(new Line("G", 0, 8, 14, 8));
        lines.add(new Line("H", 2, 10, 7, 10));

        OrthogonalLineSegmentIntersectionSearch search = new OrthogonalLineSegmentIntersectionSearch(lines);

    }
}
