package HHS_PROJGR6.Utils;

import java.util.Comparator;

import java.util.*;

public class Node {
    /**
     * 
     */
    private int costToParent;

    /**
     * 
     */
    private int x;

    /**
     * 
     */
    private int y;

    /**
     * 
     */
    private int cost;

    /**
     * 
     */
    public List<Node> neighbours;

    /**
     * 
     */
    public Node() {
        this.x = -1;
        this.y = -1;
        this.cost = 10;
        this.neighbours = new ArrayList<Node>();
        this.costToParent = Integer.MAX_VALUE; // There is no infinity in this one ...
    }

    /**
     * 
     * @param costToParent
     */
    public void setCostToParent(Integer costToParent) {
        this.costToParent = costToParent;
    }

    /**
     * 
     * @return
     */
    public Integer getCostToParent() {
        return this.costToParent;
    }

    /**
     * 
     * @param cost
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * 
     * @return
     */
    public Integer getCost() {
        return this.cost;
    }

    /**
     * 
     * @param x
     * @param y
     */
    public void setPosition(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @return
     */
    public Integer getX() {
        return this.x;
    }

    /**
     * 
     * @return
     */
    public Integer getY() {
        return this.y;
    }

    /**
     * 
     * @return
     */
    public List<Node> getNeighbours() {
        return this.neighbours;
    }

    /**
     * 
     * @param neighbour
     */
    public void addNeighbour(Node neighbour) {
        this.neighbours.add(neighbour);
    }
}
