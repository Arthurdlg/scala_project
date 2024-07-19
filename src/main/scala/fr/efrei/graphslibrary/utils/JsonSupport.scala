package fr.efrei.graphslibrary.utils

import zio.json._
import zio.json.*
import fr.efrei.graphslibrary.edges._
import fr.efrei.graphslibrary.graphs._

object JsonSupport {
  
  // Implicit JSON encoders and decoders for UndirectedEdge
  implicit def undirectedEdgeEncoder[V: JsonEncoder]: JsonEncoder[UndirectedEdge[V]] = DeriveJsonEncoder.gen[UndirectedEdge[V]]
  implicit def undirectedEdgeDecoder[V: JsonDecoder]: JsonDecoder[UndirectedEdge[V]] = DeriveJsonDecoder.gen[UndirectedEdge[V]]

  // Implicit JSON encoders and decoders for DirectedEdge
  implicit def directedEdgeEncoder[V: JsonEncoder]: JsonEncoder[DirectedEdge[V]] = DeriveJsonEncoder.gen[DirectedEdge[V]]
  implicit def directedEdgeDecoder[V: JsonDecoder]: JsonDecoder[DirectedEdge[V]] = DeriveJsonDecoder.gen[DirectedEdge[V]]

  // Implicit JSON encoders and decoders for WeightedDirectedEdge
  implicit def weightedDirectedEdgeEncoder[V: JsonEncoder]: JsonEncoder[WeightedDirectedEdge[V]] = DeriveJsonEncoder.gen[WeightedDirectedEdge[V]]
  implicit def weightedDirectedEdgeDecoder[V: JsonDecoder]: JsonDecoder[WeightedDirectedEdge[V]] = DeriveJsonDecoder.gen[WeightedDirectedEdge[V]]

  // Implicit JSON encoders and decoders for WeightedUndirectedEdge
  implicit def weightedUndirectedEdgeEncoder[V: JsonEncoder]: JsonEncoder[WeightedUndirectedEdge[V]] = DeriveJsonEncoder.gen[WeightedUndirectedEdge[V]]
  implicit def weightedUndirectedEdgeDecoder[V: JsonDecoder]: JsonDecoder[WeightedUndirectedEdge[V]] = DeriveJsonDecoder.gen[WeightedUndirectedEdge[V]]



}
