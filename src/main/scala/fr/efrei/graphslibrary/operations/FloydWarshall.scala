package fr.efrei.graphslibrary.operations

import fr.efrei.graphslibrary.edges.WeightedEdge
import fr.efrei.graphslibrary.graphs.{Graph, WeightedDirectedGraph, WeightedUndirectedGraph}

object FloydWarshall {
  def apply[V](graph: Graph[V, _ <: WeightedEdge[V]]): Map[(V, V), Double] = graph match {
    case _: WeightedDirectedGraph[V, _] | _: WeightedUndirectedGraph[V, _] =>
      val vertices = graph.vertices
      val dist = collection.mutable.Map((for {
        u <- vertices
        v <- vertices
      } yield (u, v) -> (if (u == v) 0.0 else Double.PositiveInfinity)).toSeq: _*)

      graph match {
        case _: WeightedUndirectedGraph[V, _] =>
          for (edge <- graph.edges) {
            dist((edge.node1, edge.node2)) = edge.weight
            dist((edge.node2, edge.node1)) = edge.weight
          }
        case _: WeightedDirectedGraph[V, _] =>
          for (edge <- graph.edges) {
            dist((edge.node1, edge.node2)) = edge.weight
          }
      }

      for (k <- vertices; i <- vertices; j <- vertices) {
        if (dist((i, j)) > dist((i, k)) + dist((k, j))) {
          dist((i, j)) = dist((i, k)) + dist((k, j))
        }
      }

      dist.toMap

    case _ => Map.empty[(V, V), Double]
  }
}
