package fr.efrei.graphslibrary.graphs

trait Graph[V, E]{
  def vertices: Set[V]
  def edges: Set[E]
  def getAllVertices: Set[V]
  def getAllEdges: Set[E]
  def neighbors(vertex: V): Set[V]
  def addEdge(edge: E): Graph[V, E]
  def removeEdge(edge: E): Graph[V, E]
}
