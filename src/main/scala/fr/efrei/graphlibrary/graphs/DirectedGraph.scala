package fr.efrei.graphlibrary.graphs

import fr.efrei.graphlibrary.edges.DirectedEdge

class DirectedGraph[V](val graphVertices: Set[V], val graphEdges: Set[DirectedEdge[V]]) extends Graph[V, DirectedEdge[V]] {

  def neighbors(vertex: V): Set[V] = edges.collect { 
    case edge if edge.from == vertex => edge.to
  }

  def addEdge(edge: DirectedEdge[V]): DirectedGraph[V] = {
    new DirectedGraph(vertices + edge.from + edge.to, edges + edge)
  }

  def removeEdge(edge: DirectedEdge[V]): DirectedGraph[V] = {
    new DirectedGraph(vertices, edges - edge)
  }
}
