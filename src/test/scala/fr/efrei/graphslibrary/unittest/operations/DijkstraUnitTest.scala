package fr.efrei.graphslibrary.unittest.operations

import fr.efrei.graphslibrary.edges.{DirectedEdge, UndirectedEdge, WeightedDirectedEdge, WeightedUndirectedEdge}
import fr.efrei.graphslibrary.graphs.{DirectedGraph, UndirectedGraph, WeightedDirectedGraph, WeightedUndirectedGraph}
import fr.efrei.graphslibrary.operations.Dijkstra
import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec


class DijkstraUnitTest extends AnyFlatSpec with Matchers {

  "Dijkstra's algorithm" should "find the shortest paths in a weighted directed graph" in {
    val graph = WeightedDirectedGraph(
      vertices = Set(1, 2, 3, 4),
      edges = Set(
        WeightedDirectedEdge(1, 2, 1.0),
        WeightedDirectedEdge(1, 3, 4.0),
        WeightedDirectedEdge(2, 3, 2.0),
        WeightedDirectedEdge(2, 4, 5.0),
        WeightedDirectedEdge(3, 4, 1.0)
      )
    )

    val distances = Dijkstra(graph, 1)
    distances(1) should be (0.0)
    distances(2) should be (1.0)
    distances(3) should be (3.0)
    distances(4) should be (4.0)
  }

  "Dijkstra's algorithm" should "find the shortest paths in a weighted undirected graph" in {
    val graph = WeightedUndirectedGraph(
      vertices = Set(1, 2, 3, 4, 5),
      edges = Set(
        WeightedUndirectedEdge(1, 2, 7.0),
        WeightedUndirectedEdge(5, 1, 1.0),
        WeightedUndirectedEdge(2, 3, 3.0),
        WeightedUndirectedEdge(2, 5, 8.0),
        WeightedUndirectedEdge(3, 4, 6.0),
        WeightedUndirectedEdge(3, 5, 2.0),
        WeightedUndirectedEdge(5, 4, 7.0)
      )
    )

    val distances = Dijkstra(graph, 1)
    distances(1) should be(0.0)
    distances(2) should be(6.0)
    distances(3) should be(3.0)
    distances(4) should be(8.0)
    distances(5) should be(1.0)
  }

  "FloydWarshall" should "return nil on unsupported graph types" in {
    val directedGraph: DirectedGraph[Int, DirectedEdge[Int]] = new DirectedGraph(Set(1, 2, 3, 4), Set(
      DirectedEdge(1, 2),
      DirectedEdge(2, 3),
      DirectedEdge(3, 4),
      DirectedEdge(4, 1)
    ))
    val fwResultDirected = Dijkstra(directedGraph, 1)
    fwResultDirected shouldEqual Map.empty

    val undirectedGraph: UndirectedGraph[Int, UndirectedEdge[Int]] = new UndirectedGraph(Set(1, 2, 3, 4), Set(
      UndirectedEdge(1, 2),
      UndirectedEdge(2, 3),
      UndirectedEdge(3, 4),
      UndirectedEdge(4, 1)
    ))
    val fwResultUndirected = Dijkstra(undirectedGraph, 4)
    fwResultUndirected shouldEqual Map.empty
  }
}
