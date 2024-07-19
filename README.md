

- **Project Overview**: Brief description of the project and its components.
- **Instructions**: How to build, test, and run the application.
- **Design Decisions**: Explanation of key design decisions, including state management and logging (if implemented).
- **Usage Examples**: Examples of how to use the application.
- **Testing**: How to run the tests and an overview of the test coverage.


---

# Functional Programming in Scala 3 - Functional Graphs

## Project Overview

This project is a comprehensive implementation of a graph data structure library, integrated into a ZIO 2 application. It covers various types of graphs, graph operations, and ensures functional programming principles are adhered to throughout. The library supports directed, undirected, and weighted graphs, along with common graph algorithms.

### Design Decisions
State Management
The application leverages the ZIO environment for state management, ensuring a purely functional approach. Graph states are managed immutably, with operations returning new instances rather than modifying existing ones.

### Testing
The project includes comprehensive unit tests covering graph creation, manipulation, and algorithms. To run the tests, use the sbt test command. The tests are written using ScalaTest and provide a wide coverage over the library's functionality.


## Instructions

### Building the Project

To build the project, ensure you have [sbt](https://www.scala-sbt.org/) installed. Then, run the following command in the root directory of the project:

```bash
sbt compile
```

### Testing the Project

To run the unit tests, execute:

```bash
sbt test
```

### Running the Application

To run the application, use:

```bash
sbt run
```



### Usage Examples

Creating a Graph

```scala
import fr.efrei.fpgraphs.Graph
import fr.efrei.fpgraphs.DirectedGraph

val graph: Graph[String] = DirectedGraph.empty[String]
```

Adding Vertices and Edges

```scala
val updatedGraph = graph.addEdge("Node1", "Node2")
```

