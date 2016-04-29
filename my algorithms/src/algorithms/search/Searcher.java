package algorithms.search;

// TODO: Auto-generated Javadoc
/**
 * The Interface Searcher.
 *@author Oran Cohen
 * @param <T> the generic type
 */
// interface for the algo: dfs,bfs
public interface Searcher<T> {
	
	/**
	 * Search.
	 *
	 * @param s the s
	 * @return the solution
	 */
	public Solution<T> search(Searchable<T> s);
	
	/**
	 * Gets the number of nodes evaluated.
	 *
	 * @return the number of nodes evaluated
	 */
	public int getNumberOfNodesEvaluated();

}
