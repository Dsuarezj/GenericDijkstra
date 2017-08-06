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

    public String getFirstNode() {
        return firstNode;
    }

    public String getSecondNode() {
        return secondNode;
    }

    public int getCost() {
        return cost;
    }

}
