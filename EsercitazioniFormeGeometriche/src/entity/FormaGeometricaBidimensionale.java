/**
 * 
 */
package entity;

/**
 * 
 */
public abstract class FormaGeometricaBidimensionale extends FormaGeometrica implements FormaBidimensionale {

	private double b;

	/**
	 * @param l
	 */
	public FormaGeometricaBidimensionale(double l, double b) {
		super(l);
		this.b = b;
	}

	@Override
	public abstract double calcolaArea();

	/**
	 * @return the b
	 */
	public double getB() {
		return b;
	}

}
