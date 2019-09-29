package HHS_PROJGR6.Utils;

import java.util.Comparator;

/**
 * Bron: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
 *
 */
class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node(Integer node, Integer cost)
    {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2)
    {
        if (node1.cost < node2.cost) {
            return -1;
        } else if (node1.cost > node2.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}
