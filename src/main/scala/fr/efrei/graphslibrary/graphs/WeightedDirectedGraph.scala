package fr.efrei.graphslibrary.graphs

import fr.efrei.graphslibrary.edges
import fr.efrei.graphslibrary.edges.WeightedDirectedEdge

class WeightedDirectedGraph[V, E <: WeightedDirectedEdge[V]](val vertices: Set[V], val edges: Set[E])  extends Graph[V, E] {

  // Method to Get all vertices
  def getAllVertices: Set[V] = vertices

  // Method to Get all edges
  def getAllEdges: Set[E] = edges

  // Method to Get neighbors of a given vertex
  def neighbors(vertex: V): Set[V] = edges.collect {
    case edge if edge.from == vertex => edge.to
  }
  
  // Method to Add an edge
  def addEdge(edge: E): WeightedDirectedGraph[V, E] = {
    new WeightedDirectedGraph(vertices + edge.from + edge.to, edges + edge)
  }

  // Method to Remove an edge
  def removeEdge(edge: E): WeightedDirectedGraph[V, E] = {
    new WeightedDirectedGraph(vertices, edges - edge)
  }

  override def toString: String = {
    s"Vertices: ${vertices.mkString(", ")}\nEdges: ${edges.mkString(", ")}"
  }
}
