package fr.efrei.graphslibrary.services

import fr.efrei.graphslibrary.operations.FloydWarshall
import fr.efrei.graphslibrary.edges.WeightedEdge
import fr.efrei.graphslibrary.graphs.Graph
import zio._

object FloydWarshallService {
  def floydWarshall[V](graph: Graph[V, WeightedEdge[V]]): UIO[Map[(V, V), Double]] =
    UIO.succeed(FloydWarshall(graph))
}