package edges

case class DirectedEdge[V](node1: V, node2: V, weight: Double, from: V, to: V) extends Edge[V]{
  override def toString: String = s"$from -> $to"
}
