
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DirectedGraphSpec extends AnyFlatSpec with Matchers {

  "A DirectedGraph" should "add and remove edges correctly" in {
    val graph = DirectedGraph.empty[Int, DirectedEdge[Int]]
    val graphWithEdge = graph.addEdge(new DirectedEdge(1, 2))
    val graphWithAnotherEdge = graphWithEdge.addEdge(new DirectedEdge(2, 3))

    graphWithAnotherEdge.vertices should contain allOf(1, 2, 3)
    graphWithAnotherEdge.edges should contain(new DirectedEdge(1, 2))
    graphWithAnotherEdge.edges should contain(new DirectedEdge(2, 3))

    val graphWithoutEdge = graphWithAnotherEdge.removeEdge(new DirectedEdge(1, 2))

    graphWithoutEdge.edges should not contain new DirectedEdge(1, 2)
  }

  it should "handle weighted edges" in {
    val graph = DirectedGraph.empty[Int, DirectedWeightedEdge[Int]]
    val graphWithEdge = graph.addEdge(new DirectedWeightedEdge(1, 2, 1.0))
    val graphWithAnotherEdge = graphWithEdge.addEdge(new DirectedWeightedEdge(2, 3, 2.0))

    graphWithAnotherEdge.vertices should contain allOf(1, 2, 3)
    graphWithAnotherEdge.edges should contain(new DirectedWeightedEdge(1, 2, 1.0))
    graphWithAnotherEdge.edges should contain(new DirectedWeightedEdge(2, 3, 2.0))

    val graphWithoutEdge = graphWithAnotherEdge.removeEdge(new DirectedWeightedEdge(1, 2, 1.0))

    graphWithoutEdge.edges should not contain new DirectedWeightedEdge(1, 2, 1.0)
  }
}
