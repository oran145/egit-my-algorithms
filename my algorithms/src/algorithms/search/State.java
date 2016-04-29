package algorithms.search;

// TODO: Auto-generated Javadoc
/**
 * The Class State.
 *@author Oran Cohen
 * @param <T> the generic type
 */
public class State<T> implements Comparable<State>{
	
	/** The state. */
	private T state;
	
	/** The cost. */
	private int cost;
	
	/** The came from. */
	private State<T> cameFrom;
	
	/** The visited. */
	private boolean visited;
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * Gets the came from.
	 *
	 * @return the came from
	 */
	public State<T> getCameFrom() {
		return cameFrom;
	}

	/**
	 * Sets the came from.
	 *
	 * @param cameFrom the new came from
	 */
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public T getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(T state) {
		this.state = state;
	}

	/**
	 * Instantiates a new state.
	 */
	public State()
	{	
	}
	
	/**
	 * Instantiates a new state.
	 *
	 * @param state the state
	 */
	public State(T state)
	{
		this.state = state;
		this.cost = 0;
		this.cameFrom = null;
	}
	
	/**
	 * Instantiates a new state.
	 *
	 * @param s the s
	 */
	public State(State<T> s)
	{
		this.state = s.state;
		this.cost = s.cost;
		this.cameFrom = s.cameFrom;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return this.state.equals(((State)obj).getState());
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(State s) {
		if (getCost() < s.getCost()) {
            return -1;
        }
        if (getCost() > s.getCost()) {
            return 1;
        }
        return 0;
	}

	/**
	 * Checks if is visited.
	 *
	 * @return true, if is visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * Sets the visited.
	 *
	 * @param visited the new visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
}
