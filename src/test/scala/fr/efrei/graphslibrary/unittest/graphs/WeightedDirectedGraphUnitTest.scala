package fr.efrei.graphslibrary.unittest.graphs

import fr.efrei.graphslibrary.edges.WeightedDirectedEdge
import fr.efrei.graphslibrary.graphs.WeightedDirectedGraph
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class WeightedDirectedGraphUnitTest extends AnyFlatSpec with Matchers {

  "A WeightedDirectedGraph" should "add and remove edges correctly" in {
    val graph = new WeightedDirectedGraph(Set(1, 2, 3), Set.empty[WeightedDirectedEdge[Int]])
    val graphWithEdge = graph.addEdge(WeightedDirectedEdge(1, 2, 1.5))
    val graphWithAnotherEdge = graphWithEdge.addEdge(WeightedDirectedEdge(2, 3, 2.0))

    graphWithAnotherEdge.getAllVertices should contain allOf(1, 2, 3)
    graphWithAnotherEdge.getAllEdges should contain(WeightedDirectedEdge(1, 2, 1.5))
    graphWithAnotherEdge.getAllEdges should contain(WeightedDirectedEdge(2, 3, 2.0))

    val graphWithoutEdge = graphWithAnotherEdge.removeEdge(WeightedDirectedEdge(1, 2, 1.5))

    graphWithoutEdge.getAllEdges should not contain WeightedDirectedEdge(1, 2, 1.5)
  }

  it should "get all neighbors of a given vertex" in {
    val graph = new WeightedDirectedGraph(Set(1, 2, 3), Set(
      WeightedDirectedEdge(1, 2, 1.5),
      WeightedDirectedEdge(2, 3, 2.0)
    ))

    val neighborsOf1 = graph.neighbors(1)
    neighborsOf1 should contain only 2

    val neighborsOf2 = graph.neighbors(2)
    neighborsOf2 should contain only 3

    val neighborsOf3 = graph.neighbors(3)
    neighborsOf3 shouldBe empty
  }

  it should "get all vertices and all edges" in {
    val graph = new WeightedDirectedGraph(Set(1, 2, 3), Set(
      WeightedDirectedEdge(1, 2, 1.5),
      WeightedDirectedEdge(2, 3, 2.0)
    ))

    graph.getAllVertices should contain allOf(1, 2, 3)
    graph.getAllEdges should contain allOf(
      WeightedDirectedEdge(1, 2, 1.5),
      WeightedDirectedEdge(2, 3, 2.0)
    )
  }
}
