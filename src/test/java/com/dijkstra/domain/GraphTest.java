package com.dijkstra.domain;

import org.junit.Test;

import java.util.ArrayList;
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
        Edge expectedEdge = new Edge("A", "B", 30);
        firstNode.addEdge(expectedEdge);
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge);
        Graph graph = new Graph(primitiveEdges);

        List<Node> nodes = graph.getNodes();

        assertThat(nodes.size(), is(2));
        assertReflectionEquals(firstNode, nodes.get(0));
        assertReflectionEquals(secondNode, nodes.get(1));
        assertReflectionEquals(expectedEdge, nodes.get(0).getEdges().get(0));
        assertReflectionEquals(new ArrayList<Edge>(), nodes.get(1).getEdges());
    }

    @Test
    public void shouldCreateAGraphGiveTwoEdges() {
        String firstPrimitiveEdge = "A::B::30";
        String secondPrimitiveEdge = "A::C::10";
        String thirdPrimitiveEdge = "C::B::5";
        Node firstNode = new Node("A");
        Node secondNode = new Node("B");
        Node thirdNode = new Node("C");
        Edge expectedABEdge = new Edge("A", "B", 30);
        Edge expectedACEdge = new Edge("A", "C", 10);
        Edge expectedCBEdge = new Edge("C", "B", 5);
        firstNode.addEdge(expectedABEdge);
        firstNode.addEdge(expectedACEdge);
        thirdNode.addEdge(expectedCBEdge);
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge, secondPrimitiveEdge, thirdPrimitiveEdge);
        Graph graph = new Graph(primitiveEdges);

        List<Node> nodes = graph.getNodes();

        assertThat(nodes.size(), is(3));
        assertReflectionEquals(firstNode, nodes.get(0));
        assertReflectionEquals(secondNode, nodes.get(1));
        assertReflectionEquals(thirdNode, nodes.get(2));
        assertReflectionEquals(expectedABEdge, nodes.get(0).getEdges().get(0));
        assertReflectionEquals(expectedACEdge, nodes.get(0).getEdges().get(1));
        assertReflectionEquals(new ArrayList<Edge>(), nodes.get(1).getEdges());
        assertReflectionEquals(expectedCBEdge, nodes.get(2).getEdges().get(0));
    }
}