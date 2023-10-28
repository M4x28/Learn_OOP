package veicolo.entity;

public abstract class Componente {
	public String produttore;
	public String modello;

	/**
	 * @return the produttore
	 */
	String getProduttore() {
		return produttore;
	}

	/**
	 * @param produttore the produttore to set
	 */
	void setProduttore(String produttore) {
		this.produttore = produttore;
	}

	/**
	 * @return the modello
	 */
	String getModello() {
		return modello;
	}

	/**
	 * @param modello the modello to set
	 */
	void setModello(String modello) {
		this.modello = modello;
	}


}
