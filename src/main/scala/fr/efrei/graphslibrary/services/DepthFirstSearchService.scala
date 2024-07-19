package fr.efrei.graphslibrary.services

import fr.efrei.graphslibrary.operations.DepthFirstSearch
import fr.efrei.graphslibrary.graphs.Graph
import zio._

object DepthFirstSearchService {
  def dfs[V: Ordering](graph: Graph[V, _], start: V): UIO[List[V]] =
    UIO.succeed(DepthFirstSearch(graph, start))
}
