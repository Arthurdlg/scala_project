package fr.efrei.graphslibrary.utils

import fr.efrei.graphslibrary.graphs.Graph
import fr.efrei.graphslibrary.edges.Edge

object GraphVizSupport {
  def toGraphViz[V, E <: Edge[V]](graph: Graph[V, E]): String = {
    val nodes = graph.getAllVertices.map(node => s"""  "$node";""").mkString("\n")
    val edges = graph.getAllEdges.map(edge => s"""  "${edge.node1}" -> "${edge.node2}";""").mkString("\n")
    
    s"""
       |digraph G {
       |$nodes
       |$edges
       |}
       |""".stripMargin
  }
}
