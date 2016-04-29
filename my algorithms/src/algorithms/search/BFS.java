package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class BFS.
 * @author Oran Cohen
 * @param <T> the generic type
 *  @return solution - PriorityQueue of Steps to solve the problem
 */
public class BFS<T> extends CommonSearcher<T>{

	/* (non-Javadoc)
	 * @see algorithms.search.CommonSearcher#search(algorithms.search.Searchable)
	 */
	@Override
	public Solution<T> search(Searchable<T> s) {
		
		openList = new PriorityQueue<>();
		openList.add(s.getInitialState());
		HashSet<State<T>> closedSet = new HashSet<State<T>>();
		
		// check if the open list is empty
		while(!openList.isEmpty())
		{
			// dequeue
			State<T> n = popState();
			// add the state to close set
			closedSet.add(n);
			
			// check if n is the goal state
			if(n.equals(s.getGoalState()))
			{
				
				return backTrace(n);
			}
			
			// get all possible state
			ArrayList<State<T>> successors = s.getAllPossibleStates(n);			
			for(State<T> st : successors)
			{
				// check if the state contain in open list and in close set
				if (!isContainInOpenList(openList, st) && !isContainInCloseSet(closedSet, st))
				{
					st.setCost(n.getCost() + getMoveCost());
					st.setCameFrom(n);
					openList.add(st);
				}
				else
				{
					if(!isContainInCloseSet(closedSet, st)) // this is only in the open list
					{
						st.setCost(n.getCost() + getMoveCost());
						CheckIfBetter(st);
					}
				}
			}
		}
		return null;
	}
	
	public int getMoveCost() {
		return 1;
	}
}
