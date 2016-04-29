package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

// TODO: Auto-generated Javadoc
/**
 * @author Oran Cohen
 * The Class MyMaze3dGenerator.
 */
public class MyMaze3dGenerator extends CommonMaze3dGenerator {

	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.CommonMaze3dGenerator#generate()
	 */
	@Override
	public Maze3d generate() {
		int MaxSize = 6;
		Random rand = new Random();
		int x = (rand.nextInt(MaxSize)) + 2;
		int y = (rand.nextInt(MaxSize)) + 2;
		int z = (rand.nextInt(MaxSize)) + 2;
		Maze3d maze = new Maze3d(x * 2 - 1, y * 2 - 1, z * 2 - 1);

		// init maze
		for (int i = 0; i < z * 2 - 1; i++) {
			for (int j = 0; j < x * 2 - 1; j++) {
				for (int k = 0; k < y * 2 - 1; k++) {
					if (k % 2 != 0 || j % 2 != 0 || i % 2 != 0)
						maze.getMaze()[j][k][i] = 1; // cell
					else
						maze.getMaze()[j][k][i] = 2;// wall
				}
			}
		}

		// rand start position

		int randX = rand.nextInt(x);
		int randY = rand.nextInt(y);
		int randZ = rand.nextInt(z);
		Position startPosition = new Position(randX * 2, randY * 2, randZ * 2);
		maze.setStartPosition(startPosition);

		// define stack and add the first position
		Stack<Position> stack = new Stack<Position>();
		stack.add(startPosition);
		Position current = startPosition;

		ArrayList<Position> neighbors = null;
		boolean isStuck= false;

		// check if all of the cells are visited
		while (!stack.isEmpty()) {
			// get all the neighbors of position which it is possible to move
			neighbors = GetPossibleNeighbors(maze, current);

			if (!neighbors.isEmpty()) {
				isStuck=false;
				// random position to move
				Position nextStep = neighbors.remove(rand.nextInt(neighbors.size()));
				// change as visited
				maze.setPositionAsValue(nextStep, 0);
				// add to moves stack
				stack.add(nextStep);
				// break the wall between two positions
				breakTheWall(current, nextStep, maze);

				current = nextStep;
			} else {
				if (!isStuck){
					maze.setGoalPosition(current);
					isStuck=true;
				}
									
				current = stack.pop();
			}

		}

		return maze;
	}

	/**
	 * Break the wall between 2 positions.
	 *
	 * @param current the current
	 * @param nextStep the next step
	 * @param maze the maze
	 */
	private void breakTheWall(Position current, Position nextStep, Maze3d maze) {
		int currentX = current.getX();
		int currentY = current.getY();
		int currentZ = current.getZ();

		int nextX = nextStep.getX();
		int nextY = nextStep.getY();
		int nextZ = nextStep.getZ();

		if (currentX != nextX) {
			if (currentX > nextX) {
				maze.setPositionAsValue(new Position((currentX - 1), currentY, currentZ), 0);
			} else {
				maze.setPositionAsValue(new Position((currentX + 1), currentY, currentZ), 0);
			}
		} else if (currentY != nextY) {
			if (currentY > nextY) {
				maze.setPositionAsValue(new Position(currentX, (currentY - 1), currentZ), 0);
			} else {
				maze.setPositionAsValue(new Position(currentX, (currentY + 1), currentZ), 0);
			}
		} else if (currentZ != nextZ) {
			if (currentZ > nextZ) {
				maze.setPositionAsValue(new Position(currentX, currentY, (currentZ - 1)), 0);
			} else {
				maze.setPositionAsValue(new Position(currentX, currentY, (currentZ + 1)), 0);
			}
		}
	}
	// return the possible neighbors from position

	/**
	 * Gets the possible neighbors.
	 *
	 * @param maze the maze
	 * @param p the p
	 * @return the array list
	 */
	public ArrayList<Position> GetPossibleNeighbors(Maze3d maze, Position p) {
		int x = p.getX();
		int y = p.getY();
		int z = p.getZ();

		ArrayList<Position> PossibleNeighbors = new ArrayList<Position>();

		if ((x <= (maze.getX() - 2)) && (maze.getMaze()[x + 2][y][z] == 2)) {
			PossibleNeighbors.add(new Position(x + 2, y, z));
		}

		if (x != 0 && (maze.getMaze()[x - 2][y][z] == 2)) {
			PossibleNeighbors.add(new Position(x - 2, y, z));
		}

		if ((y <= (maze.getY() - 2)) && (maze.getMaze()[x][y + 2][z] == 2)) {
			PossibleNeighbors.add(new Position(x, y + 2, z));
		}

		if ((y != 0) && (maze.getMaze()[x][y - 2][z] == 2)) {
			PossibleNeighbors.add(new Position(x, y - 2, z));
		}

		if ((z <= (maze.getZ() - 2)) && (maze.getMaze()[x][y][z + 2] == 2)) {
			PossibleNeighbors.add(new Position(x, y, z + 2));
		}

		if ((z != 0) && (maze.getMaze()[x][y][z - 2] == 2)) {
			PossibleNeighbors.add(new Position(x, y, z - 2));
		}

		return PossibleNeighbors;

	}

}
