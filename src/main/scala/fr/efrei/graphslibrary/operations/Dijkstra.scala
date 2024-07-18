package fr.efrei.graphslibrary.operations

import fr.efrei.graphslibrary.edges.WeightedEdge
import fr.efrei.graphslibrary.graphs.{Graph, WeightedDirectedGraph, WeightedUndirectedGraph}
import scala.collection.mutable

object Dijkstra {
  def apply[V](graph: Graph[V, _], start: V): Map[V, Double] = graph match {
    case g @ (_: WeightedDirectedGraph[V, _] | _: WeightedUndirectedGraph[V, _]) =>
      shortestPath(g.asInstanceOf[Graph[V, WeightedEdge[V]]], start, isDirected = g.isInstanceOf[WeightedDirectedGraph[V, _]])

    case _ => Map.empty
  }

  private def shortestPath[V](graph: Graph[V, WeightedEdge[V]], start: V, isDirected: Boolean): Map[V, Double] = {
    val distances = mutable.Map[V, Double](start -> 0.0).withDefaultValue(Double.PositiveInfinity)
    val visited = mutable.Set[V]()
    val pq = mutable.PriorityQueue[(V, Double)]()(Ordering.by(-_._2))

    pq.enqueue((start, 0.0))

    while (pq.nonEmpty) {
      val (current, currentDist) = pq.dequeue()

      if (!visited.contains(current)) {
        visited.add(current)

        for (edge <- graph.edges if edge.node1 == current) {
          relaxEdge(current, currentDist, edge.node2, edge.weight, distances, pq)
        }

        if (!isDirected) {
          for (edge <- graph.edges if edge.node2 == current) {
            relaxEdge(current, currentDist, edge.node1, edge.weight, distances, pq)
          }
        }
      }
    }
    println(distances)
    distances.toMap
  }

  private def relaxEdge[V](current: V, currentDist: Double, neighbor: V, weight: Double, distances: mutable.Map[V, Double], pq: mutable.PriorityQueue[(V, Double)]): Unit = {
    val newDist = currentDist + weight
    if (newDist < distances(neighbor)) {
      distances(neighbor) = newDist
      pq.enqueue((neighbor, newDist))
    }
  }
}
