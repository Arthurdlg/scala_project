package fr.efrei.graphslibrary.edges

trait WeightedEdge[V] {
  def node1 : V
  def node2 : V
  def weight: Double
}
