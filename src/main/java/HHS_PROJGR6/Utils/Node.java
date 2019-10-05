package HHS_PROJGR6.Utils;

import java.util.Comparator;

import java.util.*;

public class Node {
    /**
     * 
     */
    private Node parent;

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
     * @param parent
     *                   the parent to set
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * @return the parent
     */
    public Node getParent() {
        return parent;
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

    /**
     * 
     * @param other
     */
    public boolean compare(Node other) {
        return this.getX() == other.getX() && this.getY() == other.getY();
    }
}
