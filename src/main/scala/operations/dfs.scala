package operations

def dfs[V](graph: Graphs.Graph[V, _], start: V): List[V] = {
  def dfsRecursive(v: V, visited: Set[V]): List[V] = {
    if (visited.contains(v)) List()
    else v :: graph.neighbors(v).toList.flatMap(dfsRecursive(_, visited + v))
  }
  dfsRecursive(start, Set())
}
