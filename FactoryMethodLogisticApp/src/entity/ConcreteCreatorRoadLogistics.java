/**
 * 
 */
package entity;

/**
 * Classe Concreta per la creazione della Logistica stradale, questa ritorna un istanza di tipo Truck
 * 
 * @author Leonardo Birardi
 */
public class ConcreteCreatorRoadLogistics extends AbstractCreatorLogistics {

	@Override
	public Transport createTransport() {
		return new Truck();
	}

}
