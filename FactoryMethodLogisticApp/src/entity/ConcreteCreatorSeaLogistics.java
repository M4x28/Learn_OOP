/**
 * 
 */
package entity;

/**
 * Classe Concreta per la creazione della Logistica stradale, questa ritorna un istanza di tipo Ship
 * 
 * @author Leonardo Birardi
 */
public class ConcreteCreatorSeaLogistics extends AbstractCreatorLogistics {

	@Override
	public Transport createTransport() {
		return new Ship();
	}

}
