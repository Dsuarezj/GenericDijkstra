# GenericDijkstra

Proyecto académico desarrollado como un ejercicio universitario para encontrar
caminos más cortos dentro de un grafo. La idea era explorar cómo este tipo de
algoritmo podría integrarse en un sistema de planificación de rutas para una
red de buses; este repositorio contiene una implementación inicial y no una
integración completa con un sistema de transporte.

Como referencia para el contexto del proyecto:
[Repositorio Digital EPN: documento de referencia](https://bibdigital.epn.edu.ec/handle/15000/19573).

## Funcionalidades

- Construye un grafo a partir de una lista de aristas con origen, destino y costo.
- Calcula costos acumulados desde un nodo inicial mediante el algoritmo de
  Dijkstra.
- Conserva en cada nodo el costo encontrado y el nodo previo, información útil
  para reconstruir una ruta.
- Incluye una aplicación web Spring Boot con una ruta de bienvenida.
- Incluye pruebas unitarias para la construcción del grafo y el cálculo de rutas.

Las aristas se representan en una sola dirección (`origen -> destino`). Para
modelar una calle o conexión bidireccional, agrega también la arista inversa.
Los costos deben ser no negativos, como requiere Dijkstra, y todos los nodos
deben ser alcanzables desde el nodo inicial: la implementación actual no maneja
grafos desconectados. La aplicación web actual no ofrece un endpoint para enviar
grafos o consultar rutas; el algoritmo se utiliza desde las clases Java del
dominio.

## Requisitos

- Java 8
- Gradle instalado

El proyecto no incluye Gradle Wrapper, por lo que los comandos `gradle` requieren
una instalación local de Gradle.

## Ejecutar la aplicación

Desde la raíz del proyecto:

```bash
gradle bootRun
```

Cuando la aplicación haya iniciado, visita [http://localhost:8080/](http://localhost:8080/)
o ejecuta:

```bash
curl http://localhost:8080/
```

La respuesta actual es:

```text
Hola!
```

## Usar el algoritmo desde Java

Cada arista se entrega como una cadena con el formato
`origen::destino::costo`. Por ejemplo, este grafo tiene una ruta más económica
de `A` a `B` pasando por `C` (costo total 15, en lugar de 30):

```java
import com.dijkstra.domain.Dijkstra;
import com.dijkstra.domain.Graph;
import com.dijkstra.domain.Node;

import java.util.Arrays;
import java.util.List;

List<String> aristas = Arrays.asList(
    "A::B::30",
    "A::C::10",
    "C::B::5"
);

Graph grafo = new Graph(aristas);
Dijkstra dijkstra = new Dijkstra(grafo);
List<Node> nodosVisitados = dijkstra.shortestPath(new Node("A"));
```

El resultado contiene los nodos en el orden en que se visitaron. Cada nodo
incluye `getTotalCost()` para consultar su costo acumulado y
`getPreviousNode()` para seguir los nodos previos y reconstruir el camino.
El formato de arista requiere exactamente tres partes separadas por `::`.

## Ejecutar las pruebas

```bash
gradle test
```

Las pruebas existentes verifican la creación de nodos y aristas, y varios
ejemplos de cálculo de caminos mínimos.

## Tecnologías

- Java 8
- Spring Boot 1.5
- Gradle
