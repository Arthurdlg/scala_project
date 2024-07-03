package Graphs

class UndirectedGraph[V] extends Graph[V,  Edges.UndirectedEdge[V]] {
  private var vertexSet: Set[V] = Set.empty
  private var edgeSet: Set[Edges.UndirectedEdge[V]] = Set.empty

  def vertices: Set[V] = vertexSet
  def edges: Set[Edges.UndirectedEdge[V]] = edgeSet

  def neighbors(vertex: V): Set[V] = Set.empty

  def addEdge(edge: Edges.UndirectedEdge[V]): Unit = Set.empty

  def removeEdge(edge: Edges.UndirectedEdge[V]): Unit = Set.empty
}
