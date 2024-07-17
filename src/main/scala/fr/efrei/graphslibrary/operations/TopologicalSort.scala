package fr.efrei.graphslibrary.operations

import fr.efrei.graphslibrary.graphs.{DirectedGraph, Graph, WeightedDirectedGraph}

object TopologicalSort {
  def apply[V](graph: Graph[V, _])(implicit ordering: Ordering[V]): List[V] = graph match {
    case _: DirectedGraph[V, _] | _: WeightedDirectedGraph[V, _] =>
      val sortedList = graph.vertices.foldLeft((List[V](), Set[V]())) {
        case ((currentResult, currentVisited), vertex) =>
          val (vertexResult, vertexVisited, _) = DFS_Base(graph, vertex, true)
          (currentResult ++ vertexResult, currentVisited ++ vertexVisited)
      }
      val topologicalSort = sortedList._1.reverse.distinct.reverse
      topologicalSort
    case _ => List()
  }
}
