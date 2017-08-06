package com.dijkstra.domain;

import com.dijkstra.enums.NodeType;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class GraphTest {

    @Test
    public void shouldCreateAGraphGivenOneEdge() {
        String firstPrimitiveEdge = "A::B::30";
        Node firstNode = new Node("A");
        Node secondNode = new Node("B");
        Edge expectedEdge = new Edge(firstNode, secondNode, 30);
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge);
        Graph graph = new Graph(primitiveEdges);

        List<Edge> edges = graph.getEdges();

        assertThat(edges.size(), is(1));
        assertReflectionEquals(expectedEdge.getFirstNode(), edges.get(0).getFirstNode());
        assertReflectionEquals(expectedEdge.getSecondNode(), edges.get(0).getSecondNode());
        assertThat(edges.get(0).getCost(), is(expectedEdge.getCost()));

    }

    @Test
    public void shouldCreateAGraphGiveTwoEdges() {
        String firstPrimitiveEdge = "A::B::30";
        String secondPrimitiveEdge = "A::C::5";
        Node firstNode = new Node("A");
        Node secondNode = new Node("C");
        Edge expectedEdge = new Edge(firstNode, secondNode, 5);
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge, secondPrimitiveEdge);
        Graph graph = new Graph(primitiveEdges);

        List<Edge> edges = graph.getEdges();

        assertThat(edges.size(), is(2));
        assertReflectionEquals(expectedEdge.getFirstNode(), edges.get(1).getFirstNode());
        assertReflectionEquals(expectedEdge.getSecondNode(), edges.get(1).getSecondNode());
        assertThat(edges.get(1).getCost(), is(expectedEdge.getCost()));
    }

    @Test
    public void shouldReturnTheNeighborsOfANode() {
        String firstPrimitiveEdge = "A::B::30";
        String secondPrimitiveEdge = "A::C::5";
        String thirdPrimitiveEdge = "X::Y::5";
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge, secondPrimitiveEdge, thirdPrimitiveEdge);
        Graph graph = new Graph(primitiveEdges);
        Node initialNode = new Node("A");
        Node expectedFirstNode = new Node("B");
        Node expectedSecondNode = new Node("C");
        Edge expectedFirstEdge = new Edge(initialNode, expectedFirstNode, 30);
        Edge expectedSecondEdge = new Edge(initialNode, expectedSecondNode, 5);
        List<Edge> expectedNeighbors = Arrays.asList(expectedFirstEdge, expectedSecondEdge);

        List<Edge> neighborsNode = graph.getNeighbors(initialNode);

        assertReflectionEquals(expectedNeighbors, neighborsNode);
    }
}