package operations

def bfs[V](graph: Graphs.Graph[V, _], start: V): List[V] = {
  @annotation.tailrec
  def bfsRecursive(queue: List[V], visited: Set[V], result: List[V]): List[V] = queue match {
    case Nil => result
    case v :: rest =>
      if (visited.contains(v)) bfsRecursive(rest, visited, result)
      else bfsRecursive(rest ++ graph.neighbors(v), visited + v, result :+ v)
  }
  bfsRecursive(List(start), Set(), List())
}
