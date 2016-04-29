package algorithms.search;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonSearcher.
 *@author Oran Cohen
 * @param <T> the generic type
 */
public abstract class CommonSearcher<T> implements Searcher<T> {
	
	/** The open list. */
	protected PriorityQueue<State<T>> openList;
	
	/** The evaluated nodes. */
	private int evaluatedNodes;

	/* (non-Javadoc)
	 * @see algorithms.search.Searcher#search(algorithms.search.Searchable)
	 */
	public abstract Solution<T> search(Searchable<T> s);

	/* (non-Javadoc)
	 * @see algorithms.search.Searcher#getNumberOfNodesEvaluated()
	 */
	@Override
	public int getNumberOfNodesEvaluated() {
		return this.evaluatedNodes;
	}

	/**
	 * Pop state.
	 *
	 * @return the state
	 */
	protected State<T> popState() {
		this.evaluatedNodes++;
		return openList.poll();
	}
	
	/**
	 * Increase evaluated node.
	 */
	protected void increaseEvaluatedNode() {
		this.evaluatedNodes++;
	}

	/**
	 * Checks if is contain in open list.
	 *
	 * @param openList the open list
	 * @param state the state
	 * @return true, if is contain in open list
	 */
	public boolean isContainInOpenList(PriorityQueue<State<T>> openList, State<T> state) {
		Iterator<State<T>> it = openList.iterator();
		while (it.hasNext()) {
			State<T> currentState = it.next();
			if (state.getState().equals(currentState.getState()))
				return true;
		}
		return false;
	}

	/**
	 * Checks if is contain in close set.
	 *
	 * @param closedSet the closed set
	 * @param state the state
	 * @return true, if is contain in close set
	 */
	public boolean isContainInCloseSet(HashSet<State<T>> closedSet, State<T> state) {
		Iterator<State<T>> it = closedSet.iterator();
		while (it.hasNext()) {
			State<T> currentState = it.next();
			if (state.getState().equals(currentState.getState()))
				return true;
		}
		return false;
	}

	/**
	 * This function Moves on the open list and looking for the state
	 * and then check those whichever is cheaper and updates
	 * Check if better.
	 *
	 * @param s the s
	 */
	public void CheckIfBetter(State<T> s) {
		Iterator<State<T>> it = openList.iterator();
		while (it.hasNext()) {
			State<T> currentState = it.next();
			if (s.equals(currentState.getState()) && s.getCost() < currentState.getCost()) {
				it.remove();
				openList.add(s);
			}
		}
	}
	
	/**
	 * Back trace.
	 *
	 * @param goal the goal
	 * @return the solution
	 */
	public Solution<T> backTrace(State<T> goal)
	{
		Solution<T> solution= new Solution<T>();
		State<T> current = goal; 
		while(current.getCameFrom()!= null)
		{
			solution.getStatesQueue().add(current);
			current = current.getCameFrom();
		}
		
		solution.getStatesQueue().add(current);
		
		return solution;
	}
}
