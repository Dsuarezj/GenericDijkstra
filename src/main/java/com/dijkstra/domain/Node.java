package com.dijkstra.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    public Node() {

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

    public void setAsVisitedNode() {
        this.visitedNode = true;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return new EqualsBuilder()
                .append(id, node.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }
}
