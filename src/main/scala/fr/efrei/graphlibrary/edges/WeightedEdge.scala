package fr.efrei.graphlibrary.edges

case class WeightedEdge[V](from: V, to: V, weight: Double) {
  override def toString: String = s"$from -> $to"

}
// a unifier edges