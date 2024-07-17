package fr.efrei.graphslibrary.unittest.operations

import fr.efrei.graphslibrary.edges.{DirectedEdge, WeightedDirectedEdge, UndirectedEdge, WeightedUndirectedEdge}
import fr.efrei.graphslibrary.graphs.{DirectedGraph, WeightedDirectedGraph, UndirectedGraph, WeightedUndirectedGraph}
import fr.efrei.graphslibrary.operations.TopologicalSort
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TopologicalSortUnitTest extends AnyFlatSpec with Matchers {

  "Topological Sort" should "sort vertices correctly in a DirectedGraph" in {
    val graph: DirectedGraph[Int, DirectedEdge[Int]] = new DirectedGraph(Set(1, 2, 3, 4, 5, 6), Set(
      DirectedEdge(6, 2),
      DirectedEdge(6, 3),
      DirectedEdge(2, 4),
      DirectedEdge(3, 4),
      DirectedEdge(2, 5),
      DirectedEdge(3, 1),
      DirectedEdge(4, 5),
      DirectedEdge(4, 1)
    ))

    val expectedOrders = Set(
      List(6, 2, 3, 4, 5, 1),
      List(6, 2, 3, 4, 1, 5),
      List(6, 3, 2, 4, 5, 1),
      List(6, 3, 2, 4, 1, 5)
    )

    val sortedResult = TopologicalSort(graph)

    expectedOrders should contain(sortedResult)
  }

  "Topological Sort" should "sort vertices correctly in a WeightedDirectedGraph" in {
    val graph: WeightedDirectedGraph[Int, WeightedDirectedEdge[Int]] = new WeightedDirectedGraph(Set(1, 2, 3, 4, 5, 6), Set(
      WeightedDirectedEdge(1, 2, 1.0),
      WeightedDirectedEdge(2, 3, 1.5),
      WeightedDirectedEdge(3, 4, 2.0),
      WeightedDirectedEdge(1, 5, 0.5),
      WeightedDirectedEdge(5, 6, 2.5)
    ))

    val expectedOrders = Set(
      List(1, 2, 3, 4, 5, 6),
      List(1, 2, 3, 4, 6, 5),
      List(1, 2, 5, 3, 4, 6),
      List(1, 2, 5, 3, 6, 4),
      List(1, 5, 2, 3, 4, 6),
      List(1, 5, 2, 3, 6, 4),
      List(1, 5, 6, 2, 3, 4)
    )

    val sortedResult = TopologicalSort(graph)

    expectedOrders should contain(sortedResult)
  }

  "Topological Sort" should "return an empty list for an UndirectedGraph" in {
    val graph: UndirectedGraph[Int, UndirectedEdge[Int]] = new UndirectedGraph(Set(1, 2, 3, 4), Set(
      UndirectedEdge(1, 2),
      UndirectedEdge(2, 3),
      UndirectedEdge(3, 4),
      UndirectedEdge(4, 1)
    ))

    val sortedResult = TopologicalSort(graph)

    sortedResult shouldBe List()
  }

  "Topological Sort" should "return an empty list for an WeightedDirectedGraph" in {
    val graph: WeightedUndirectedGraph[Int, WeightedUndirectedEdge[Int]] = new WeightedUndirectedGraph(Set(1, 2, 3, 4), Set(
      WeightedUndirectedEdge(1, 2, 5.0),
      WeightedUndirectedEdge(2, 3, 1.0),
      WeightedUndirectedEdge(3, 4, 2.5),
      WeightedUndirectedEdge(4, 1, 9.0)
    ))

    val sortedResult = TopologicalSort(graph)

    sortedResult shouldBe List()
  }
}
