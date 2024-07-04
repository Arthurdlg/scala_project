package fr.efrei.graphlibrary.operations

def topologicalSort[V](graph: Graphs.Graph[V, _]): List[V] = {
  def visit(node: V, visited: Set[V], stack: List[V]): (Set[V], List[V]) = {
    if (visited.contains(node)) (visited, stack)
    else {
      val (newVisited, newStack) = graph.neighbors(node).foldLeft((visited, stack)) {
        case ((vis, st), neighbor) => visit(neighbor, vis, st)
      }
      (newVisited + node, node :: newStack)
    }
  }
  val (visited, stack) = graph.vertices.foldLeft((Set[V](), List[V]())) {
    case ((vis, st), node) => visit(node, vis, st)
  }
  stack.reverse
}
