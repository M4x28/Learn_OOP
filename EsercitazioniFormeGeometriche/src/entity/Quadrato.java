/**
 * 
 */
package entity;

/**
 * 
 */
public class Quadrato extends FormaGeometricaBidimensionale {

	/**
	 * @param l
	 */
	public Quadrato(double l) {
		super(l, l);
	}

	@Override
	public double calcolaArea() {
		return getL() * getL();
	}

}
