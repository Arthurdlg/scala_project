package fr.efrei.graphslibrary.unittest.graphs

import fr.efrei.graphslibrary.edges.DirectedEdge
import fr.efrei.graphslibrary.graphs.DirectedGraph
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DirectedGraphUnitTest extends AnyFlatSpec with Matchers {

  "A DirectedGraph" should "add and remove edges correctly" in {
    val graph = new DirectedGraph(Set(1, 2, 3), Set.empty[DirectedEdge[Int]])
    val graphWithEdge = graph.addEdge(DirectedEdge(1, 2))
    val graphWithAnotherEdge = graphWithEdge.addEdge(DirectedEdge(2, 3))

    graphWithAnotherEdge.getAllVertices should contain allOf(1, 2, 3)
    graphWithAnotherEdge.getAllEdges should contain(DirectedEdge(1, 2))
    graphWithAnotherEdge.getAllEdges should contain(DirectedEdge(2, 3))

    val graphWithoutEdge = graphWithAnotherEdge.removeEdge(DirectedEdge(1, 2))

    graphWithoutEdge.getAllEdges should not contain DirectedEdge(1, 2)
  }

    it should "get all neighbors of a given vertex" in {
    val graph = new DirectedGraph(Set(1, 2, 3), Set(DirectedEdge(1, 2), DirectedEdge(2, 3)))

      val neighborsOf1 = graph.neighbors(1)
      neighborsOf1 should contain only 2

      val neighborsOf2 = graph.neighbors(2)
      neighborsOf2 should contain only 3

      val neighborsOf3 = graph.neighbors(3)
      neighborsOf3 shouldBe empty
  }

  it should "get all vertices and all edges" in {
    val graph = new DirectedGraph(Set(1, 2, 3), Set(DirectedEdge(1, 2), DirectedEdge(2, 3)))

    graph.getAllVertices should contain allOf(1, 2, 3)
    graph.getAllEdges should contain allOf(DirectedEdge(1, 2), DirectedEdge(2, 3))
  }
}
