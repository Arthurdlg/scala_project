package fr.efrei.graphslibrary.unittest.operations

import fr.efrei.graphslibrary.edges.{WeightedDirectedEdge, WeightedUndirectedEdge, DirectedEdge, UndirectedEdge}
import fr.efrei.graphslibrary.graphs.{WeightedDirectedGraph, WeightedUndirectedGraph, DirectedGraph, UndirectedGraph}
import fr.efrei.graphslibrary.operations.FloydWarshall
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FloydWarshallUnitTest extends AnyFlatSpec with Matchers {

  "FloydWarshall" should "calculate shortest paths correctly on WeightedDirectedGraph" in {
    val graph: WeightedDirectedGraph[Int, WeightedDirectedEdge[Int]] = new WeightedDirectedGraph(Set(1, 2, 3, 4, 5, 6), Set(
      WeightedDirectedEdge(1, 2, 1.5),
      WeightedDirectedEdge(2, 3, 1.0),
      WeightedDirectedEdge(3, 4, 2.0),
      WeightedDirectedEdge(1, 5, 2.5),
      WeightedDirectedEdge(5, 6, 0.5),
      WeightedDirectedEdge(6, 3, 1.5)
    ))

    val expected = Map(
      (1, 1) -> 0.0, (1, 2) -> 1.5, (1, 3) -> 2.5, (1, 4) -> 4.5, (1, 5) -> 2.5, (1, 6) -> 3.0,
      (2, 1) -> Double.PositiveInfinity, (2, 2) -> 0.0, (2, 3) -> 1.0, (2, 4) -> 3.0, (2, 5) -> Double.PositiveInfinity, (2, 6) -> Double.PositiveInfinity,
      (3, 1) -> Double.PositiveInfinity, (3, 2) -> Double.PositiveInfinity, (3, 3) -> 0.0, (3, 4) -> 2.0, (3, 5) -> Double.PositiveInfinity, (3, 6) -> Double.PositiveInfinity,
      (4, 1) -> Double.PositiveInfinity, (4, 2) -> Double.PositiveInfinity, (4, 3) -> Double.PositiveInfinity, (4, 4) -> 0.0, (4, 5) -> Double.PositiveInfinity, (4, 6) -> Double.PositiveInfinity,
      (5, 1) -> Double.PositiveInfinity, (5, 2) -> Double.PositiveInfinity, (5, 3) -> 2.0, (5, 4) -> 4.0, (5, 5) -> 0.0, (5, 6) -> 0.5,
      (6, 1) -> Double.PositiveInfinity, (6, 2) -> Double.PositiveInfinity, (6, 3) -> 1.5, (6, 4) -> 3.5, (6, 5) -> Double.PositiveInfinity, (6, 6) -> 0.0
    )

    val fwResult = FloydWarshall(graph)
    fwResult shouldEqual expected
  }

  "FloydWarshall" should "calculate shortest paths correctly on WeightedUndirectedGraph" in {
    val graph: WeightedUndirectedGraph[Int, WeightedUndirectedEdge[Int]] = new WeightedUndirectedGraph(Set(1, 2, 3, 4, 5), Set(
      WeightedUndirectedEdge(1, 2, 1.0),
      WeightedUndirectedEdge(2, 3, 2.0),
      WeightedUndirectedEdge(3, 4, 1.0),
      WeightedUndirectedEdge(4, 5, 3.0),
      WeightedUndirectedEdge(1, 5, 4.0)
    ))

    val expected = Map(
      (1, 1) -> 0.0, (1, 2) -> 1.0, (1, 3) -> 3.0, (1, 4) -> 4.0, (1, 5) -> 4.0,
      (2, 1) -> 1.0, (2, 2) -> 0.0, (2, 3) -> 2.0, (2, 4) -> 3.0, (2, 5) -> 5.0,
      (3, 1) -> 3.0, (3, 2) -> 2.0, (3, 3) -> 0.0, (3, 4) -> 1.0, (3, 5) -> 4.0,
      (4, 1) -> 4.0, (4, 2) -> 3.0, (4, 3) -> 1.0, (4, 4) -> 0.0, (4, 5) -> 3.0,
      (5, 1) -> 4.0, (5, 2) -> 5.0, (5, 3) -> 4.0, (5, 4) -> 3.0, (5, 5) -> 0.0
    )

    val fwResult = FloydWarshall(graph)
    fwResult shouldEqual expected
  }

//  "FloydWarshall" should "return empty map on unsupported graph types" in {
//    val directedGraph: DirectedGraph[Int, DirectedEdge[Int]] = new DirectedGraph(Set(1, 2, 3, 4), Set(
//      DirectedEdge(1, 2),
//      DirectedEdge(2, 3),
//      DirectedEdge(3, 4),
//      DirectedEdge(4, 1)
//    ))
//
//    val expectedDirected = Map.empty[(Any, Any), Double]
//    val fwResultDirected = FloydWarshall(directedGraph)
//    fwResultDirected shouldEqual expectedDirected
//
//    val undirectedGraph: UndirectedGraph[Int, UndirectedEdge[Int]] = new UndirectedGraph(Set(1, 2, 3, 4), Set(
//      UndirectedEdge(1, 2),
//      UndirectedEdge(2, 3),
//      UndirectedEdge(3, 4),
//      UndirectedEdge(4, 1)
//    ))
//    val expectedUndirected = Map.empty[(Int, Int), Double]
//    val fwResultUndirected = FloydWarshall(undirectedGraph)
//    fwResultUndirected shouldEqual expectedUndirected
//  }
}
