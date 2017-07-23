package com.dijkstra.domain;

import com.dijkstra.enums.NodeType;

import java.util.ArrayList;
import java.util.List;


public class GraphGenerator {

    private final List<String> primitiveEdges;
    private List<Edge> edges;

    public GraphGenerator(List<String> primitiveEdges) {
        this.primitiveEdges = primitiveEdges;
    }

    public List<Edge> getEdges() {
        edges = new ArrayList<>();
        for (String primitiveEdge : primitiveEdges) {
            Edge edge = toEdge(primitiveEdge);
            edges.add(edge);
        }
        return edges;
    }

    public List<Node> getNeighbors(Node node) {
        getEdges();
        List<Node> neighborsNode = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getFirstNode().getId().equals(node.getId())) {
                neighborsNode.add(edge.getSecondNode());
            }
        }
        return neighborsNode;
    }

    private Edge toEdge(String primitiveEdge) {
        String[] splitEdge = primitiveEdge.split("::");
        Node firstNode = new Node(splitEdge[0], NodeType.NODE);
        Node secondNode = new Node(splitEdge[1], NodeType.NODE);
        int cost = Integer.parseInt(splitEdge[2]);
        return new Edge(firstNode, secondNode, cost);
    }
}
