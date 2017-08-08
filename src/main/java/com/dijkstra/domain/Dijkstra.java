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

    public List<Node> calculateShortestPath(Node node) {
        Node initialNode = setInitialNode(node);
        int index = nodes.size();
        Node nodeWithLowestCost = initialNode;
        List<Node> analyzedNodes = new ArrayList<>();

        while (index > 1) {
            List<Edge> neighborsEdges = nodeWithLowestCost.getEdges();
            if (!neighborsEdges.isEmpty()) {
                for (Edge edge : neighborsEdges) {

                    int indexOfNodeToVisit = nodes.indexOf(edge.getSecondNode());
                    Node nodeToVisit = nodes.get(indexOfNodeToVisit);

                    int costFromActualNode = edge.getCost() + nodeWithLowestCost.getActualTotalCost();

                    if (costFromActualNode < nodeToVisit.getActualTotalCost() && !nodeToVisit.isVisitedNode()) {
                        nodeToVisit.setTotalCost(costFromActualNode);
                        nodeToVisit.setPreviousNode(nodeWithLowestCost);
                        analyzedNodes.add(nodeToVisit);
                    }
                }
            }
            nodeWithLowestCost = getNodeWithLowestCost(analyzedNodes);
            nodeWithLowestCost.setAsVisitedNode();
            visitNodes.add(nodeWithLowestCost);
            index --;
        }

        return visitNodes;
    }

    private Node getNodeWithLowestCost(List<Node> analyzedNodes) {
        Node nodeWithLowestCost = new Node();
        int actualCost = Integer.MAX_VALUE;

        for (Node node : analyzedNodes) {
            if (node.getActualTotalCost() < actualCost && !node.isVisitedNode()) {
                actualCost = node.getActualTotalCost();
                nodeWithLowestCost = node;
            }
        }

        return nodeWithLowestCost;
    }

    private Node setInitialNode(Node node) {
        int nodeIndex = nodes.indexOf(node);
        Node initialNode = nodes.get(nodeIndex);
        initialNode.setTotalCost(0);
        initialNode.setAsVisitedNode();
        visitNodes.add(initialNode);
        return initialNode;
    }
}
