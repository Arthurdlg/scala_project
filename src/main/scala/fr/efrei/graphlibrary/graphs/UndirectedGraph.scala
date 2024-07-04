package fr.efrei.graphlibrary.graphs

import fr.efrei.graphlibrary.edges.UndirectedEdge

class UndirectedGraph[V] extends Graph[V,  UndirectedEdge[V]] {
  private var vertexSet: Set[V] = Set.empty
  private var edgeSet: Set[UndirectedEdge[V]] = Set.empty

  def vertices: Set[V] = vertexSet
  def edges: Set[UndirectedEdge[V]] = edgeSet

  def neighbors(vertex: V): Set[V] = Set.empty

  def addEdge(edge: UndirectedEdge[V]): Unit = Set.empty

  def removeEdge(edge: UndirectedEdge[V]): Unit = {
    edgeSet -= edge
  }
}
