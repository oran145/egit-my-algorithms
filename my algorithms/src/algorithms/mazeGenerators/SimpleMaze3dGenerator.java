package algorithms.mazeGenerators;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * @author Oran Cohen
 * The Class SimpleMaze3dGenerator.
 */
public class SimpleMaze3dGenerator extends CommonMaze3dGenerator {

	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.CommonMaze3dGenerator#generate()
	 */
	@Override
	public Maze3d generate() {
		int MaxSize=10;
		Random rand = new Random();
		int x=(rand.nextInt(MaxSize))+2;
		int y=(rand.nextInt(MaxSize))+2;
		int z=(rand.nextInt(MaxSize))+2;
		Maze3d maze3 = new Maze3d(x, y, z);
		int pathLength = rand.nextInt((x * y * z) / 2)+1;

		int randX = rand.nextInt(x);
		int randY = rand.nextInt(y);
		int randZ = rand.nextInt(z);
		Position startPosition = new Position(randX, randY, randZ);
		Position goalPosition = new Position(randX, randY, randZ);
		enumDirection randDir;

		for (int i = 0; i < z; i++) // floor
		{
			for (int j = 0; j < x; j++) // height
			{
				for (int k = 0; k < y; k++) // width
				{

					maze3.setPositionAsValue(new Position(j, k, i), 1);

				}
			}
		}

		while (pathLength != 0) {
			randDir = enumDirection.values()[rand.nextInt(5)];
			switch (randDir) {

			case FORWARD:
				if (goalPosition.getX() + 1 < maze3.getX()) {
					goalPosition.setX(goalPosition.getX() + 1);
				} else
					continue;
				break;

			case BACKWARD:
				if (goalPosition.getX() - 1 >= 0) {
					goalPosition.setX(goalPosition.getX() - 1);
				} else
					continue;
				break;
			case RIGHT:
				if (goalPosition.getY() + 1 < maze3.getY()) {
					goalPosition.setY(goalPosition.getY() + 1);
				} else
					continue;
				break;
			case LEFT:
				if (goalPosition.getY() - 1 >= 0) {
					goalPosition.setY(goalPosition.getY() - 1);
				} else
					continue;
				break;
			case UP:
				if (goalPosition.getZ() + 1 < maze3.getZ()) {
					goalPosition.setZ(goalPosition.getZ() + 1);
				} else
					continue;
				break;
			case DOWN:
				if (goalPosition.getZ() - 1 >= 0) {
					goalPosition.setZ(goalPosition.getZ() - 1);
				} else
					continue;
				break;
			}

			maze3.setPositionAsValue(goalPosition, 0);
			pathLength--;
		}

		maze3.setStartPosition(startPosition);
		maze3.setGoalPosition(goalPosition);

		// initialization the rest of the maze
		for (int i = 0; i < z; i++) // floor
		{
			for (int j = 0; j < x; j++) // height
			{
				for (int k = 0; k < y; k++) // width
				{
					Position p = new Position(j, k, i);
					// checking if the position is not part of path
					if (maze3.getPositionValue(p) != 0) {
						maze3.setPositionAsValue(new Position(j, k, i), 1);
					}
				}
			}
		}

		return maze3;
	}
}
