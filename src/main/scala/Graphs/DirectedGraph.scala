package Graphs

class DirectedGraph[V] extends Graph[V,  Edges.DirectedEdge[V]] {
  private var vertexSet: Set[V] = Set.empty
  private var edgeSet: Set[Edges.DirectedEdge[V]] = Set.empty

  def vertices: Set[V] = vertexSet
  def edges: Set[Edges.DirectedEdge[V]] = edgeSet

  def neighbors(vertex: V): Set[V] = Set.empty

  def addEdge(edge: Edges.DirectedEdge[V]): Unit = {}

  def removeEdge(edge: Edges.DirectedEdge[V]): Unit = {}
}
