package fr.efrei.graphslibrary.operations

import fr.efrei.graphslibrary.graphs.Graph

object BreadthFirstSearch {
  def apply[V](graph: Graph[V, _], start: V)(implicit ordering: Ordering[V]): List[V] = {

    def depthFirstSearchRecursive(v: V, visited: Set[V]): (List[V], Set[V]) = {
      if (visited.contains(v)) (List(), visited)
      else {
        val newVisited = visited + v
        val sortedNeighbors = graph.neighbors(v).toList.sorted.filterNot(newVisited.contains)
        val (neighborsResult, finalVisited) = sortedNeighbors.foldLeft((List(v), newVisited)) {
          case ((resultList, visitedSet), neighbor) =>
            val (neighborResult, neighborVisited) = depthFirstSearchRecursive(neighbor, visitedSet)
            (resultList ++ neighborResult, neighborVisited)
        }
        (neighborsResult, finalVisited)
      }
    }

    val (result, _) = depthFirstSearchRecursive(start, Set())
    result
  }
}
