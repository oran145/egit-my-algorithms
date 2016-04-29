package algorithms.mazeGenerators;


// TODO: Auto-generated Javadoc
/**
 * @author Oran Cohen
 * The Class CommonMaze3dGenerator.
 */
public abstract class CommonMaze3dGenerator implements Maze3dGenerator {
	
	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.Maze3dGenerator#generate()
	 */
	public abstract Maze3d generate();

	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.Maze3dGenerator#measureAlgorithmTime()
	 */
	@Override
	public String measureAlgorithmTime() {
		long start,finish;
		start=System.currentTimeMillis();
		generate();
		finish=System.currentTimeMillis();
		return (finish-start) + "ms";
	}
}
