package HHS_PROJGR6.Utils;

import HHS_PROJGR6.Entities.Entity;
import HHS_PROJGR6.Interfaces.IEntity;

import java.util.*;

public class DijkstraAlgorithm {
    public int nodeCounter;
    private Node start;
    private Node destination;

    // TODO: start -> stop
    public DijkstraAlgorithm() {

    }

    public List<Node> getGraph(Integer width, Integer height, List<IEntity> entities) {
        List<Node> nodes = new ArrayList<Node>();

        // Transport points
        for (int x = 1; x <= width; x++) {
            for (int y = 1; y <= height; y++) {
                if (x == width || x == 1 && Entity.getOnPosition(x, y, entities).size() > 0) {
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
        // Dictionary<Node, Node> visited = new Dictionary<Node, Node>();
        // List<Node> unvisited = graph;
        // Node inspecting = unvisited.get(unvisited.indexOf(source));
        // inspecting.setCostToParent(0);
        // visited.add(inspecting);

        // while (unvisited.size() > 0) {
        // inspecting.neighbours.stream().forEach(node -> {
        // Node tracking = unvisited.get(unvisited.indexOf(node));
        // tracking.setCostToParent(inspecting.getCostToParent() + tracking.getCost());
        // if (visited.get(tracking).getCostToParent() > tracking.getCostToParent()) {
        // visited.put(tracking, inspecting);
        // }

        // });
        // visited.add(inspecting, null);
        // unvisited.remove(inspecting);
        // }
        return null;
        // TODO: zucht...
    }

    public Node getNodeFromLocation(Integer locationX, Integer locationY, List<Node> graph) {
        return null; // graph.stream().filter(node -> node.getX() == locationX && node.getY() ==
                     // locationY).toArray()[0];
    }
}