# Functional Programming in Scala 3 - Functional Graphs

Welcome to the final project for your Functional Programming in Scala 3 class. This project is designed to assess your
understanding and application of functional programming principles. The grading will be based on the proper behavior of
the implementation, adherence to functional programming principles, test coverage, project organization, and the quality
and completeness of the documentation.

**Project Deadline: Friday, 19 July**

## Project Overview

You will design and implement a graph data structure library with various operations, integrate it into a ZIO 2
application, and document your work comprehensively. The project will involve the following key components:

1. **Graph Data Structure**
2. **Graph Operations**
3. **ZIO 2 Application Integration**
4. **Comprehensive Documentation**

## Detailed Instructions

### 1. Graph Data Structure

#### Testing

Ensure all the implemented data structures and operations implemented below work as expected by writing unit tests.

- **Task**: Implement unit tests to ensure the correctness of the above implementations.
- **Hint**: Use ScalaTest [FlatSpec](https://www.scalatest.org/user_guide/selecting_a_style) style for writing unit tests.

#### Data Structure Design

A [graph](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/) is a collection of vertices (nodes) and edges (connections between nodes). A graph can be directed (edges have a
direction) or undirected (edges have no direction), and can have weights (values) associated with edges.

- **Task**: Design an interface to represent a graph, parameterized by type.
- **Examples of Methods to Implement**:
    - Get all vertices
    - Get all edges
    - Get neighbors of a given vertex
    - Add an edge
    - Remove an edge

#### Implementations

Different types of graphs include:

- **Directed Graph (Digraph)**: Edges have a direction, going from one vertex to another.
- **Undirected Graph**: Edges have no direction, connecting two vertices bidirectionally.
- **Weighted Graph**: Edges have weights, representing the cost or distance between vertices.


- **Task**: Implement the interface for the following types of graphs:
    - Directed Graph (Digraph)
    - Undirected Graph
    - Weighted Graph

#### JSON Encoding/Decoding

JSON (JavaScript Object Notation) is a lightweight data interchange format. Encoding and decoding involve converting
between graph objects and their JSON representations.

- **Task**: Implement a way to encode and decode graphs from and to JSON.
- **Hint**: Use the `zio-json` library for JSON handling.

#### GraphViz Representation

[GraphViz](https://graphviz.org) is a tool for visualizing graphs. Generating a GraphViz representation involves
creating a textual description of the graph in the DOT language.

- **Task**: Implement a way to generate a GraphViz representation of a graph.
- **Hint**: Use implicit extensions and consider the `foldLeft` method in the Scala collections standard library.

### 2. Graph Operations

#### Depth First Search (DFS)

DFS is an algorithm for traversing or searching tree or graph data structures. It starts at a source vertex and explores
as far as possible along each branch before backtracking.

- **Task**: Implement and test DFS.

#### Breadth First Search (BFS)

BFS is an algorithm for traversing or searching tree or graph data structures. It starts at a source vertex and explores
all the neighbor vertices at the present depth before moving on to vertices at the next depth level.

- **Task**: Implement and test BFS.

#### Topological Sorting

Topological sorting is the linear ordering of vertices in a directed graph where for every directed edge from vertex u
to vertex v, u comes before v in the ordering.

- **Task**: Use DFS to implement and test topological sorting.

#### Cycle Detection

Cycle detection in a graph is the process of finding a cycle (a path of edges and vertices wherein a vertex is reachable
from itself).

- **Task**: Use DFS to detect cycles in a graph.

#### Floyd's Algorithm

Floyd’s algorithm, also known as the Floyd-Warshall algorithm, is used for finding the shortest paths between all pairs
of vertices in a weighted graph.

- **Task**: Implement and test Floyd's algorithm for shortest paths.

#### Dijkstra's Algorithm

Dijkstra’s algorithm is used for finding the shortest path from a single source vertex to all other vertices in a
weighted graph with non-negative weights.

- **Task**: Implement and test Dijkstra's algorithm for shortest paths.

### 3. ZIO 2 Application Integration

#### Application Design

[ZIO](https://zio.dev/guides/) is a library for asynchronous and concurrent programming in Scala. It simplifies handling side-effects in functional
programming.

- **Task**: Integrate the core library and operations into a ZIO 2 application.
- **Options**:
    - Build a terminal-based interactive application.
    - Build an API-based application.

#### State Management

State management involves maintaining and manipulating state (data) throughout the lifecycle of an application.

- **Task**: Choose an appropriate way to maintain state within your application.
- **Documentation**: Explain your implementation choice in the README, discussing the consequences and options for a
  more complex application.

### 4. Optional Feature

#### Logging

Logging is the process of recording information about a program's execution, useful for debugging and monitoring.

- **Task**: Add logging support to the implemented operations.
- **Requirement**: Ensure logging is implemented in a functional way, preserving expected characteristics.
- **Documentation**: Discuss your logging implementation in the README.

## Project Organization

- **Use `sbt` subprojects**: Separate the core library from the ZIO application using [subprojects](https://www.scala-sbt.org/1.x/docs/Multi-Project.html#Build-wide+settings).
- **Scala Worksheets**: Use Scala worksheets in addition to unit tests to experiment and validate implementations.
- **Version Control**: Use Git for version control throughout the project. Regularly commit your changes and use
  meaningful commit messages.

## Documentation

### README Requirements

Your README should be comprehensive and include:

- **Project Overview**: Brief description of the project and its components.
- **Instructions**: How to build, test, and run the application.
- **Design Decisions**: Explanation of key design decisions, including state management and logging (if implemented).
- **Usage Examples**: Examples of how to use the application.
- **Testing**: How to run the tests and an overview of the test coverage.

## Grading Criteria

- **Implementation Behavior**: Correct and expected functionality of the implemented features.
- **Functional Programming Principles**: Adherence to functional programming paradigms.
- **Test Coverage**: Comprehensive unit tests covering all implemented features.
- **Project Organization**: Clear and logical project structure.
- **README Quality**: Completeness and clarity of the documentation.

**Project Deadline: Friday, 19 July**

Good luck with your project! If you have any questions, please don't hesitate to ask.