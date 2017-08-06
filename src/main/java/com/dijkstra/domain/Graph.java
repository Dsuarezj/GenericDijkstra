package com.dijkstra.domain;

import com.dijkstra.enums.NodeType;

import java.util.ArrayList;
import java.util.List;


public class Graph {

    private final List<String> primitiveEdges;
    private List<Edge> edges;

    public Graph(List<String> primitiveEdges) {
        this.primitiveEdges = primitiveEdges;
    }

    public List<Edge> getNeighbors(Node node) {
        getEdges();
        List<Edge> neighborsEdges = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getFirstNode().getId().equals(node.getId())) {
                neighborsEdges.add(edge);
            }
        }
        return neighborsEdges;
    }

    public List<Edge> getEdges() {
        edges = new ArrayList<>();
        for (String primitiveEdge : primitiveEdges) {
            Edge edge = toEdge(primitiveEdge);
            edges.add(edge);
        }
        return edges;
    }

    private Edge toEdge(String primitiveEdge) {
        String[] splitEdge = primitiveEdge.split("::");
        Node firstNode = new Node(splitEdge[0]);
        Node secondNode = new Node(splitEdge[1]);
        int cost = Integer.parseInt(splitEdge[2]);
        return new Edge(firstNode, secondNode, cost);
    }
}
