package HHS_PROJGR6.Utils;

import java.util.Comparator;

import java.util.*;

public class Node {
    public int node;
    public int cost;
    public List<Node> children;

    public int x;
    public int y;

    public Node(Integer node, Integer cost) {
        this.x = 0;
        this.y = 0;

        this.node = node;
        this.cost = cost;
        this.children = new ArrayList<Node>();
    }
}
