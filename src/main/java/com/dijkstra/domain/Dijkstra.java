package com.dijkstra.domain;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {


    private List<Node> visitNodes = new ArrayList<>();
    private List<Node> nodes;
    private List<Node> analyzedNodes = new ArrayList<>();

    public Dijkstra(Graph graph) {
        this.nodes = graph.getNodes();
    }

    public List<Node> calculateShortestPathFromNode(Node node) {
        Node actualNodeWithLowestCost = setInitialNode(node);
        int unvisitedNode = nodes.size() - 1;

        while (unvisitedNode > 0) {
            List<Edge> neighborsEdges = actualNodeWithLowestCost.getEdges();
            if (!neighborsEdges.isEmpty()) {
                analyzedNeighborsNode(neighborsEdges, actualNodeWithLowestCost);
            }
            actualNodeWithLowestCost = getNodeWithLowestCost(analyzedNodes);
            visitNode(actualNodeWithLowestCost);
            unvisitedNode--;
        }

        return visitNodes;
    }

    private void analyzedNeighborsNode(List<Edge> neighborsEdges, Node actualNode) {
        for (Edge edge : neighborsEdges) {
            int indexOfNodeToVisit = nodes.indexOf(edge.getSecondNode());
            Node nodeToVisit = nodes.get(indexOfNodeToVisit);

            int costFromActualNode = edge.getCost() + actualNode.getTotalCost();

            if (costFromActualNode < nodeToVisit.getTotalCost()) {
                nodeToVisit.setTotalCost(costFromActualNode);
                nodeToVisit.setPreviousNode(actualNode);
                analyzedNodes.add(nodeToVisit);
            }
        }
    }

    private Node getNodeWithLowestCost(List<Node> analyzedNodes) {
        Node nodeWithLowestCost = new Node();
        int actualCost = Integer.MAX_VALUE;

        for (Node node : analyzedNodes) {
            if (node.getTotalCost() < actualCost && !node.isVisitedNode()) {
                actualCost = node.getTotalCost();
                nodeWithLowestCost = node;
            }
        }

        return nodeWithLowestCost;
    }

    private Node setInitialNode(Node node) {
        Node initialNode = setInitialCost(node);
        visitNode(initialNode);
        return initialNode;
    }

    private Node setInitialCost(Node node) {
        int nodeIndex = nodes.indexOf(node);
        Node initialNode = nodes.get(nodeIndex);
        initialNode.setTotalCost(0);
        return initialNode;
    }

    private void visitNode(Node initialNode) {
        initialNode.setAsVisitedNode();
        visitNodes.add(initialNode);
    }
}
