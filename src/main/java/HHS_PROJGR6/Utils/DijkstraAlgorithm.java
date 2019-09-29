package HHS_PROJGR6.Utils;

import HHS_PROJGR6.Interfaces.IEntity;

import java.util.*;

public class DijkstraAlgorithm {
    private int distance[];
    private Set<Integer> settled;
    private PriorityQueue<Node> priorityQueue;
    private int vertices; // Number of vertices
    List<List<Node>> adjacent;

    public DijkstraAlgorithm(int vertices) {
        this.vertices = vertices;
        distance = new int[vertices];
        settled = new HashSet<Integer>();
        priorityQueue = new PriorityQueue<Node>(vertices, new Node(null, null));
    }

    public List<List<Node>> possibilities(ArrayList<IEntity> entities, List<List<Node>> history, int[] yxSource, int[] yxDestination) {
        // Op basis van alle transport kijken welke routes er zijn.
        List<List<Node>> currentRoutes = history;
        // source is 7,2
        // destin is 5,5 de fittnes

        //w hile (yxSource[0] ) {

        // }



        return null;
    }

    // Function for Dijkstra's Algorithm
    public void calculate(List<List<Node>> adjacent, int source) {
        this.adjacent = adjacent;

        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // Add source node to the priority queue
        priorityQueue.add(new Node(source, 0));

        // Distance to the source is 0
        distance[source] = 0;
        while (settled.size() != vertices) {

            // remove the minimum distance node
            // from the priority queue
            int u = priorityQueue.remove().node;

            // adding the node whose distance is
            // finalized
            settled.add(u);

            neighbour(u);
        }
    }

    // Function to process all the neighbours
    // of the passed node
    private void neighbour(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adjacent.get(u).size(); i++) {
            Node v = adjacent.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = distance[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < distance[v.node]) {
                    distance[v.node] = newDistance;
                }

                priorityQueue.add(new Node(v.node, distance[v.node]));
            }
        }
    }
}