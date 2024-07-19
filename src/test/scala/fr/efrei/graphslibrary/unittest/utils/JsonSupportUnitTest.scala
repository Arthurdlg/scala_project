package fr.efrei.graphslibrary.utils

import fr.efrei.graphslibrary.edges._
import zio.json._
import fr.efrei.graphslibrary.utils.JsonSupport._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class JsonSupportTest extends AnyFlatSpec with Matchers {

  "JsonSupport" should "correctly serialize and deserialize UndirectedEdge" in {
    val edge = UndirectedEdge("A", "B")
    val json = edge.toJson
    val decodedEdge = json.fromJson[UndirectedEdge[String]]
    decodedEdge shouldBe Right(edge)
  }

  it should "correctly serialize and deserialize DirectedEdge" in {
    val edge = DirectedEdge("A", "B")
    val json = edge.toJson
    val decodedEdge = json.fromJson[DirectedEdge[String]]
    decodedEdge shouldBe Right(edge)
  }

  it should "correctly serialize and deserialize WeightedDirectedEdge" in {
    val edge = WeightedDirectedEdge("A", "B", 5.0)
    val json = edge.toJson
    val decodedEdge = json.fromJson[WeightedDirectedEdge[String]]
    decodedEdge shouldBe Right(edge)
  }

  it should "correctly serialize and deserialize WeightedUndirectedEdge" in {
    val edge = WeightedUndirectedEdge("A", "B", 2.5)
    val json = edge.toJson
    val decodedEdge = json.fromJson[WeightedUndirectedEdge[String]]
    decodedEdge shouldBe Right(edge)
  }

}