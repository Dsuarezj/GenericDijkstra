package com.dijkstra.domain;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    private Graph graph;

    private List<Node> visitNodes = new ArrayList<>();
    private List<Node> nodes;

    public Dijkstra(Graph graph) {
        this.graph = graph;
        this.nodes = graph.getNodes();
    }

    public void visitAllNodes(Node initialNode) {
        Node firstVisitedNode = setInitialNode(initialNode);

        Node nodeActualNode = firstVisitedNode;
        List<Edge> neighborsEdges = nodeActualNode.getEdges();
        Node neighborNodeWithLowestCost = new Node("");

        for (Edge edge : neighborsEdges) {
            int indexOfNodeToVisit = nodes.indexOf(edge.getSecondNode());

            Node neighborNode = nodes.get(indexOfNodeToVisit);
            neighborNode.setTotalCost(edge.getCost());
            neighborNode.setPreviousNode(firstVisitedNode);

            if (neighborNode.getTotalCost() < neighborNodeWithLowestCost.getTotalCost()) {
                neighborNodeWithLowestCost = neighborNode;
            }
        }
        neighborNodeWithLowestCost.setAsVisitedNode();
        visitNodes.add(neighborNodeWithLowestCost);
    }

    private Node setInitialNode(Node node) {
        int nodeIndex = nodes.indexOf(node);
        Node initialNode = nodes.get(nodeIndex);
        initialNode.setTotalCost(0);
        initialNode.setAsVisitedNode();
        visitNodes.add(initialNode);
        return initialNode;
    }

    public List<Node> getVisitedNodes() {
        return visitNodes;
    }
}
