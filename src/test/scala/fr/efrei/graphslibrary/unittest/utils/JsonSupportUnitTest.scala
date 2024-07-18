package fr.efrei.graphslibrary.unittest.utils

import fr.efrei.graphslibrary.graphs.Graph
import fr.efrei.graphslibrary.edges.Edge
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class JsonSupportUnitTest extends AnyFlatSpec with Matchers {
  "JsonSupport" should "convert a graph to JSON" in {
    // Mock classes for testing
    case class TestEdge(node1: String, node2: String) extends Edge[String]
    case class TestGraph(vertices: Set[String], edges: Set[TestEdge]) extends Graph[String, TestEdge] {
      def getAllVertices: Set[String] = vertices
      def getAllEdges: Set[TestEdge] = edges
      def neighbors(vertex: String): Set[String] = Set()
      def addEdge(edge: TestEdge): Graph[String, TestEdge] = this
      def removeEdge(edge: TestEdge): Graph[String, TestEdge] = this
    }

    val graph = TestGraph(Set("A", "B"), Set(TestEdge("A", "B")))

    val json = JsonSupport.toJson(graph)

    json should include (""""nodes": [""")
    json should include (""""id": "A"""")
    json should include (""""id": "B"""")
    json should include (""""edges": [""")
    json should include (""""from": "A"""")
    json should include (""""to": "B"""")
  }
}
