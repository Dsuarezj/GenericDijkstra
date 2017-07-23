package com.dijkstra.domain;

import com.dijkstra.enums.NodeType;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class GraphGeneratorTest {

    @Test
    public void shouldCreateAGraphGivenOneEdge() {
        String firstPrimitiveEdge = "A::B::30";
        Node firstNode = new Node("A", NodeType.NODE);
        Node secondNode = new Node("B", NodeType.NODE);
        Edge expectedEdge = new Edge(firstNode, secondNode, 30);
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge);
        GraphGenerator graph = new GraphGenerator(primitiveEdges);

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
        Node firstNode = new Node("A", NodeType.NODE);
        Node secondNode = new Node("C", NodeType.NODE);
        Edge expectedEdge = new Edge(firstNode, secondNode, 5);
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge, secondPrimitiveEdge);
        GraphGenerator graph = new GraphGenerator(primitiveEdges);

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
        GraphGenerator graph = new GraphGenerator(primitiveEdges);
        Node initialNode = new Node("A", NodeType.START);
        Node expectedFirstNode = new Node("B", NodeType.NODE);
        Node expectedSecondNode = new Node("C", NodeType.NODE);
        List<Node> expectedNeighbors = Arrays.asList(expectedFirstNode, expectedSecondNode);

        List<Node> neighborsNode = graph.getNeighbors(initialNode);

        assertReflectionEquals(expectedNeighbors, neighborsNode);
    }
}