package graphs

class WeightedGraph[V] extends Graph[V,  edges.WeightedEdge[V]] {
  private var vertexSet: Set[V] = Set.empty
  private var edgeSet: Set[edges.WeightedEdge[V]] = Set.empty

  def vertices: Set[V] = vertexSet
  def edges: Set[edges.WeightedEdge[V]] = edgeSet

  def neighbors(vertex: V): Set[V] = Set.empty

  def addEdge(edge: edges.WeightedEdge[V]): Unit = Set.empty

  def removeEdge(edge: edges.WeightedEdge[V]): Unit = {
    edgeSet -= edge
  }
}
