package fr.efrei.graphslibrary.operations

import fr.efrei.graphslibrary.graphs.Graph

object CycleDetection {
//  def apply[V](graph: Graph[V, _]): Boolean = {
//
//    val simplifiedGraph = graph.mapVertices(_ => ())
//    def visit(node: V, visited: Set[V], recStack: Set[V]): Boolean = {
//      if (recStack.contains(node)) true
//      else if (visited.contains(node)) false
//      else {
//        val newVisited = visited + node
//        val newRecStack = recStack + node
//        graph.neighbors(node).exists(visit(_, newVisited, newRecStack))
//      }
//    }
//    graph.vertices.exists(visit(_, Set(), Set()))
//  }

}
