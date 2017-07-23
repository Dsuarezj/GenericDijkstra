package com.dijkstra.domain;

public class Edge {

    private Node firstNode;
    private Node secondNode;
    private int cost;

    public Edge(Node firstNode, Node secondNode, int cost) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.cost = cost;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getSecondNode() {
        return secondNode;
    }

    public int getCost() {
        return cost;
    }
}
