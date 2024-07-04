package fr.efrei.graphslibrary.edges

case class UndirectedEdge[V](node1: V, node2: V) extends Edge[V]{
  override def toString: String = s"$node1 -- $node2"
}
