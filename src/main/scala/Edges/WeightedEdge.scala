package Edges

case class WeightedEdge[V](from: V, to: V, weight: Double) {
  override def toString: String = s"$from -> $to"

}
