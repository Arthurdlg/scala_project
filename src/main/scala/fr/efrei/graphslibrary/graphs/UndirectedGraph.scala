package fr.efrei.graphslibrary.graphs

import fr.efrei.graphslibrary.edges
import fr.efrei.graphslibrary.edges.UndirectedEdge

class UndirectedGraph[V, E <: UndirectedEdge[V]](val vertices: Set[V], val edges: Set[E])  extends Graph[V, E] {

  // Method to Get all vertices
  def getAllVertices: Set[V] = vertices

  // Method to Get all edges
  def getAllEdges: Set[E] = edges

  // Method to Get neighbors of a given vertex
  def neighbors(vertex: V): Set[V] = edges.collect {
    case edge if edge.node1 == vertex => edge.node2
    case edge if edge.node2 == vertex => edge.node1
  }

  // Method to Add an edge
  def addEdge(edge: E): UndirectedGraph[V, E] = {
    new UndirectedGraph(vertices, edges + edge)
  }

  // Method to Remove an edge
  def removeEdge(edge: E): UndirectedGraph[V, E] = {
    new UndirectedGraph(vertices + edge.node1 + edge.node2, edges - edge)
  }

  override def toString: String = {
    s"Vertices: ${vertices.mkString(", ")}\nEdges: ${edges.mkString(", ")}"
  }
}
