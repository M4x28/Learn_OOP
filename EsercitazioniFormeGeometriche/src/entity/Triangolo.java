/**
 * 
 */
package entity;

/**
 * 
 */
public class Triangolo extends FormaGeometricaBidimensionale {

	/**
	 * @param l
	 */
	public Triangolo(double l, double b) {
		super(l, b);
	}

	@Override
	public double calcolaArea() {
		return Math.round((getL() * getB()) / 2);
	}

}
