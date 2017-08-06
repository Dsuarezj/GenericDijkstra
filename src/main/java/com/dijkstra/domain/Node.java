package com.dijkstra.domain;

import com.dijkstra.enums.NodeType;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String id;

    private int totalCost;
    private Node previousNode;
    private boolean visitedNode;
    private List<Edge> edges;

    public Node(String id) {
        this.id = id;
        this.totalCost = Integer.MAX_VALUE;
        this.visitedNode = false;
        this.edges = new ArrayList<>();
    }

    public String getId() {
        return id;
    }


    public int getTotalCost() {
        return totalCost;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setVisitedNode(boolean visitedNode) {
        this.visitedNode = visitedNode;
    }

    public boolean isVisitedNode() {
        return visitedNode;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public List<Edge> getEdges() {
        return this.edges;
    }
}
