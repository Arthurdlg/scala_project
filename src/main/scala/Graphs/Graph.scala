package Graphs

trait Graph[V, E]{
  // concrete methods
  def vertices: Set[V]
  def edges: Set[E]
  def neighbors(vertex: V): Set[V]
  
  // abstract methods
  def addEdge(edge: E): Unit
  def removeEdge(edge: E): Unit
}
