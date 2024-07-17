package fr.efrei.graphslibrary.operations

import fr.efrei.graphslibrary.graphs.Graph

object DFS_Base {
  def apply[V](graph: Graph[V, _], start: V, filterVisited: Boolean)(implicit ordering: Ordering[V]): (List[V], Set[V], Boolean) = {

    def DFSRecursive(v: V, visited: Set[V], recStack: Set[V], result: List[V]): (List[V], Set[V], Boolean) = {
      if (recStack.contains(v)) {
        (result, visited, true) // Cycle detected
      } 
      else if (visited.contains(v)) {
        (result, visited, false)
      } 
      else {
        val newVisited = visited + v
        val newRecStack = recStack + v
        val neighbors = graph.neighbors(v).toList.sorted
        val sortedNeighbors = if (filterVisited) neighbors.filterNot(newVisited.contains) else neighbors 
        val (finalResult, finalVisited, cycleDetected) = sortedNeighbors.foldLeft((result :+ v, newVisited, false)) {
          case ((currentResult, currentVisited, cycle), neighbor) =>
            if (cycle) (currentResult, currentVisited, cycle)
            else {
              val (neighborResult, neighborVisited, neighborCycle) = DFSRecursive(neighbor, currentVisited, newRecStack, currentResult)
              (neighborResult, neighborVisited, neighborCycle)
            }
        }
        (finalResult, finalVisited, cycleDetected)
      }
    }

    DFSRecursive(start, Set(), Set(), List())
  }
}
