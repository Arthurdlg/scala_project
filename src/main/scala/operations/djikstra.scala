package operations


def dijkstra[V](graph: WeightedGraph[V], source: V, ): Map[V, Double] = {
  val dist = collection.mutable.Map[V, Double](source -> 0.0)
  val pq = collection.mutable.PriorityQueue[(V, Double)]((source, 0.0))(Ordering.by(-_._2))

  while (pq.nonEmpty) {
    val (u, _) = pq.dequeue()
    for ((_, v, w) <- graph.edges if graph.neighbors(u).contains(v)) {
      val alt = dist(u) + w
      if (alt < dist.getOrElse(v, Double.PositiveInfinity)) {
        dist(v) = alt
        pq.enqueue((v, alt))
      }
    }
  }
  dist.toMap
}

