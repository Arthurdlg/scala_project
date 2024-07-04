package fr.efrei.graphlibrary.graphs

import fr.efrei.graphlibrary.edges.WeightedEdge

class WeightedUndirectedGraph[V] extends Graph[V,  WeightedEdge[V]] {
  private var vertexSet: Set[V] = Set.empty
  private var edgeSet: Set[WeightedEdge[V]] = Set.empty

  def vertices: Set[V] = vertexSet
  def edges: Set[WeightedEdge[V]] = edgeSet

  def neighbors(vertex: V): Set[V] = Set.empty

  def addEdge(edge: WeightedEdge[V]): Unit = Set.empty

  def removeEdge(edge: WeightedEdge[V]): Unit = {
    edgeSet -= edge
  }
}
