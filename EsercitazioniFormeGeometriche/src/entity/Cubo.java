/**
 * 
 */
package entity;

/**
 * 
 */
public class Cubo extends FormaGeometricaTridimensionale {

	/**
	 * @param l
	 */
	public Cubo(double l) {
		super(l, l, l);
	}

	@Override
	public double calcolaArea() {
		return 4 * getL();
	}

	@Override
	public double calcolaVolume() {
		return Math.pow(getL(), 3);
	}

}
