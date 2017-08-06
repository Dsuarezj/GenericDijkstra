package com.dijkstra.domain;

import org.junit.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EdgeTest {

    @Test
    public void shouldCreateAEdge() {
        String idFirstNode = randomAlphabetic(10);
        String idSecondNode = randomAlphabetic(10);
        Node firstNode = new Node(idFirstNode);
        Node secondNode = new Node(idSecondNode);
        int cost = Integer.MAX_VALUE;

        Edge edge = new Edge(idFirstNode, idSecondNode, cost);

        assertThat(edge.getFirstNode(), is(firstNode));
        assertThat(edge.getSecondNode(), is(secondNode));
        assertThat(edge.getCost(), is(cost));
    }
}