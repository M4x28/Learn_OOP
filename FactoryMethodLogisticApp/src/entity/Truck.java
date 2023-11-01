/**
 * 
 */
package entity;

/**
 * Classe Camion che implementa l'interfaccia Trasporto con tutti i suoi metodi
 * 
 * @author Leonardo Birardi
 */
public class Truck implements Transport {

	@Override
	public void deliver() {
		System.out.println("Delivery by Truck");
	}

}
