package algorithms.demo;

import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;

// TODO: Auto-generated Javadoc
/**
 * @author Oran Cohen
 * The Class MazeSearch - object adapter.
 */
public class MazeSearch implements Searchable<Position> {

	/** The maze3d. */
	private Maze3d maze3d;
	
	/** The initial state. */
	private State<Position> initialState;
	
	/** The goal state. */
	private State<Position> goalState;

	/**
	 * Instantiates a new maze search.
	 *
	 * @param maze3d the maze3d
	 */
	public MazeSearch(Maze3d maze3d) {
		this.maze3d = maze3d;
		this.initialState = new State<Position>(maze3d.getStartPosition());
		this.goalState = new State<Position>(maze3d.getGoalPosition());
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getInitialState()
	 */
	@Override
	public State<Position> getInitialState() {
		return initialState;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getGoalState()
	 */
	@Override
	public State<Position> getGoalState() {
		return goalState;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getAllPossibleStates(algorithms.search.State)
	 */
	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {

		// variables
		ArrayList<State<Position>> possibleState = new ArrayList<State<Position>>();
		Position pos = s.getState();
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		String[] temp = this.maze3d.getPossibleMoves(pos);

		for (String direction : temp) {
			switch (direction) {
			case "forward":
				possibleState.add(new State<Position>(new Position(x + 2, y, z)));
				break;
			case "backwards":
				possibleState.add(new State<Position>(new Position(x - 2, y, z)));
				break;
			case "left":
				possibleState.add(new State<Position>(new Position(x, y - 2, z)));
				break;
			case "right":
				possibleState.add(new State<Position>(new Position(x, y + 2, z)));
				break;
			case "up":
				possibleState.add(new State<Position>(new Position(x, y, z + 2)));
				break;
			case "down":
				possibleState.add(new State<Position>(new Position(x, y, z - 2)));
				break;
			}
		}
		if (s.getCameFrom() != null) {
			possibleState.remove(s.getCameFrom());
		}
		return possibleState;
	}
}
