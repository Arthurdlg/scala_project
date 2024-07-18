package fr.efrei.graphslibrary.utils

import fr.efrei.graphslibrary.graphs.Graph
import fr.efrei.graphslibrary.edges.Edge

object JsonSupport {
  def toJson[V, E <: Edge[V]](graph: Graph[V, E]): String = {
    val nodes = graph.getAllVertices.map(node => s"""{"id": "${node}"}""").mkString(",\n")
    val edges = graph.getAllEdges.map(edge => s"""{"from": "${edge.node1}", "to": "${edge.node2}"}""").mkString(",\n")
    
    s"""
       |{
       |  "nodes": [
       |    $nodes
       |  ],
       |  "edges": [
       |    $edges
       |  ]
       |}
       |""".stripMargin
  }
}
