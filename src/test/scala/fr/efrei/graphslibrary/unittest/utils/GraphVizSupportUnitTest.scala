package fr.efrei.graphslibrary.utils

import fr.efrei.graphslibrary.graphs._
import fr.efrei.graphslibrary.edges._
import fr.efrei.graphslibrary.utils.GraphVizSupport.{GraphVizOps, DirectedGraphVizOps, WeightedGraphVizOps, WeightedDirectedGraphVizOps}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GraphVizSupportTest extends AnyFlatSpec with Matchers {

  "GraphVizSupport" should "generate correct GraphViz for UndirectedGraph" in {
    val graph: UndirectedGraph[Int, UndirectedEdge[Int]] = new UndirectedGraph(Set(1, 2, 3, 4, 5), Set(
      UndirectedEdge(1, 4),
      UndirectedEdge(4, 2),
      UndirectedEdge(5, 4),
      UndirectedEdge(5, 2),
      UndirectedEdge(3, 5)))

    val graphViz = graph.toGraphViz
    val expected = "graph G {\n  A -- B;\n}\n"
    graphViz shouldBe expected
  }

  it should "generate correct GraphViz for DirectedGraph" in {
    val graph: DirectedGraph[Int, DirectedEdge[Int]] = new DirectedGraph(Set(1, 2, 3, 4), Set(DirectedEdge(1, 2),
      DirectedEdge(1, 3),
      DirectedEdge(2, 3),
      DirectedEdge(3, 1),
      DirectedEdge(3, 4),
      DirectedEdge(4, 4)))

    val graphViz = graph.toGraphViz
    val expected = "digraph G {\n  A -> B;\n}\n"
    graphViz shouldBe expected
  }

  it should "generate correct GraphViz for WeightedUndirectedGraph" in {
    val graph: WeightedUndirectedGraph[Int, WeightedUndirectedEdge[Int]] = new WeightedUndirectedGraph(Set(0, 2, 3, 4), Set(
      WeightedUndirectedEdge(0, 1, 1.5),
      WeightedUndirectedEdge(0, 2, 3.0),
      WeightedUndirectedEdge(0, 3, 0.5),
      WeightedUndirectedEdge(1, 2, 8.0),
      WeightedUndirectedEdge(2, 4, 2.5)))

    val graphViz = graph.toGraphViz
    val expected = "graph G {\n  A -- B [label=2.5];\n}\n"
    graphViz shouldBe expected
  }

  it should "generate correct GraphViz for WeightedDirectedGraph" in {
    val graph: WeightedDirectedGraph[Int, WeightedDirectedEdge[Int]] = new WeightedDirectedGraph(Set(1, 2, 3, 4, 5, 6, 7), Set(
      WeightedDirectedEdge(1, 2, 1.5),
      WeightedDirectedEdge(2, 4, 3.0),
      WeightedDirectedEdge(2, 5, 0.5),
      WeightedDirectedEdge(4, 6, 8.0),
      WeightedDirectedEdge(4, 7, 2.5),
      WeightedDirectedEdge(1, 3, 5.0)))

    val graphViz = graph.toGraphViz
    val expected = "digraph G {\n  A -> B [label=2.5];\n}\n"
    graphViz shouldBe expected
  }
}