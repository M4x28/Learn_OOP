package entity;

/**
 * Classe astratta Creatore Logistica per la creazione di nuove istanze e l'utilizzo di esse senza conoscere il tipo dell'oggetto concreto
 * 
 * @author Leonardo Birardi
 */
public abstract class AbstractCreatorLogistics {
	
	public void planDelivery() {
		Transport t = createTransport();
		t.deliver();
	}
	
	/**
	 * Dichiarazione metodo createTransport che troverà implementazione nelle classi che estendono questa classe
	 * @return Transport istanza di Transport per la creazione concreta
	 */
	public abstract Transport createTransport();
}
