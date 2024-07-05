package fr.efrei.graphslibrary.operations

import fr.efrei.graphslibrary.graphs.Graph
import fr.efrei.graphslibrary.operations.DepthFirstSearch

object TopologicalSort{
//  def apply[V](graph: Graph[V, _])(implicit ordering: Ordering[V]): List[V] = {
//    val (_, stack) = graph.vertices.foldLeft((Set[V](), List[V]) {
//      case ((visitedAcc, stackAcc), vertex) =>
//        if (!visitedAcc.contains(vertex)) {
//          val (visitedAfterDFS, stackAfterDFS) = DepthFirstSearch.apply(graph, vertex)
//          (visitedAfterDFS, stackAfterDFS)
//        } else {
//          (visitedAcc, stackAcc)
//        }
//    }
//
//    stack.reverse

}
