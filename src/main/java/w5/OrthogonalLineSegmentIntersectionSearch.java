package w5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Matija Vižintin
 * Date: 05. 08. 2015
 * Time: 19.15
 */
public class OrthogonalLineSegmentIntersectionSearch {
    private TreeMap<Node, Line> map = new TreeMap<>();
    private RangeRedBlackTree<Integer, Line> tree = new RangeRedBlackTree<>();

    public OrthogonalLineSegmentIntersectionSearch(List<Line> lines) {
        processLines(lines);
        sweep();
    }

    private void processLines(List<Line> lines) {
        for (Line line : lines) {
            // start node
            Node startNode = new Node(line.x1, true);
            map.put(startNode, line);

            // end node
            if (line.x1 != line.x2) {
                Node endNod = new Node(line.x2, false);
                map.put(endNod, line);
            }
        }
    }

    private void sweep() {
        for (Node node : map.keySet()) {
            Line line = map.get(node);
            if (line.isVertical()) {
                System.out.println(tree);

                Collection<Integer> keys = tree.range(line.y1, line.y2);
                List<Line> values = new ArrayList<>();
                for (Integer key : keys) {
                    if (tree.get(key) != null) {
                        values.add(tree.get(key));
                    }
                }
                System.out.println("values = " + values);
            } else {
                if (node.start) {
                    // add to tree
                    tree.put(line.y1, line);
                } else {
                    // this is actually remove
                    tree.put(line.y1, null);
                }
            }

        }
    }


    public class Node implements Comparable<Node> {
        private Integer key;
        private boolean start;

        public Node(Integer key, boolean start) {
            this.key = key;
            this.start = start;
        }

        @Override
        public int compareTo(Node o) {
            int cmp = key.compareTo(o.key);
            if (cmp == 0) {
                return Boolean.compare(start, o.start);
            }
            return cmp;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", start=" + start +
                    '}';
        }
    }
}

class Line {
    public Integer x1;
    public Integer x2;
    public Integer y1;
    public Integer y2;
    public String name;

    public Line(String name, Integer x1, Integer y1, Integer x2, Integer y2) {
        this.name = name;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public boolean isVertical() {
        return x1.equals(x2);
    }

    @Override
    public String toString() {
        return "Line{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", name='" + name + '\'' +
                '}';
    }
}
