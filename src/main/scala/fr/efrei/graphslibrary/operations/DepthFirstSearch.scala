package fr.efrei.graphslibrary.operations

import fr.efrei.graphslibrary.graphs.Graph

object DepthFirstSearch {
  def apply[V](graph: Graph[V, _], start: V)(implicit ordering: Ordering[V]): List[V] = {
    val (result, _, _) = DFS_Base.apply(graph, start, true)
    result
  }
}
