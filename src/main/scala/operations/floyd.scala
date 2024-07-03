package operations

def floydWarshall[V](graph: Graphs.WeightedGraph[V]): Map[(V, V), Double] = {
  val vertices = graph.vertices
  val dist = collection.mutable.Map((for {
    u <- vertices
    v <- vertices
  } yield (u, v) -> (if (u == v) 0.0 else Double.PositiveInfinity)).toSeq: _*)

  for ((u, v, w) <- graph.edges) {
    dist((u, v)) = w
  }

  for (k <- vertices; i <- vertices; j <- vertices) {
    if (dist((i, j)) > dist((i, k)) + dist((k, j))) {
      dist((i, j)) = dist((i, k)) + dist((k, j))
    }
  }
  dist.toMap
}
