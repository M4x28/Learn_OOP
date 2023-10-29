package veicolo.entity;

/**
 * Fattorizza gli elementi comuni di un qualunque componente del Veicolo (in
 * base ai requisiti)
 * 
 * @author Leonardo Birardi
 *
 */
public abstract class Componente {

	private String produttore;
	private String modello;

	/**
	 * @param produttore
	 * @param modello
	 */
	Componente(String produttore, String modello) {
		super();
		this.produttore = produttore;
		this.modello = modello;
	}

	/**
	 * @return the produttore
	 */
	String getProduttore() {
		return produttore;
	}

	/**
	 * @return the modello
	 */
	String getModello() {
		return modello;
	}

}
