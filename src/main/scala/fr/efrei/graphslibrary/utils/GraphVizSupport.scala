package fr.efrei.graphslibrary.utils

import fr.efrei.graphslibrary.graphs._
import fr.efrei.graphslibrary.edges._

object GraphVizSupport {

  implicit class GraphVizOps[V, E <: UndirectedEdge[V]](graph: UndirectedGraph[V, E]) {
    def toGraphViz: String = {
      val sb = new StringBuilder
      sb.append("graph G {\n")
      graph.edges.foreach { edge =>
        sb.append(s"  ${edge.node1} -- ${edge.node2};\n")
      }
      sb.append("}\n")
      sb.toString()
    }
  }

  implicit class DirectedGraphVizOps[V, E <: DirectedEdge[V]](graph: DirectedGraph[V, E]) {
    def toGraphViz: String = {
      val sb = new StringBuilder
      sb.append("digraph G {\n")
      graph.edges.foreach { edge =>
        sb.append(s"  ${edge.from} -> ${edge.to};\n")
      }
      sb.append("}\n")
      sb.toString()
    }
  }

  implicit class WeightedGraphVizOps[V, E <: WeightedUndirectedEdge[V]](graph: WeightedUndirectedGraph[V, E]) {
    def toGraphViz: String = {
      val sb = new StringBuilder
      sb.append("graph G {\n")
      graph.edges.foreach { edge =>
        sb.append(s"  ${edge.node1} -- ${edge.node2} [label=${edge.weight}];\n")
      }
      sb.append("}\n")
      sb.toString()
    }
  }

  implicit class WeightedDirectedGraphVizOps[V, E <: WeightedDirectedEdge[V]](graph: WeightedDirectedGraph[V, E]) {
    def toGraphViz: String = {
      val sb = new StringBuilder
      sb.append("digraph G {\n")
      graph.edges.foreach { edge =>
        sb.append(s"  ${edge.from} -> ${edge.to} [label=${edge.weight}];\n")
      }
      sb.append("}\n")
      sb.toString()
    }
  }
}
