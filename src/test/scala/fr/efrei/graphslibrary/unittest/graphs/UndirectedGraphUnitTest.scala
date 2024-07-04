package fr.efrei.graphslibrary.unittest.graphs

import fr.efrei.graphslibrary.edges.UndirectedEdge
import fr.efrei.graphslibrary.graphs.UndirectedGraph
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UndirectedGraphUnitTest extends AnyFlatSpec with Matchers {

  "A UndirectedGraph" should "add and remove edges correctly" in {
    val graph = new UndirectedGraph(Set(1, 2, 3), Set.empty[UndirectedEdge[Int]])
    val graphWithEdge = graph.addEdge(UndirectedEdge(1, 2))
    val graphWithAnotherEdge = graphWithEdge.addEdge(UndirectedEdge(2, 3))

    graphWithAnotherEdge.getAllVertices should contain allOf(1, 2, 3)
    graphWithAnotherEdge.getAllEdges should contain(UndirectedEdge(1, 2))
    graphWithAnotherEdge.getAllEdges should contain(UndirectedEdge(2, 3))

    val graphWithoutEdge = graphWithAnotherEdge.removeEdge(UndirectedEdge(1, 2))

    graphWithoutEdge.getAllEdges should not contain UndirectedEdge(1, 2)
  }

  it should "get all neighbors of a given vertex" in {
    val graph = new UndirectedGraph(Set(1, 2, 3), Set(UndirectedEdge(1, 2), UndirectedEdge(2, 3)))

    val neighborsOf1 = graph.neighbors(1)
    neighborsOf1 should contain only 2

    val neighborsOf2 = graph.neighbors(2)
    neighborsOf2 should contain allOf(1, 3)

    val neighborsOf3 = graph.neighbors(3)
    neighborsOf3 should contain only 2
  }

  it should "get all vertices and all edges" in {
    val graph = new UndirectedGraph(Set(1, 2, 3), Set(UndirectedEdge(1, 2), UndirectedEdge(2, 3)))

    graph.getAllVertices should contain allOf(1, 2, 3)
    graph.getAllEdges should contain allOf(UndirectedEdge(1, 2), UndirectedEdge(2, 3))
  }
}
