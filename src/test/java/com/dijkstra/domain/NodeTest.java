package com.dijkstra.domain;

import com.dijkstra.enums.NodeType;
import org.junit.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NodeTest {

    @Test
    public void shouldCreateANode() {
        String id = randomAlphabetic(10);
        int startingNodeCost = Integer.MAX_VALUE;

        Node node = new Node(id, NodeType.NODE);

        assertThat(node.getId(), is(id));
        assertThat(node.getNodeType(), is(NodeType.NODE));
        assertThat(node.getTotalCost(), is(startingNodeCost));
        assertThat(node.getPreviousNode(), is(id));
    }

    @Test
    public void shouldSetInitialNode() {
        String id = randomAlphabetic(10);
        int cost = 0;
        Node node = new Node(id, NodeType.NODE);

        Node initialNode = node.setAsInitial();

        assertThat(initialNode.getId(), is(id));
        assertThat(initialNode.getNodeType(), is(NodeType.START));
        assertThat(initialNode.getTotalCost(), is(cost));
        assertThat(initialNode.getPreviousNode(), is(id));
    }

    @Test
    public void shouldSetFinalNode() {
        String id = randomAlphabetic(10);
        int cost = Integer.MAX_VALUE;
        Node node = new Node(id, NodeType.NODE);

        Node initialNode = node.setAsFinal();

        assertThat(initialNode.getId(), is(id));
        assertThat(initialNode.getNodeType(), is(NodeType.FINISH));
        assertThat(initialNode.getTotalCost(), is(cost));
        assertThat(initialNode.getPreviousNode(), is(id));
    }
}