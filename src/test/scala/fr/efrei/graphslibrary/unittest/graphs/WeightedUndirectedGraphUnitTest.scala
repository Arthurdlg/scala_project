package fr.efrei.graphslibrary.unittest.graphs

import fr.efrei.graphslibrary.edges.WeightedUndirectedEdge
import fr.efrei.graphslibrary.graphs.WeightedUndirectedGraph
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class WeightedUndirectedGraphUnitTest extends AnyFlatSpec with Matchers {

  "A WeightedUndirectedGraph" should "add and remove edges correctly" in {
    val graph = new WeightedUndirectedGraph(Set(1, 2, 3), Set.empty[WeightedUndirectedEdge[Int]])
    val graphWithEdge = graph.addEdge(WeightedUndirectedEdge(1, 2, 0.5))
    val graphWithAnotherEdge = graphWithEdge.addEdge(WeightedUndirectedEdge(2, 3, 1.5))

    graphWithAnotherEdge.getAllVertices should contain allOf(1, 2, 3)
    graphWithAnotherEdge.getAllEdges should contain(WeightedUndirectedEdge(1, 2, 0.5))
    graphWithAnotherEdge.getAllEdges should contain(WeightedUndirectedEdge(2, 3, 1.5))

    val graphWithoutEdge = graphWithAnotherEdge.removeEdge(WeightedUndirectedEdge(1, 2, 0.5))

    graphWithoutEdge.getAllEdges should not contain WeightedUndirectedEdge(1, 2, 0.5)
  }

  it should "get all neighbors of a given vertex" in {
    val graph = new WeightedUndirectedGraph(Set(1, 2, 3), Set(WeightedUndirectedEdge(1, 2, 0.5), WeightedUndirectedEdge(2, 3, 1.5)))

    val neighborsOf1 = graph.neighbors(1)
    neighborsOf1 should contain only 2

    val neighborsOf2 = graph.neighbors(2)
    neighborsOf2 should contain allOf(1, 3)

    val neighborsOf3 = graph.neighbors(3)
    neighborsOf3 should contain only 2
  }

  it should "get all vertices and all edges" in {
    val graph = new WeightedUndirectedGraph(Set(1, 2, 3), Set(WeightedUndirectedEdge(1, 2, 0.5), WeightedUndirectedEdge(2, 3, 1.5)))

    graph.getAllVertices should contain allOf(1, 2, 3)
    graph.getAllEdges should contain allOf(WeightedUndirectedEdge(1, 2, 0.5), WeightedUndirectedEdge(2, 3, 1.5))
  }
}
