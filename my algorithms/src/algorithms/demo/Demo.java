package algorithms.demo;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.BestFS;
import algorithms.search.DFS;
import algorithms.search.Searcher;
import algorithms.search.Solution;

// TODO: Auto-generated Javadoc
/**
 * @author Oran Cohen
 * The Class Demo.
 */
public class Demo {
	
	/**
	 * Run- create maze and then solve the maze with Breadth First Search, Best First Search, Depth First Search.
	 */
	public void Run() {
		Maze3dGenerator mg = new MyMaze3dGenerator();
		Maze3d maze = mg.generate();
		maze.print();
		System.out.println("start state " + maze.getStartPosition().toString());
		System.out.println("goal state " + maze.getGoalPosition().toString());
		// BFS
		Searcher<Position> searcher = new BFS<Position>();
		Solution<Position> solution = searcher.search(new MazeSearch(maze));
		System.out.println("BFS solution");
		solution.print();
		System.out.println("Number of Nodes BFS:" + searcher.getNumberOfNodesEvaluated());
		// BestFS
		Searcher<Position> searcher3 = new BestFS<Position>();
		Solution<Position> solution3 = searcher3.search(new MazeSearch(maze));
		System.out.println("BestFS solution");
		solution3.print();
		System.out.println("Number of Nodes BestFS:" + searcher3.getNumberOfNodesEvaluated());
		// DFS
		Searcher<Position> searcher2 = new DFS<Position>();
		Solution<Position> solution2 = searcher2.search(new MazeSearch(maze));
		System.out.println("DFS solution");
		solution2.print();
		System.out.println("Number of Nodes DFS:" + searcher2.getNumberOfNodesEvaluated());

	}
}