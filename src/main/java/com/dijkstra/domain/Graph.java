package com.dijkstra.domain;

import java.util.ArrayList;
import java.util.List;


public class Graph {

    private List<Node> nodes = new ArrayList<>();

    public Graph(List<String> primitiveEdges) {
        createGraph(primitiveEdges);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    private void createGraph(List<String> primitiveEdges) {
        for (String primitiveEdge : primitiveEdges) {
            String[] splitEdge = primitiveEdge.split("::");
            String firstPrimitiveNode = splitEdge[0];
            String secondPrimitiveNode = splitEdge[1];
            int cost = Integer.parseInt(splitEdge[2]);
            Edge edge = new Edge(firstPrimitiveNode, secondPrimitiveNode, cost);
            Node firstNode = new Node(firstPrimitiveNode);
            Node secondNode = new Node(secondPrimitiveNode);
            addNodesToGraph(firstNode, secondNode, edge);
        }
    }

    private void addNodesToGraph(Node firstNode, Node secondNode, Edge edge) {
        addFirstNode(firstNode, edge);
        addSecondNode(secondNode);
    }

    private void addFirstNode(Node firstNode, Edge edge) {
        if (!nodes.contains(firstNode)){
            firstNode.addEdge(edge);
            nodes.add(firstNode);
        } else {
            addEdgeToExistedNode(firstNode, edge);
        }
    }

    private void addSecondNode(Node secondNode) {
        if (!nodes.contains(secondNode)){
            nodes.add(secondNode);
        }
    }

    private void addEdgeToExistedNode(Node firstNode, Edge edge) {
        int index = nodes.indexOf(firstNode);
        Node node = nodes.get(index);
        node.addEdge(edge);
    }
}
