package algorithms.search;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class BestFS.
 *@author Oran Cohen
 * @param <T> the generic type
 * this class extends BFS and override the function that change the cost for each move.
 */
public class BestFS<T> extends BFS<T> {
	
	/* (non-Javadoc)
	 * @see algorithms.search.BFS#getMoveCost()
	 */
	@Override
	public int getMoveCost() {
		Random rand = new Random();
		int x = rand.nextInt(10);
		return x;
	}

}
