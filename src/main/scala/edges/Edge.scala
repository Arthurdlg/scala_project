package edges

trait Edge[V] {
  def node1 : String
  def node2 : String
  def weight : Double
}
