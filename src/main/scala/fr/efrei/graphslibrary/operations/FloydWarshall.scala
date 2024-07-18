package fr.efrei.graphslibrary.operations

import fr.efrei.graphslibrary.edges.{WeightedEdge, WeightedDirectedEdge, WeightedUndirectedEdge}
import fr.efrei.graphslibrary.graphs.{Graph, WeightedDirectedGraph, WeightedUndirectedGraph, DirectedGraph, UndirectedGraph}

object FloydWarshall {
  def apply[V](graph: Graph[V, _]): Map[(V, V), Double] = graph match {
    case g @ (_: WeightedDirectedGraph[V, _] | _: WeightedUndirectedGraph[V, _]) =>
      calculateDistances(g.vertices, g.edges.collect { case e: WeightedEdge[V] => e })
      
    case _ => Map.empty
  }

  private def calculateDistances[V](vertices: Set[V], edges: Set[WeightedEdge[V]]): Map[(V, V), Double] = {
    val dist = collection.mutable.Map((for {
      u <- vertices
      v <- vertices
    } yield (u, v) -> (if (u == v) 0.0 else Double.PositiveInfinity)).toSeq: _*)

    for (edge <- edges) {
      edge match {
        case e: WeightedUndirectedEdge[V] =>
          dist((e.node1, e.node2)) = e.weight
          dist((e.node2, e.node1)) = e.weight
        case e: WeightedDirectedEdge[V] =>
          dist((e.node1, e.node2)) = e.weight
      }
    }

    for (k <- vertices; i <- vertices; j <- vertices) {
      if (dist((i, j)) > dist((i, k)) + dist((k, j))) {
        dist((i, j)) = dist((i, k)) + dist((k, j))
      }
    }

    dist.toMap
  }
}

