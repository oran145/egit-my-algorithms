package algorithms.search;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

// TODO: Auto-generated Javadoc
/**
 * The Class Solution.
 *
 * @param <T> the generic type
 */
public class Solution<T> {

	/**
	 * @author Oran Cohen
	 * Instantiates a new solution.
	 */
	public Solution() {
		statesQueue = new PriorityQueue<State<T>>();
	}

	/** The states queue. */
	private Queue<State<T>> statesQueue;

	/**
	 * Gets the states queue.
	 *
	 * @return the states queue
	 */
	public Queue<State<T>> getStatesQueue() {
		return statesQueue;
	}

	/**
	 * Sets the states queue.
	 *
	 * @param statesQueue the new states queue
	 */
	public void setStatesQueue(Queue<State<T>> statesQueue) {
		this.statesQueue = statesQueue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.statesQueue.toString();
	}

	/**
	 * Prints the solution of the problem.
	 */
	public void print() {
		
		Iterator<State<T>> it = statesQueue.iterator();
		while (it.hasNext()) {
			State<T> currentState = it.next();
			System.out.println(currentState.getState().toString());
			}
		}

	}

