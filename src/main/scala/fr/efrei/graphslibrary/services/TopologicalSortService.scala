package fr.efrei.graphslibrary.services

import fr.efrei.graphslibrary.operations.TopologicalSort
import fr.efrei.graphslibrary.graphs.Graph
import zio._

object TopologicalSortService {
  def topologicalSort[V: Ordering](graph: Graph[V, _]): UIO[List[V]] =
    UIO.succeed(TopologicalSort(graph))
}