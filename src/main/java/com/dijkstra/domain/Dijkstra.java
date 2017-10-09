package com.dijkstra.domain;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    private List<Node> visitedNodes = new ArrayList<>();
    private List<Node> nodes;

    public Dijkstra(Graph graph) {
        this.nodes = graph.getNodes();
    }

    public List<Node> shortestPath(Node initialNode) {
        Node actualNodeWithLowestCost = setInitialNode(initialNode);

        while (visitedNodes.size() < nodes.size()) {
            analyzedNeighbors(actualNodeWithLowestCost);
            actualNodeWithLowestCost = getNodeWithLowestCost();
            visitNode(actualNodeWithLowestCost);
        }

        return visitedNodes;
    }

    private void analyzedNeighbors(Node actualNode) {
        List<Edge> neighborsEdges = actualNode.getEdges();

        for (Edge edge : neighborsEdges) {
            Node neighborNode = getNodeFromGraph(edge.getSecondNode());

            int newCostToNode = edge.getCost() + actualNode.getTotalCost();

            if (neighborNode.getTotalCost() > newCostToNode) {
                neighborNode.setTotalCost(newCostToNode);
                neighborNode.setPreviousNode(actualNode);
            }
        }
    }

    private Node getNodeFromGraph(Node secondNode) {
        int indexOfNodeToVisit = nodes.indexOf(secondNode);
        return nodes.get(indexOfNodeToVisit);
    }

    private Node getNodeWithLowestCost() {
        Node nodeWithLowestCost = new Node();
        int actualCost = Integer.MAX_VALUE;

        for (Node node : nodes) {
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
        Node initialNode = getNodeFromGraph(node);
        initialNode.setTotalCost(0);
        initialNode.setPreviousNode(node);
        return initialNode;
    }

    private void visitNode(Node node) {
        node.setAsVisitedNode();
        visitedNodes.add(node);
    }
}

