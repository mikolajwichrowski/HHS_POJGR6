package HHS_PROJGR6.Utils;

import HHS_PROJGR6.Interfaces.IEntity;

import java.util.*;

public class DijkstraAlgorithm {
    public int nodeCounter;
    private Node start;
    private Node destination;

    // TODO: start -> stop
    public DijkstraAlgorithm() {
        start = new Node(1, 10);
        start.x = 2;
        start.y = 7;

        destination = new Node(1, 10);
        destination.x = 5;
        destination.y = 5;
    }

    public Node getPossibilities(Node start, Node destination) {
        // Set counter
        nodeCounter = 0;
        Node possibleRoutes = start;

        if (start.y > destination.y) {
            // Omhoog
            possibleRoutes.children.add(getPossibilitiesTree(start, destination, "LEFT,UP".split(",")));
            // possibleRoutes.children.add(getPossibilitiesTree(start, destination,
            // "RIGHT,UP".split(",")));
        } else {
            // Omlaag
            // possibleRoutes.children.add(getPossibilitiesTree(start, destination,
            // "LEFT,DOWN".split(",")));
            // possibleRoutes.children.add(getPossibilitiesTree(start, destination,
            // "RIGHT,DOWN".split(",")));
        }

        // Return tree of nodes
        return possibleRoutes;
    }

    public Node getPossibilitiesTree(Node sourceNode, Node destination, String[] direction) {
        // TODO: infinite !!!!!!!!!
        nodeCounter = nodeCounter + 1;

        Node current = sourceNode;
        current.node = nodeCounter;
        current.cost = current.cost + sourceNode.cost;

        // Als we nog niet het eindpunt hebben gevonden
        if (sourceNode.x != destination.x && sourceNode.y != destination.y) {

            // Als naar links kan
            if (sourceNode.x >= 8 && (direction[0] == "LEFT" || (direction[0] != "LEFT" && sourceNode.y == destination.y))) {
                current.x = current.x - 1;
                current.children.add(getPossibilitiesTree(current, destination, direction));
            } else if (sourceNode.x <= 1 && (direction[0] == "RIGHT" || (direction[0] != "RIGHT" && sourceNode.y == destination.y))) {
                current.x = current.x + 1;
                current.children.add(getPossibilitiesTree(current, destination, direction));
            }

            // Als op transport
            if (sourceNode.x == 1 || sourceNode.x == 8) {
                // Als omhoog kan
                if (sourceNode.y >= destination.y && direction[1] == "UP") {
                    current.y = current.y - 1;
                    current.children.add(getPossibilitiesTree(current, destination, direction));
                } else if (sourceNode.y <= destination.y && direction[1] == "DOWN") {
                    current.y = current.y + 1;
                    current.children.add(getPossibilitiesTree(current, destination, direction));
                }
            }
        }

        return sourceNode;
    }

    public List<Node> findPath() {
        return lookupPath(getPossibilities(this.start, this.destination), new ArrayList<Node>());
    }

    private List<Node> lookupPath(Node tree, List<Node> lowestPath) {
        // De kortste route naar destination
        if (tree.children.size() > 0 && lowestPath.size() < 20) {
            try {
                Node lowest = this.lowest(tree.children);
                lowestPath.add(lowest);

                return lookupPath(lowest, lowestPath);
            } catch (Exception e) {
                System.out.println("error when node " + tree.node + ", " + tree.children.size());
                return lowestPath;
            }

        } else {
            return lowestPath;
        }
    }

    // Find lowest cost from list of nodes
    private Node lowest(List<Node> comparables) {
        int min = Integer.MAX_VALUE;
        Node lowestNode = comparables.get(0);

        for (Node compare : comparables) {
            if (compare.cost < min) {
                lowestNode = compare;
                min = compare.cost;
            }
        }

        return lowestNode;
    }
}