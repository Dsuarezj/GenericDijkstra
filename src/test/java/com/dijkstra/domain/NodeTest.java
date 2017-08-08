package com.dijkstra.domain;

import org.junit.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NodeTest {

    @Test
    public void shouldCreateANode() {
        String id = randomAlphabetic(10);
        int startingNodeCost = Integer.MAX_VALUE;

        Node node = new Node(id);

        assertThat(node.getId(), is(id));
        assertThat(node.getActualTotalCost(), is(startingNodeCost));
    }

    @Test
    public void shouldSetTotalCost() {
        String id = randomAlphabetic(10);
        int newCost = Integer.parseInt(randomNumeric(3));
        Node node = new Node(id);

        node.setTotalCost(newCost);

        assertThat(node.getActualTotalCost(), is(newCost));
    }

    @Test
    public void shouldSetPreviousNode() {
        String actualNodeId = randomAlphabetic(10);
        String previousNodeId = randomAlphabetic(10);
        Node node = new Node(actualNodeId);
        Node previousNode = new Node(previousNodeId);

        node.setPreviousNode(previousNode);

        assertThat(node.getPreviousNode().getId(), is(previousNode.getId()));
    }

    @Test
    public void shouldSetVisitedNode() {
        String actualNodeId = randomAlphabetic(10);
        Node node = new Node(actualNodeId);

        node.setAsVisitedNode();

        assertThat(node.isVisitedNode(), is(true));
    }

    @Test
    public void shouldGetAndSetEdgesOfANode() {
        String actualNodeId = randomAlphabetic(10);
        String firstNeighbourNodeId = randomAlphabetic(10);
        String secondNeighbourNodeId = randomAlphabetic(10);
        Node actualNode = new Node(actualNodeId);
        Edge firstEdge = new Edge(actualNodeId, firstNeighbourNodeId, 30);
        Edge secondEdge = new Edge(actualNodeId, secondNeighbourNodeId, 30);

        actualNode.addEdge(firstEdge);
        actualNode.addEdge(secondEdge);

        assertThat(actualNode.getEdges().get(0), is(firstEdge));
        assertThat(actualNode.getEdges().get(1), is(secondEdge));
    }


}