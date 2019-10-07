package HHS_PROJGR6.Utils;

import HHS_PROJGR6.Entities.Entity;
import HHS_PROJGR6.Interfaces.IEntity;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static HHS_PROJGR6.Settings.getElevatorCost;
import static HHS_PROJGR6.Settings.getStairCost;

public class DijkstraAlgorithm {
    /**
     * 
     * @param width
     * @param height
     * @param entities
     * @return
     */
    public static ArrayList<Node> getGraph(Integer width, Integer height, List<IEntity> entities) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        // Transport points
        for (int x = 1; x <= width; x++) {
            for (int y = 1; y <= height; y++) {
                if ((x == width || x == 1) && Entity.getOnPosition(x, y, entities).size() > 0) {
                    Node node = new Node();
                    node.setPosition(x, y);

                    if (y != height && Entity.getOnPosition(x, y + 1, entities).size() > 0) {
                        Node below = new Node();
                        below.setPosition(node.getX(), node.getY() + 1);
                        below.setCost(x == 1 ? getElevatorCost() : getStairCost());
                        node.addNeighbour(below);
                    }

                    if (y != 1 && Entity.getOnPosition(x, y - 1, entities).size() > 0) {
                        Node below = new Node();
                        below.setPosition(node.getX(), node.getY() - 1);
                        below.setCost(x == 1 ? getElevatorCost() : getStairCost());
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

    /**
     * 
     * @param graph
     * @param node
     * @return
     */
    private static ArrayList<Node> shiftTo(ArrayList<Node> graph, Node node) {
        ArrayList<Node> shiftedNodes = graph;
        Node inspecting = null;

        boolean shifted = false;
        while (!shifted) {
            if (shiftedNodes.get(0).compare(node)) {
                shifted = true;
            } else {
                // Go to starting source position
                inspecting = shiftedNodes.get(0);
                shiftedNodes.remove(0);
                shiftedNodes.add(inspecting);
            }
        }

        return shiftedNodes;
    }

    /**
     * 
     * @param source
     * @param destination
     * @param graph
     * @return
     */
    public static List<Node> findPath(Node source, Node destination, ArrayList<Node> graph) {
        // Keep trach of visited and unvisited
        ArrayList<Node> visited = new ArrayList<Node>();
        ArrayList<Node> unvisited = shiftTo(graph, source);
        Node inspecting = unvisited.get(0);

        // Set cost of head
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
        visited = shiftTo(visited, destination);
        inspecting = visited.get(0);

        // Create final map
        ArrayList<Node> finalPath = new ArrayList<Node>();
        finalPath.add(inspecting);

        // Traverse path (destination -> source)
        boolean backToSource = false;
        while (!backToSource) {
            // Get lowest child from neighbours
            ArrayList<Node> neighbours = new ArrayList<Node>();
            for (Node node : visited) {
                // Where inspeciting is in children
                boolean foundInNeighbours = false;
                for (Node child : node.neighbours) {
                    foundInNeighbours = !foundInNeighbours ? child.compare(inspecting) : true;
                }

                boolean inPath = finalPath.stream().filter(e -> node.compare(e)).toArray().length > 0;
                if (foundInNeighbours && !inPath) {
                    neighbours.add(node);
                }
            }
            try {
                Node lowestChildNode = neighbours.stream().min(Comparator.comparing(Node::getCostToParent)).get();

                // Set current inspecting
                inspecting = lowestChildNode;

                // Add lowest child node
                finalPath.add(lowestChildNode);

                // If the parent is the source, we are done.
                if (lowestChildNode.getParent().compare(source)) {
                    backToSource = true;
                    inspecting = source;
                    inspecting.setCostToParent(0);
                    finalPath.add(inspecting);
                }
            } catch (Exception e) {
                backToSource = true;
            }

        }

        Collections.reverse(finalPath);

        return finalPath;
    }

    /**
     * 
     * @param x
     * @param y
     * @return
     */
    public static Node createLocationNode(Integer x, Integer y) {
        Node location = new Node();
        location.setPosition(x, y);
        return location;
    }
}