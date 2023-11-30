/**
 * 
 */
package test;

import java.util.ArrayList;

import entity.CarbonFootPrint;

/**
 * 
 */
public class Test {
	private ArrayList<CarbonFootPrint> c;

	/**
	 * 
	 */
	public Test() {
		c = new ArrayList<CarbonFootPrint>();
	}

	public double calculateTotal() {
		double tot = 0.0;
		for (CarbonFootPrint carbonFootPrint : c) {
			tot += carbonFootPrint.getCarbonFootprint();
		}
		return tot;
	}

	public static void main(String[] args) {
		Test t = new Test();
	}
}
