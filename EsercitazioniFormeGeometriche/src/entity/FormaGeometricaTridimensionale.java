/**
 * 
 */
package entity;

/**
 * 
 */
public abstract class FormaGeometricaTridimensionale extends FormaGeometrica implements FormaTridimensionale {

	private double b;
	private double c;

	/**
	 * @param l
	 */
	public FormaGeometricaTridimensionale(double l, double b, double c) {
		super(l);
		this.b = b;
		this.c = c;
	}

	@Override
	public abstract double calcolaArea();

	@Override
	public abstract double calcolaVolume();

	/**
	 * @return the b
	 */
	public double getB() {
		return b;
	}

	/**
	 * @return the c
	 */
	public double getC() {
		return c;
	}

}
