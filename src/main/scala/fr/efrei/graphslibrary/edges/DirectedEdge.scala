package fr.efrei.graphslibrary.edges

case class DirectedEdge[V](from: V, to: V) extends Edge[V]{
  override def node1: V = from
  override def node2: V = to
  override def toString: String = s"$from -> $to"
}
