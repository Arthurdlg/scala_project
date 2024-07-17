package fr.efrei.graphslibrary.operations

import fr.efrei.graphslibrary.graphs.Graph

object CycleDetection {
  def apply[V](graph: Graph[V, _])(implicit ordering: Ordering[V]): Boolean = {
    graph.vertices.exists { vertex =>
      println(s"Starting DFS for vertex: $vertex")
      val (_, _, cycleFound) = DFS_Base(graph, vertex, false)
      println(s"Cycle found starting from vertex $vertex: $cycleFound")
      cycleFound

    }
  }
}
