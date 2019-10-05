package HHS_PROJGR6.Utils;

import HHS_PROJGR6.Entities.Entity;
import HHS_PROJGR6.Interfaces.IEntity;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DijkstraAlgorithm {
    public int nodeCounter;

    // TODO: start -> stop
    public DijkstraAlgorithm() {

    }

    public List<Node> getGraph(Integer width, Integer height, List<IEntity> entities) {
        List<Node> nodes = new ArrayList<Node>();

        // Transport points
        for (int x = 1; x <= width; x++) {
            for (int y = 1; y <= height; y++) {
                if ((x == width || x == 1) && Entity.getOnPosition(x, y, entities).size() > 0) {
                    Node node = new Node();
                    node.setPosition(x, y);

                    if (y != height && Entity.getOnPosition(x, y + 1, entities).size() > 0) {
                        Node below = new Node();
                        below.setPosition(node.getX(), node.getY() + 1);
                        below.setCost(x == 1 ? 5 : 3); // right stairs are easier
                        node.addNeighbour(below);
                    }

                    if (y != 1 && Entity.getOnPosition(x, y - 1, entities).size() > 0) {
                        Node below = new Node();
                        below.setPosition(node.getX(), node.getY() - 1);
                        below.setCost(x == 1 ? 5 : 3); // right stairs are easier
                        node.addNeighbour(below);
                    }

                    if (x == width && Entity.getOnPosition(x - 1, y, entities).size() > 0) {
                        Node left = new Node();
                        left.setPosition(node.getX() - 1, node.getY());
                        node.addNeighbour(left);
                    }

                    if (x == 1 && Entity.getOnPosition(x + 1, y, entities).size() > 0) {
                        Node right = new Node();
                        right.setPosition(node.getX() + 1, node.getY());
                        node.addNeighbour(right);
                    }
                    nodes.add(node);
                }

            }
        }

        // Path points
        for (int x = 2; x <= width - 1; x++) {
            for (int y = 1; y <= height; y++) {
                if (Entity.getOnPosition(x, y, entities).size() > 0) {
                    Node node = new Node();
                    node.setPosition(x, y);

                    if (Entity.getOnPosition(x - 1, y, entities).size() > 0) {
                        Node left = new Node();
                        left.setPosition(node.getX() - 1, node.getY());
                        node.addNeighbour(left);
                    }

                    if (Entity.getOnPosition(x + 1, y, entities).size() > 0) {
                        Node right = new Node();
                        right.setPosition(node.getX() + 1, node.getY());
                        node.addNeighbour(right);
                    }

                    nodes.add(node);
                }
            }
        }

        return nodes;
    }

    public List<Node> findPath(Node source, Node destination, List<Node> graph) {
        List<Node> visited = new ArrayList<Node>();
        List<Node> unvisited = graph;
        Node inspecting = null;

        // Shift to source node
        boolean shifted = false;
        while (!shifted) {
            if (unvisited.get(0).compare(source)) {
                shifted = true;
            } else {
                // Go to starting source position
                inspecting = unvisited.get(0);
                unvisited.remove(0);
                unvisited.add(inspecting);
            }
        }

        inspecting.setCostToParent(0);
        visited.add(inspecting);

        // Check all nodes for weights
        while (unvisited.size() > 0) {
            // Check cost to each neighbour
            for (Node node : inspecting.neighbours) {
                Object[] neighbouring = unvisited.stream().filter(e -> node.compare(e)).toArray();

                // Don't go back in path
                if (neighbouring.length > 0) {
                    Node tracking = (Node) neighbouring[0];
                    tracking.setCostToParent(inspecting.getCostToParent() + tracking.getCost());
                    tracking.setParent(inspecting);
                    visited.add(tracking);
                }
            }

            // Node already visited
            unvisited.remove(inspecting);

            // Only check children where cost to parent of parent calculated
            Object[] inLine = unvisited.stream().filter(e -> {
                return e.getParent() != null && e.getParent().getCostToParent() != Integer.MAX_VALUE;
            }).toArray();

            inspecting = inLine.length > 0 ? (Node) inLine[0] : null;
        }

        // Reverse to traverse path
        Collections.reverse(visited);

        // Shift to destination node
        shifted = false;
        while (!shifted) {
            if (visited.get(0).compare(destination)) {
                shifted = true;
            } else {
                // Go to starting source position
                inspecting = visited.get(0);
                visited.remove(0);
                visited.add(inspecting);
            }
        }

        List<Node> finalPath = new ArrayList<Node>();

        // Find destination and traverse in shortest route
        Stream<Node> destinationNodes = visited.stream().filter(lookupElement -> {
            return lookupElement.compare(destination);
        });

        Node destinationNode = (Node) destinationNodes.min(Comparator.comparing(Node::getCostToParent)).get();
        finalPath.add(destinationNode);

        // Traverse path (destination -> source)
        boolean destinationFound = false;
        while (!destinationFound) {
            List<Node> nodes = visited.stream().filter(lookupElement -> {
                return lookupElement.getParent() != null && lookupElement.getParent().compare(finalPath.get(finalPath.size() - 1));
            }).collect(Collectors.toList());

            Node bestNode = nodes.size() > 0 ? nodes.stream().min(Comparator.comparing(Node::getCostToParent)).get() : null;
            if (bestNode != null) {
                finalPath.add(bestNode);
            } else {
                destinationFound = true;
            }
        }

        Collections.reverse(finalPath);

        return finalPath;
    }

    public static Node createLocationNode(Integer x, Integer y) {
        Node location = new Node();
        location.setPosition(x, y);
        return location;
    }
}