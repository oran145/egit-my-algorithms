package algorithms.mazeGenerators;

import algorithms.search.State;

// TODO: Auto-generated Javadoc
/**
 * @author Oran Cohen
 * The Class Position.
 */
public class Position {
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The z. */
	private int z;
	
	/**
	 * Instantiates a new position.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public Position(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Gets the z.
	 *
	 * @return the z
	 */
	public int getZ() {
		return z;
	}
	
	/**
	 * Sets the z.
	 *
	 * @param z the new z
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("{" + this.getX() + "," + this.getY() + "," + this.getZ() + "}");
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Position p = (Position) obj;
		if (this.x == p.getX() && this.y == p.getY() && this.z == p.getZ())
			return true;
		return false;
	}
}
