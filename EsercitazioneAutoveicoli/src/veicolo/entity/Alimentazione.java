/**
 * 
 */
package veicolo.entity;

/**
 * Rappresenta i differenti tipi di Alimentazione di un Veicolo
 * 
 * @author Leonardo Birardi
 *
 */
public enum Alimentazione {
	// Forniamo a ogni costante di programma un tag identificativo che ci tornerà
	// utile nella stampa

	/**
	 * Alimentazione a Benzina
	 */
	BENZINA("Benzina"),
	/**
	 * Alimentazione Elettrica
	 */
	ELETTRICO("Elettrico"),
	/**
	 * Alimentazione Ibrida
	 */
	IBRIDO("Ibrido"),
	/**
	 * Alimentazione a Diesel
	 */
	DISEL("Diesel"),
	/**
	 * Alimentazione a Gas
	 */
	GAS("Gas");

	private String value;

	/**
	 * In questo caso assegna la stringa associata alla costante alla variabile
	 * value
	 * 
	 * @param value Valore da impostare
	 */
	Alimentazione(String value) {
		this.value = value;
	}

	/**
	 * restituisce il valore dell'alimentazione (il valore, non l'etichetta della
	 * costante)
	 */
	@Override
	public String toString() {
		return value;
	}
}
