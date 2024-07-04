package fr.efrei.graphslibrary.graphs

import fr.efrei.graphslibrary.edges
import fr.efrei.graphslibrary.edges.DirectedEdge

class DirectedGraph[V, E <: DirectedEdge[V]](val vertices: Set[V], val edges: Set[E]) {

  // Method to Get all vertices
  def getAllVertices: Set[V] = vertices

  // Method to Get all edges
  def getAllEdges: Set[E] = edges

  // Method to Get incoming neighbors of a given vertex
  def incomingNeighbors(vertex: V): Set[V] = edges.collect{
    case edge if edge.to == vertex => edge.from
  }

  // Method to Get outgoing neighbors of a given vertex
  def outgoingNeighbors(vertex: V): Set[V] = edges.collect {
    case edge if edge.from == vertex => edge.to
  }

  // Method to Get neighbors of a given vertex
  def neighbors(vertex: V): Set[V] = outgoingNeighbors(vertex) ++ incomingNeighbors(vertex)

  // Method to Add an edge
  def addEdge(edge: E): DirectedGraph[V, E] = {
    new DirectedGraph(vertices, edges + edge)
  }

  // Method to Remove an edge
  def removeEdge(edge: E): DirectedGraph[V, E] = {
    new DirectedGraph(vertices, edges - edge)
  }

  override def toString: String = {
    s"Vertices: ${vertices.mkString(", ")}\nEdges: ${edges.mkString(", ")}"
  }
}

//object DirectedGraph {
//  def empty[V, E <: DirectedEdge[V]]: DirectedGraph[V, E] = new DirectedGraph[V, E](Set.empty, Set.empty)
//}
