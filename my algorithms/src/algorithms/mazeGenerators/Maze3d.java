package algorithms.mazeGenerators;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * @author Oran Cohen
 * The Class Maze3d.
 */
public class Maze3d {
	
	/** The maze. */
	private int[][][] maze;
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The z. */
	private int z;
	
	/** The start position. */
	private Position startPosition;
	
	/** The goal position. */
	private Position goalPosition;

	/**
	 * Instantiates a new maze3d.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public Maze3d(int x, int y, int z) {
		this.maze = new int[x][y][z];
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the z.
	 *
	 * @return the z
	 */
	public int getZ() {
		return z;
	}

	/**
	 * Sets the z.
	 *
	 * @param z the new z
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	public int[][][] getMaze() {
		return maze;
	}

	/**
	 * Sets the maze.
	 *
	 * @param maze the new maze
	 */
	public void setMaze(int[][][] maze) {
		this.maze = maze;
	}

	
	/**
	 * Gets the start position.
	 *
	 * @return the start position
	 */
	public Position getStartPosition()
	{
		return this.startPosition;
	}

	
	/**
	 * Sets the start position.
	 *
	 * @param startPosition the new start position
	 */
	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
		this.maze[startPosition.getX()][startPosition.getY()][startPosition.getZ()] = 0;
	}

	/**
	 * Gets the goal position.
	 *
	 * @return the goal position
	 */
	public Position getGoalPosition() {
		return this.goalPosition;
	}

	
	/**
	 * Sets the goal position.
	 *
	 * @param goalPosition the new goal position
	 */
	public void setGoalPosition(Position goalPosition) {
		this.goalPosition = goalPosition;
		this.maze[goalPosition.getX()][goalPosition.getY()][goalPosition.getZ()] = 0;
	}

	/**
	 * Gets the possible moves.
	 *
	 * @param p the p
	 * @return the possible moves
	 */
	public String[] getPossibleMoves(Position p) {
		int x = p.getX();
		int y = p.getY();
		int z = p.getZ();

		ArrayList<String> possibleMove = new ArrayList<String>();

		if ((x != (this.x - 1)) && (this.maze[x + 1][y][z] == 0)) {
			possibleMove.add("forward");
		}

		if (x != 0 && (this.maze[x - 1][y][z] == 0)) {
			possibleMove.add("backwards");
		}

		if ((y != (this.y - 1)) && (this.maze[x][y + 1][z] == 0)) {
			possibleMove.add("right");
		}

		if ((y != 0) && (this.maze[x][y - 1][z] == 0)) {
			possibleMove.add("left");
		}

		if ((z != (this.z - 1)) && (this.maze[x][y][z + 1] == 0)) {
			possibleMove.add("up");
		}

		if ((z != 0) && (this.maze[x][y][z - 1] == 0)) {
			possibleMove.add("down");
		}

		String[] arr = new String[possibleMove.size()];
		return possibleMove.toArray(arr);
	}

	/**
	 * Gets the cross section by x.
	 *
	 * @param x the x
	 * @return the cross section by x
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public int[][] getCrossSectionByX(int x) throws IndexOutOfBoundsException {
		if (x >= 0 && x < this.x) {
			int[][] maze2d = new int[this.y][this.z];
			for (int i = 0; i < this.y; ++i) {
				for (int j = 0; j < this.z; ++j)
					maze2d[i][j] = this.maze[x][i][j];
			}
			return maze2d;
		} else
			throw new IndexOutOfBoundsException("Invalid input");
	}

	/**
	 * Gets the cross section by y.
	 *
	 * @param y the y
	 * @return the cross section by y
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public int[][] getCrossSectionByY(int y) throws IndexOutOfBoundsException {
		if (y >= 0 && y < this.y) {
			int[][] maze2d = new int[this.x][this.z];
			for (int i = 0; i < this.x; ++i) {
				for (int j = 0; j < this.z; ++j)
					maze2d[i][j] = this.maze[i][y][j];
			}
			return maze2d;
		} else
			throw new IndexOutOfBoundsException("Invalid input");
	}

	/**
	 * Gets the cross section by z.
	 *
	 * @param z the z
	 * @return the cross section by z
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public int[][] getCrossSectionByZ(int z) throws IndexOutOfBoundsException {
		if (z >= 0 && z < this.z) {
			int[][] maze2d = new int[this.x][this.y];
			for (int i = 0; i < this.x; ++i) {
				for (int j = 0; j < this.y; ++j)
					maze2d[i][j] = this.maze[i][j][z];
			}
			return maze2d;
		} else
			throw new IndexOutOfBoundsException("Invalid input");
	}

	/**
	 * Sets the position value.
	 *
	 * @param p the p
	 * @param value the value
	 */
	public void setPositionAsValue(Position p, int value)
	{
		this.getMaze()[p.getX()][p.getY()][p.getZ()] = value;
	}
	
	/**
	 * Gets the position value.
	 *
	 * @param p the p
	 * @return the position value
	 */
	public int getPositionValue(Position p)
	{
		return this.getMaze()[p.getX()][p.getY()][p.getZ()];
	}
	
	/**
	 * Prints the maze.
	 */
	public void print()
	{
		System.out.println("Length(x)=" + this.x + ", width(y)=" + this.y + ", Floors(z)=" + this.z);
		for (int i=0;i<this.z;i++)
		{
			System.out.println("****** FLOOR " + i);
			for (int j=0;j<this.x;j++)
			{
				for (int k=0;k<this.y;k++)
				{
					System.out.print(this.maze[j][k][i]);
				}
				System.out.println(" ");
			}
			System.out.println();
		}
		System.out.println("***************");
	}
	
}
