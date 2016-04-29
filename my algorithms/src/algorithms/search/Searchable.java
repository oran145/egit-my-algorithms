package algorithms.search;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Searchable.
 *@author Oran Cohen
 * @param <T> the generic type
 */
public interface Searchable<T> {
	
	/**
	 * Gets the initial state.
	 *
	 * @return the initial state
	 */
	//start state
	State<T> getInitialState();
	
	/**
	 * Gets the goal state.
	 *
	 * @return the goal state
	 */
	//end state
	State<T> getGoalState();
	
	/**
	 * Gets the all possible states.
	 *
	 * @param s the s
	 * @return the all possible states
	 */
	//possible state for specific state
	ArrayList<State<T>> getAllPossibleStates(State<T> s);

	

}