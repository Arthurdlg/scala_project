package fr.efrei.graphslibrary.services

import fr.efrei.graphslibrary.operations.CycleDetection
import fr.efrei.graphslibrary.graphs.Graph
import zio._

object CycleDetectionService {
  def hasCycle[V: Ordering](graph: Graph[V, _]): UIO[Boolean] =
    UIO.succeed(CycleDetection(graph))
}
