package com.dijkstra.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class DijkstraTest {

    @Test
    public void shouldSetCostOfInitialNodeToZero() {
        String firstPrimitiveEdge = "A::B::30";
        String primitiveNode = "A";
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge);
        Node initialNode = new Node(primitiveNode);
        Graph graph = new Graph(primitiveEdges);
        Dijkstra dijkstra = new Dijkstra(graph);

        dijkstra.visitAllNodes(initialNode);

        assertThat(dijkstra.getVisitedNodes().get(0).getId(), is(primitiveNode));
        assertThat(dijkstra.getVisitedNodes().get(0).getTotalCost(), is(0));
        assertThat(dijkstra.getVisitedNodes().get(0).getPreviousNode(), is(nullValue()));
    }

    @Test
    public void shouldVisitTheNodeWithLowestCostFromInitialNode() {
        String firstPrimitiveEdge = "A::B::30";
        String secondPrimitiveEdge = "A::C::10";
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge, secondPrimitiveEdge);
        Node initialNode = new Node("A");
        Graph graph = new Graph(primitiveEdges);
        Dijkstra dijkstra = new Dijkstra(graph);

        dijkstra.visitAllNodes(initialNode);

        assertThat(dijkstra.getVisitedNodes().get(1).getId(), is("C"));
        assertThat(dijkstra.getVisitedNodes().get(1).getTotalCost(), is(10));
        assertThat(dijkstra.getVisitedNodes().get(1).getPreviousNode(), is(initialNode));
        assertThat(dijkstra.getVisitedNodes().get(1).isVisitedNode(), is(true));
        assertThat(dijkstra.getVisitedNodes().get(0).isVisitedNode(), is(true));
    }
}