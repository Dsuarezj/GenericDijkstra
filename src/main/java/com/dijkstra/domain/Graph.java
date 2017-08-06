package com.dijkstra.domain;

import java.util.ArrayList;
import java.util.List;


public class Graph {

    private final List<String> primitiveEdges;
    private List<Node> nodes = new ArrayList<>();

    public Graph(List<String> primitiveEdges) {
        this.primitiveEdges = primitiveEdges;
    }

    public List<Node> getNodes() {
        addNodes();
        return nodes;
    }

    private void addNodes() {
        for (String primitiveEdge : primitiveEdges) {
            String[] splitEdge = primitiveEdge.split("::");
            String firstPrimitiveNode = splitEdge[0];
            String secondPrimitiveNode = splitEdge[1];
            int cost = Integer.parseInt(splitEdge[2]);
            Edge edge = new Edge(firstPrimitiveNode, secondPrimitiveNode, cost);
            Node firstNode = new Node(firstPrimitiveNode);
            Node secondNode = new Node(secondPrimitiveNode);
            addToGraph(firstNode, secondNode, edge);
        }
    }

    private void addToGraph(Node firstNode, Node secondNode, Edge edge) {
        if (!nodes.contains(firstNode)){
            firstNode.addEdge(edge);
            nodes.add(firstNode);
        } else {
            Node updateFirstNode = nodes.get(nodes.indexOf(firstNode));
            updateFirstNode.addEdge(edge);
        }
        if (!nodes.contains(secondNode)){
            nodes.add(secondNode);
        }
    }
}
