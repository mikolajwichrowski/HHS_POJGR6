package HHS_PROJGR6.Utils;

import java.util.Comparator;

import java.util.*;

public class Node {
    private int costToParent;

    private int x;
    private int y;

    private int cost;
    public List<Node> neighbours;

    public Node() {
        this.x = -1;
        this.y = -1;
        this.cost = 10;
        this.neighbours = new ArrayList<Node>();
        this.costToParent = Integer.MAX_VALUE; // There is no infinity in this one ...
    }

    public void setCostToParent(Integer costToParent) {
        this.costToParent = costToParent;
    }

    public Integer getCostToParent() {
        return this.costToParent;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCost() {
        return this.cost;
    }

    public void setPosition(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public List<Node> getNeighbours() {
        return this.neighbours;
    }

    public void addNeighbour(Node neighbour) {
        this.neighbours.add(neighbour);
    }
}
