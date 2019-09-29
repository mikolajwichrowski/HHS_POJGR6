package HHS_PROJGR6.Utils;

import HHS_PROJGR6.Interfaces.IEntity;

import java.util.*;

public class DijkstraAlgorithm {
    public int nodeCounter;

    public DijkstraAlgorithm() {

    }

    public Node getPossibilities() {
        // Set counter
        nodeCounter = 0;

        // Get all possibilities
        Node possibleRoutes = new Node(1, 10);
        possibleRoutes.x = 2;
        possibleRoutes.y = 7;

        Node destination = new Node(1, 10);
        destination.x = 5;
        destination.y = 5;

        if (possibleRoutes.y > possibleRoutes.y) {
            // Omhoog
            possibleRoutes.children.add(getPossibilitiesTree(possibleRoutes, destination, "LEFT,UP".split(",")));
            possibleRoutes.children.add(getPossibilitiesTree(possibleRoutes, destination, "RIGHT,UP".split(",")));
        } else {
            // Omlaag
            possibleRoutes.children.add(getPossibilitiesTree(possibleRoutes, destination, "LEFT,DOWN".split(",")));
            possibleRoutes.children.add(getPossibilitiesTree(possibleRoutes, destination, "RIGHT,DOWN".split(",")));
        }

        // Return tree of nodes
        return possibleRoutes;
    }

    public Node getPossibilitiesTree(Node current, Node destination, String[] direction) {
        nodeCounter++;
        Node sourceNode = current;
        sourceNode.node = nodeCounter;

        if (current.x != destination.x && current.y != destination.y) {
            // Als naar links kan
            if (current.x >= 8 && (direction[0] == "LEFT" || current.y == destination.y)) {
                current.x--;
                sourceNode.children.add(getPossibilitiesTree(sourceNode, destination, direction));
            } else if (current.x <= 1 && (direction[0] == "RIGHT" || current.y == destination.y)) {
                current.x++;
                sourceNode.children.add(getPossibilitiesTree(sourceNode, destination, direction));
            }

            // Als op transport
            if (current.x == 1 || current.x == 8) {
                // Als omhoog kan
                if (current.y >= destination.y && direction[1] == "UP") {
                    current.y--;
                    sourceNode.children.add(getPossibilitiesTree(sourceNode, destination, direction));
                } else if (current.y <= destination.y && direction[1] == "DOWN") {
                    current.y++;
                    sourceNode.children.add(getPossibilitiesTree(sourceNode, destination, direction));
                }
            }
        }

        return sourceNode;
    }

    public void findPath() {
        // De kortste route naar destination
        Node routes = getPossibilities();
    }
}