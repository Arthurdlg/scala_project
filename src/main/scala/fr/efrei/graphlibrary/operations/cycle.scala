package fr.efrei.graphlibrary.operations

def hasCycle[V](graph: Graphs.Graph[V, _]): Boolean = {
  def visit(node: V, visited: Set[V], recStack: Set[V]): Boolean = {
    if (recStack.contains(node)) true
    else if (visited.contains(node)) false
    else {
      val newVisited = visited + node
      val newRecStack = recStack + node
      graph.neighbors(node).exists(visit(_, newVisited, newRecStack))
    }
  }
  graph.vertices.exists(visit(_, Set(), Set()))
}
