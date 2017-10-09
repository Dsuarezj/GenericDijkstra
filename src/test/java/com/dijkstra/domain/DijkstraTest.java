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

        List<Node> shortestPath = dijkstra.shortestPath(initialNode);

        assertThat(shortestPath.get(0).getId(), is(primitiveNode));
        assertThat(shortestPath.get(0).getTotalCost(), is(0));
        assertThat(shortestPath.get(0).getPreviousNode(), is(initialNode));
    }

    @Test
    public void shouldVisitTheNodeWithLowestCostFromInitialNode() {
        String firstPrimitiveEdge = "A::B::30";
        String secondPrimitiveEdge = "A::C::10";
        List<String> primitiveEdges = Arrays.asList(firstPrimitiveEdge, secondPrimitiveEdge);
        Node initialNode = new Node("A");
        Graph graph = new Graph(primitiveEdges);
        Dijkstra dijkstra = new Dijkstra(graph);

        List<Node> shortestPath = dijkstra.shortestPath(initialNode);

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
        initialNode.setPreviousNode(initialNode);
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

        List<Node> shortestPath = dijkstra.shortestPath(initialNode);

        assertReflectionEquals(expectedNodes, shortestPath);
    }

    @Test
    public void shouldCalculateTheShortestPath() {

        String firstPrimitiveEdge = "A::B::6";
        String secondPrimitiveEdge = "A::C::2";
        String thirdPrimitiveEdge = "B::C::5";
        String fourthPrimitiveEdge = "B::D::8";
        String fifthPrimitiveEdge = "B::E::12";
        String sixthPrimitiveEdge = "C::E::20";
        String seventhPrimitiveEdge = "D::E::1";
        String eighthPrimitiveEdge = "D::F::9";
        String ninthPrimitiveEdge = "E::F::4";
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

        List<Node> shortestPath = dijkstra.shortestPath(initialNode);

        assertThat(shortestPath.get(0).getId(), is("A"));
        assertThat(shortestPath.get(0).getTotalCost(), is(0));
        assertThat(shortestPath.get(5).getId(), is("F"));
        assertThat(shortestPath.get(5).getTotalCost(), is(19));

        for (Node node : shortestPath) {
            System.out.println("Id: " + node.getId() + "\t" +
                    "Previous Node: " + node.getPreviousNode().getId() + "\t" +
                    "Total cost: " + node.getTotalCost() + "\n");
        }
    }


    @Test
    public void shouldCalculateTheShortest() {
        String a1 = "1::2::550";
        String a3 = "1::4::1000";
        String a4 = "1::5::1200";
        String a5 = "2::6::260";
        String a7 = "4::12::800";
        String a8 = "5::8::350";
        String a9 = "6::10::450";
        String a11 = "8::9::250";
        String a12 = "9::13::350";
        String a13 = "10::14::550";
        String a15 = "12::18::1000";
        String a16 = "12::20::800";
        String a17 = "13::17::350";
        String a18 = "13::16::400";
        String a19 = "14::15::280";
        String a20 = "15::19::400";
        String a21 = "15::20::450";
        String a22 = "16::20::750";
        String a23 = "17::20::500";
        String a24 = "18::20::400";
        String a25 = "19::20::190";
        String a26 = "20::20::0";

        String idANode = "1";
        String idBNode = "2";
        String idCNode = "3";
        Node initialNode = new Node(idANode);
        initialNode.setTotalCost(0);
        initialNode.setAsVisitedNode();
        initialNode.addEdge(new Edge(idANode, idBNode, 6));
        initialNode.addEdge(new Edge(idANode, idCNode, 2));
        List<String> primitiveEdges = Arrays.asList(a1, a3, a4, a5,  a7, a8, a9,  a11, a12, a13,  a15, a16, a17, a18, a18, a19, a20, a21, a22, a23, a24, a25, a26);
        Graph graph = new Graph(primitiveEdges);
        Dijkstra dijkstra = new Dijkstra(graph);

        List<Node> shortestPath = dijkstra.shortestPath(initialNode);
        for (Node node : shortestPath) {
            System.out.println("Id: " + node.getId() + "\t" +
                    "Previous Node: " + node.getPreviousNode().getId() + "\t" +
                    "Total cost: " + node.getTotalCost() + "\n");
        }


    }
}






