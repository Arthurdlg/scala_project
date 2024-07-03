package Edges

case class UndirectedEdge[V](v1: V, v2: V) {
  override def toString: String = s"$v1 -> $v2"
}
