/**
 * 
 */
package test;

import java.util.ArrayList;

import entity.Cilindro;
import entity.Cubo;
import entity.FormaGeometrica;
import entity.FormaGeometricaBidimensionale;
import entity.FormaGeometricaTridimensionale;
import entity.Quadrato;
import entity.Triangolo;

/**
 * 
 */
public class TestForma {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<FormaGeometrica> forme = new ArrayList<FormaGeometrica>();

		Quadrato q = new Quadrato(2);
		forme.add(q);
		Triangolo t = new Triangolo(2, 3);
		forme.add(t);
		Cubo c = new Cubo(3);
		forme.add(c);
		Cilindro ci = new Cilindro(2, 3);
		forme.add(ci);

		for (FormaGeometrica formaGeometrica : forme) {
			System.out.println("Tipo: " + formaGeometrica.getClass().getName());
			if (formaGeometrica instanceof FormaGeometricaBidimensionale) {
				System.out.println("Area: " + ((FormaGeometricaBidimensionale) formaGeometrica).calcolaArea());
			} else {
				System.out.println("Area: " + ((FormaGeometricaTridimensionale) formaGeometrica).calcolaArea());
				System.out.println("Valume: " + ((FormaGeometricaTridimensionale) formaGeometrica).calcolaVolume());
			}
		}
	}

}
