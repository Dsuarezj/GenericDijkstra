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

        List<Node> shortestPath =  dijkstra.calculateShortestPathFromNode(initialNode);

        assertThat(shortestPath.get(0).getId(), is(primitiveNode));
        assertThat(shortestPath.get(0).getTotalCost(), is(0));
        assertThat(shortestPath.get(0).getPreviousNode(), is(nullValue()));
    }

    @Test
    public void shouldVisitTheNodeWithLowestCostFromInitialNode() {
        String firstPrimitiveEdge = "A::B::30";
        String secondPrimitiveEdge = "A::C::10";
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge, secondPrimitiveEdge);
        Node initialNode = new Node("A");
        Graph graph = new Graph(primitiveEdges);
        Dijkstra dijkstra = new Dijkstra(graph);

        List<Node> shortestPath = dijkstra.calculateShortestPathFromNode(initialNode);

        assertThat(shortestPath.get(1).getId(), is("C"));
        assertThat(shortestPath.get(1).getTotalCost(), is(10));
        assertThat(shortestPath.get(1).getPreviousNode(), is(initialNode));
        assertThat(shortestPath.get(1).isVisitedNode(), is(true));
        assertThat(shortestPath.get(0).isVisitedNode(), is(true));
    }

    @Test
    public void shouldCalculateTheShortestPathGivenThreeNodes() {
        String firstPrimitiveEdge = "A::B::30";
        String secondPrimitiveEdge = "A::C::10";
        String thirdPrimitiveEdge = "C::B::5";
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge, secondPrimitiveEdge, thirdPrimitiveEdge);
        String idFirstNode = "A";
        String idSecondNode = "B";
        String idThirdNode = "C";
        Node initialNode = new Node(idFirstNode);
        initialNode.setTotalCost(0);
        initialNode.setAsVisitedNode();
        initialNode.addEdge(new Edge(idFirstNode, idSecondNode, 30));
        initialNode.addEdge(new Edge(idFirstNode, idThirdNode, 10));
        Node nodeC = new Node(idThirdNode);
        nodeC.setTotalCost(10);
        nodeC.setAsVisitedNode();
        nodeC.setPreviousNode(initialNode);
        nodeC.addEdge(new Edge(idThirdNode, idSecondNode, 5));
        Node finalNode = new Node(idSecondNode);
        finalNode.setPreviousNode(nodeC);
        finalNode.setTotalCost(15);
        finalNode.setPreviousNode(nodeC);
        finalNode.setAsVisitedNode();
        List<Node> expectedNodes = Arrays.asList(initialNode, nodeC, finalNode);
        Graph graph = new Graph(primitiveEdges);
        Dijkstra dijkstra = new Dijkstra(graph);

        List<Node> shortestPath = dijkstra.calculateShortestPathFromNode(initialNode);

        assertReflectionEquals(expectedNodes, shortestPath);
    }

    @Test
    public void shouldCalculateTheShortestPath() {

        String firstPrimitiveEdge = "A::B::6";
        String secondPrimitiveEdge = "A::C::2";
        String thirdPrimitiveEdge = "B::C::5";
        String fourthPrimitiveEdge = "B::D::8";
        String fifthPrimitiveEdge = "C::E::20";
        String sixthPrimitiveEdge = "D::E::1";
        String seventhPrimitiveEdge = "D::F::9";
        String eighthPrimitiveEdge = "E::F::4";
        String ninthPrimitiveEdge = "E::G::22";
        String idANode = "A";
        String idBNode = "B";
        String idCNode = "C";
        Node initialNode = new Node(idANode);
        initialNode.setTotalCost(0);
        initialNode.setAsVisitedNode();
        initialNode.addEdge(new Edge(idANode, idBNode, 6));
        initialNode.addEdge(new Edge(idANode, idCNode, 2));
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge, secondPrimitiveEdge, thirdPrimitiveEdge, fourthPrimitiveEdge, fifthPrimitiveEdge, sixthPrimitiveEdge, seventhPrimitiveEdge, eighthPrimitiveEdge, ninthPrimitiveEdge);
        Graph graph = new Graph(primitiveEdges);
        Dijkstra dijkstra = new Dijkstra(graph);

        List<Node> shortestPath = dijkstra.calculateShortestPathFromNode(initialNode);

        assertThat(shortestPath.get(0).getId(), is("A"));
        assertThat(shortestPath.get(0).getTotalCost(), is(0));
        assertThat(shortestPath.get(6).getId(), is("G"));
        assertThat(shortestPath.get(6).getTotalCost(), is(37));
    }
}