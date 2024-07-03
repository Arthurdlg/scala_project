package Edges

case class DirectedEdge[V](from: V, to: V) {
  override def toString: String = s"$from -> $to"
}
