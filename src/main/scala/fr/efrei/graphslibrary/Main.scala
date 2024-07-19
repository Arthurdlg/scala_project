package fr.efrei.graphslibrary

import fr.efrei.graphslibrary.services._
import fr.efrei.graphslibrary.edges.WeightedEdge
import zio._
import zio.console._

object Main extends App {
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] =
    program.exitCode

  private val program: URIO[Console with Clock, Unit] =
    for {
      graphService <- GraphService.create[Int]
      _ <- putStrLn("Welcome to ZIO Graph Algorithms!")
      _ <- menu(graphService)
    } yield ()

  private def menu(graphService: GraphService[Int]): URIO[Console, Unit] =
    for {
      _ <- putStrLn("\nMenu:")
      _ <- putStrLn("1. Add Vertex")
      _ <- putStrLn("2. Add Edge")
      _ <- putStrLn("3. Find Shortest Path (Dijkstra)")
      _ <- putStrLn("4. Find All Shortest Paths (Floyd-Warshall)")
      _ <- putStrLn("5. Breadth-First Search")
      _ <- putStrLn("6. Depth-First Search")
      _ <- putStrLn("7. Detect Cycles")
      _ <- putStrLn("8. Topological Sort")
      _ <- putStrLn("9. Show Graph")
      _ <- putStrLn("10. Exit")
      choice <- getStrLn
      _ <- choice match {
        case "1" => addVertex(graphService) *> menu(graphService)
        case "2" => addEdge(graphService) *> menu(graphService)
        case "3" => findShortestPathDijkstra(graphService) *> menu(graphService)
        case "4" => findAllShortestPathsFloydWarshall(graphService) *> menu(graphService)
        case "5" => breadthFirstSearch(graphService) *> menu(graphService)
        case "6" => depthFirstSearch(graphService) *> menu(graphService)
        case "7" => detectCycles(graphService) *> menu(graphService)
        case "8" => topologicalSort(graphService) *> menu(graphService)
        case "9" => showGraph(graphService) *> menu(graphService)
        case "10" => UIO.unit
        case _ => putStrLn("Invalid option!") *> menu(graphService)
      }
    } yield ()

  private def addVertex(graphService: GraphService[Int]): URIO[Console, Unit] =
    for {
      _ <- putStrLn("Enter vertex:")
      vertex <- getStrLn.map(_.toInt)
      _ <- graphService.addVertex(vertex)
    } yield ()

  private def addEdge(graphService: GraphService[Int]): URIO[Console, Unit] =
    for {
      _ <- putStrLn("Enter start vertex:")
      start <- getStrLn.map(_.toInt)
      _ <- putStrLn("Enter end vertex:")
      end <- getStrLn.map(_.toInt)
      _ <- putStrLn("Enter weight:")
      weight <- getStrLn.map(_.toDouble)
      _ <- graphService.addEdge(start, end, weight)
    } yield ()

  private def findShortestPathDijkstra(graphService: GraphService[Int]): URIO[Console, Unit] =
    for {
      _ <- putStrLn("Enter start vertex:")
      start <- getStrLn.map(_.toInt)
      graph <- graphService.getGraph
      distances <- DijkstraService.dijkstra(graph, start)
      _ <- putStrLn(s"Shortest paths from $start: $distances")
    } yield ()

  private def findAllShortestPathsFloydWarshall(graphService: GraphService[Int]): URIO[Console, Unit] =
    for {
      graph <- graphService.getGraph
      distances <- FloydWarshallService.floydWarshall(graph)
      _ <- putStrLn(s"All shortest paths: $distances")
    } yield ()

  private def breadthFirstSearch(graphService: GraphService[Int]): URIO[Console, Unit] =
    for {
      _ <- putStrLn("Enter start vertex:")
      start <- getStrLn.map(_.toInt)
      graph <- graphService.getGraph
      result <- BreadthFirstSearchService.bfs(graph, start)
      _ <- putStrLn(s"BFS starting from $start: $result")
    } yield ()

  private def depthFirstSearch(graphService: GraphService[Int]): URIO[Console, Unit] =
    for {
      _ <- putStrLn("Enter start vertex:")
      start <- getStrLn.map(_.toInt)
      graph <- graphService.getGraph
      result <- DepthFirstSearchService.dfs(graph, start)
      _ <- putStrLn(s"DFS starting from $start: $result")
    } yield ()

  private def detectCycles(graphService: GraphService[Int]): URIO[Console, Unit] =
    for {
      graph <- graphService.getGraph
      hasCycle <- CycleDetectionService.hasCycle(graph)
      _ <- putStrLn(s"Graph has cycle: $hasCycle")
    } yield ()

  private def topologicalSort(graphService: GraphService[Int]): URIO[Console, Unit] =
    for {
      graph <- graphService.getGraph
      result <- TopologicalSortService.topologicalSort(graph)
      _ <- putStrLn(s"Topological sort: $result")
    } yield ()

  private def showGraph(graphService: GraphService[Int]): URIO[Console, Unit] =
    for {
      graph <- graphService.getGraph
      _ <- putStrLn(graph.toString)
    } yield ()
}
