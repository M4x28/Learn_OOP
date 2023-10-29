/**
 * 
 */
package veicolo.entity;

/**
 * Rappresenta un motore
 * 
 * @author Leonardo Birardi
 *
 */
public class Motore extends Componente {
	private short cilindrata;
	private Alimentazione alimentazione;

	/**
	 * @param produttore
	 * @param modello
	 * @param cilindrata
	 * @param alimentazione
	 */
	public Motore(String produttore, String modello, short cilindrata, Alimentazione alimentazione) {
		super(produttore, modello);
		this.cilindrata = cilindrata;
		this.alimentazione = alimentazione;
	}

	/**
	 * @return the cilindrata
	 */
	public short getCilindrata() {
		return cilindrata;
	}

	/**
	 * @return the alimentazione
	 */
	public Alimentazione getAlimentazione() {
		return alimentazione;
	}

}
