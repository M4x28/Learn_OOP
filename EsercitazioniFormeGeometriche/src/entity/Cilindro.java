/**
 * 
 */
package entity;

/**
 * 
 */
public class Cilindro extends FormaGeometricaTridimensionale {

	/**
	 * @param l
	 */
	public Cilindro(double l, double b) {
		super(l, b, 0);
	}

	@Override
	public double calcolaArea() {
		return Math.round(Math.PI * Math.pow(getL(), 2));
	}

	@Override
	public double calcolaVolume() {
		return Math.round(Math.PI * Math.pow(getL(), 2) * getB());
	}

}
