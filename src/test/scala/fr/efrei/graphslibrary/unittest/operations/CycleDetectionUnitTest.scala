package fr.efrei.graphslibrary.unittest.operations

import fr.efrei.graphslibrary.edges.{DirectedEdge, WeightedDirectedEdge}
import fr.efrei.graphslibrary.graphs.{DirectedGraph, WeightedDirectedGraph, Graph}
import fr.efrei.graphslibrary.operations.CycleDetection
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CycleDetectionUnitTest extends AnyFlatSpec with Matchers {

  "CycleDetection" should "detect cycles correctly in a DirectedGraph" in {
    val graph: Graph[Int, DirectedEdge[Int]] = new DirectedGraph(Set(1, 2, 3, 4, 5), Set(
      DirectedEdge(1, 2),
      DirectedEdge(2, 3),
      DirectedEdge(3, 4),
      DirectedEdge(4, 2),
      DirectedEdge(4, 5)
    ))
    graph.neighbors(4) should contain only (2,5)
    CycleDetection.apply(graph) shouldEqual true
  }

  "CycleDetection" should "detect no cycles in a DirectedGraph" in {
    val graph: Graph[Int, DirectedEdge[Int]] = new DirectedGraph(Set(1, 2, 3, 4, 5), Set(
      DirectedEdge(1, 2),
      DirectedEdge(2, 3),
      DirectedEdge(2, 5),
      DirectedEdge(3, 4),
      DirectedEdge(4, 5)
    ))
    CycleDetection.apply(graph) shouldEqual false
  }

  "CycleDetection" should "detect cycles correctly in a WeightedDirectedGraph" in {
    val graph: Graph[Int, WeightedDirectedEdge[Int]] = new WeightedDirectedGraph(Set(1, 2, 3, 4, 5), Set(
      WeightedDirectedEdge(1, 2, 1.0),
      WeightedDirectedEdge(2, 3, 2.0),
      WeightedDirectedEdge(3, 4, 3.0),
      WeightedDirectedEdge(4, 2, 4.0),
      WeightedDirectedEdge(4, 5, 5.0)
    ))
    CycleDetection.apply(graph) shouldEqual true
  }

  "CycleDetection" should "detect no cycles in a WeightedDirectedGraph" in {
    val graph: Graph[Int, WeightedDirectedEdge[Int]] = new WeightedDirectedGraph(Set(1, 2, 3, 4, 5), Set(
      WeightedDirectedEdge(1, 2, 1.0),
      WeightedDirectedEdge(2, 3, 2.0),
      WeightedDirectedEdge(3, 4, 3.0),
      WeightedDirectedEdge(4, 5, 4.0)
    ))
    CycleDetection.apply(graph) shouldEqual false
  }
}
