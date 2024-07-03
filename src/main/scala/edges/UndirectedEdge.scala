package edges

case class UndirectedEdge[V](node1: V, node2: V) {
  override def toString: String = s"$node1 -> $node2"
}
