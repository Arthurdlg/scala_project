package fr.efrei.graphslibrary.edges

case class WeightedUndirectedEdge[V](node1: V, node2: V, weight: Double) extends Edge[V] with Weight{
  override def toString: String = s"$node1 ($weight)-- $node2"
}
