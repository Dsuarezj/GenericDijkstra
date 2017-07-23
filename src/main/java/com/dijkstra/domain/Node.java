package com.dijkstra.domain;

import com.dijkstra.enums.NodeType;

public class Node {

    private String id;
    private NodeType nodeType;
    private int totalCost;
    private String previousNode;

    public Node(String id, NodeType nodeType) {
        this.id = id;
        this.nodeType = nodeType;
        //Otra duda, el objeto debería contener la lógica de poner el costo para le nodo inicial?
        this.totalCost = nodeType == NodeType.START ? 0 : Integer.MAX_VALUE;
        this.previousNode = id;
    }

    public String getId() {
        return id;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public String getPreviousNode() {
        return previousNode;
    }

    public Node setAsInitial() {
        return new Node(this.id, NodeType.START);
    }

    public Node setAsFinal() {
        return new Node(this.id, NodeType.FINISH);
    }
}
