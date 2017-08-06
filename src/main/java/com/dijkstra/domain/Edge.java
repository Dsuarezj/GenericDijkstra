package com.dijkstra.domain;

public class Edge {

    private String firstNode;
    private String secondNode;
    private int cost;

    public Edge(String firstNode, String secondNode, int cost) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.cost = cost;
    }

    public Node getFirstNode() {
        return new Node(firstNode);
    }

    public Node getSecondNode() {
        return new Node (secondNode);
    }

    public int getCost() {
        return cost;
    }

}
