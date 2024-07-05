package fr.efrei.graphslibrary.operations

import fr.efrei.graphslibrary.graphs.Graph

import scala.annotation.tailrec
import scala.collection.immutable.Queue

object BreadthFirstSearch {
  def apply[V](graph: Graph[V, _], start: V)(implicit ordering: Ordering[V]): List[V] = {
    @tailrec
    def BFSRecursive(queue: Queue[V], visited: Set[V], result: List[V]): List[V] = {
      if (queue.isEmpty) result
      else {
        val (vertex, rest) = queue.dequeue
        if (visited.contains(vertex)) BFSRecursive(rest, visited, result)
        else {
          val newVisited = visited + vertex
          val neighbors = graph.neighbors(vertex).toList.sorted.filterNot(newVisited.contains)
          BFSRecursive(rest.enqueue(neighbors), newVisited, result :+ vertex)
        }
      }
    }

    BFSRecursive(Queue(start), Set(), List())
  }
}
