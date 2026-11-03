# GenericDijkstra

Academic project developed as a university exercise to find shortest paths in a
graph. The idea was to explore how this kind of algorithm could fit into a bus
network route-planning system; this repository contains an initial
implementation, not a full integration with a transport system.

Reference for the project context:
[EPN Digital Repository: reference document](https://bibdigital.epn.edu.ec/handle/15000/19573).

## Features

- Builds a graph from a list of edges with origin, destination, and cost.
- Computes cumulative costs from a start node using Dijkstra's algorithm.
- Stores each node's found cost and previous node, which is useful for
  reconstructing a path.
- Includes a Spring Boot web application with a welcome route.
- Includes unit tests for graph construction and path calculation.

Edges are represented in one direction (`origin -> destination`). To model a
bidirectional street or connection, also add the reverse edge. Costs must be
non-negative, as required by Dijkstra, and every node must be reachable from the
start node: the current implementation does not handle disconnected graphs. The
web app does not currently expose an endpoint to submit graphs or query routes;
the algorithm is used from the Java domain classes.

## Requirements

- Java 8
- Gradle installed

The project does not include a Gradle Wrapper, so `gradle` commands require a
local Gradle installation.

## Run the application

From the project root:

```bash
gradle bootRun
```

Once the application has started, visit [http://localhost:8080/](http://localhost:8080/)
or run:

```bash
curl http://localhost:8080/
```

The current response is:

```text
Hola!
```

## Use the algorithm from Java

Each edge is provided as a string in the format `origin::destination::cost`. For
example, this graph has a cheaper path from `A` to `B` via `C` (total cost 15
instead of 30):

```java
import com.dijkstra.domain.Dijkstra;
import com.dijkstra.domain.Graph;
import com.dijkstra.domain.Node;

import java.util.Arrays;
import java.util.List;

List<String> edges = Arrays.asList(
    "A::B::30",
    "A::C::10",
    "C::B::5"
);

Graph graph = new Graph(edges);
Dijkstra dijkstra = new Dijkstra(graph);
List<Node> visitedNodes = dijkstra.shortestPath(new Node("A"));
```

The result contains the nodes in visit order. Each node includes
`getTotalCost()` for its cumulative cost and `getPreviousNode()` to follow
previous nodes and rebuild the path. The edge format requires exactly three
parts separated by `::`.

## Run the tests

```bash
gradle test
```

Existing tests cover node and edge creation, plus several shortest-path
examples.

## Technologies

- Java 8
- Spring Boot 1.5
- Gradle
