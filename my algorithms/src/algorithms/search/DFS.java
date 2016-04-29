package algorithms.search;

import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class DFS.
 *@author Oran Cohen
 * @param <T> the generic type
 */
public class DFS<T> extends CommonSearcher<T> {

	/* (non-Javadoc)
	 * @see algorithms.search.CommonSearcher#search(algorithms.search.Searchable)
	 */
	@Override
	public Solution<T> search(Searchable<T> s) {
		dfs(s, s.getInitialState());
		return  backTrace(s.getGoalState());
	}
	
	/**
	 * DFS - Recursively
	 *
	 * @param s the s
	 * @param state the state
	 * @return true, if successful
	 */
	private boolean dfs(Searchable<T> s, State<T> state) {
		if (state.equals(s.getGoalState()))
		{
			s.getGoalState().setCameFrom(state.getCameFrom());
			return true;
		}
		
		state.setVisited(true);
		increaseEvaluatedNode();
		
		
		ArrayList<State<T>> successors = s.getAllPossibleStates(state);
		if(successors.size() >1)
		{
			int f=0;
		}
		for(State<T> successor: successors)
		{
			if (!successor.isVisited()) {
				successor.setCameFrom(state);
				if (dfs(s, successor))
					
					return true;
			}
		}
		return false;
	}
}
