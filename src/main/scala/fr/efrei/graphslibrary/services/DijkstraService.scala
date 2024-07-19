package fr.efrei.graphslibrary.services

import fr.efrei.graphslibrary.operations.Dijkstra
import fr.efrei.graphslibrary.edges.WeightedEdge
import fr.efrei.graphslibrary.graphs.Graph
import zio._

object DijkstraService {
  def dijkstra[V](graph: Graph[V, WeightedEdge[V]], start: V): UIO[Map[V, Double]] =
    UIO.succeed(Dijkstra(graph, start))
}