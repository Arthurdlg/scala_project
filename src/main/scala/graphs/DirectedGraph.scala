package graphs

class DirectedGraph[V](
                        val graphVertices: Set[V], 
                        val graphEdges: Set[edges.DirectedEdge[V]],
                        val isWeighted: Boolean
                      ) extends Graph[V, edges.DirectedEdge[V]] {

  def neighbors(vertex: V): Set[V] = edges.collect { case edge if edge.from == vertex => edge.to }

  def addEdge(edge: edges.DirectedEdge[V]): DirectedGraph[V] = {
    new DirectedGraph(vertices + edge.from + edge.to, edges + edge)
  }

  def removeEdge(edge: edges.DirectedEdge[V]): DirectedGraph[V] = {
    new DirectedGraph(vertices, edges - edge)
  }
}
