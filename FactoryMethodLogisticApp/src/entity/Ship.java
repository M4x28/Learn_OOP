/**
 * 
 */
package entity;

/**
 * Classe Barca che implementa l'interfaccia Trasporto con tutti i suoi metodi
 * 
 * @author Leonardo Birardi
 */
public class Ship implements Transport {
	
	@Override
	public void deliver() {
		System.out.println("Delivery by Ship");
	}

}
