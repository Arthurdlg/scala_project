package fr.efrei.graphslibrary.services

import fr.efrei.graphslibrary.operations.BreadthFirstSearch
import fr.efrei.graphslibrary.graphs.Graph
import zio._

object BreadthFirstSearchService {
  def bfs[V: Ordering](graph: Graph[V, _], start: V): UIO[List[V]] =
    UIO.succeed(BreadthFirstSearch(graph, start))
}
