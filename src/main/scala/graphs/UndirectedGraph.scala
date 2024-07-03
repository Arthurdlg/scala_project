package graphs

class UndirectedGraph[V] extends Graph[V,  edges.UndirectedEdge[V]] {
  private var vertexSet: Set[V] = Set.empty
  private var edgeSet: Set[edges.UndirectedEdge[V]] = Set.empty

  def vertices: Set[V] = vertexSet
  def edges: Set[edges.UndirectedEdge[V]] = edgeSet

  def neighbors(vertex: V): Set[V] = Set.empty

  def addEdge(edge: edges.UndirectedEdge[V]): Unit = Set.empty

  def removeEdge(edge: edges.UndirectedEdge[V]): Unit = {
    edgeSet -= edge
  }
}
