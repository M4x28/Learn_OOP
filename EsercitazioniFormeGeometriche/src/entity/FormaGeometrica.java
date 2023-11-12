/**
 * 
 */
package entity;

import java.util.Objects;

/**
 * 
 */
public class FormaGeometrica {

	private double l;

	/**
	 * @param l
	 */
	public FormaGeometrica(double l) {
		this.l = l;
	}

	/**
	 * @return the l
	 */
	public double getL() {
		return l;
	}

	@Override
	public int hashCode() {
		return Objects.hash(l);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof FormaGeometrica)) {
			return false;
		}
		FormaGeometrica other = (FormaGeometrica) obj;
		return Double.doubleToLongBits(l) == Double.doubleToLongBits(other.l);
	}

}
