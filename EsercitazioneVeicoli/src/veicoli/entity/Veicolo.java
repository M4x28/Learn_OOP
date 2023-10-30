/**
 * 
 */
package veicoli.entity;

import java.time.Year;

/**
 * Classe astratta Veicolo
 * 
 * @author Leonardo Birardi
 */
public abstract class Veicolo {

	private String modello;
	private int annoProduzione;

	/**
	 * @param modello
	 * @param annoProduzione
	 */
	public Veicolo(String modello, int annoProduzione) {
		this.modello = modello;
		Year thisYear = Year.now();

		if (annoProduzione >= Costante.MINANNOPRODUZIONE && annoProduzione <= thisYear.getValue()) {
			this.annoProduzione = annoProduzione;
		} else {
			throw new IllegalArgumentException(
					"Anno di Produzione non in [" + Costante.MINANNOPRODUZIONE + ", " + thisYear.getValue() + "]");
		}
	}

	/**
	 * @return the modello
	 */
	public String getModello() {
		return modello;
	}

	/**
	 * @return the annoProduzione
	 */
	public int getAnnoProduzione() {
		return annoProduzione;
	}

	/**
	 * Metodo Base suona clacson
	 */
	public void suonaClacson() {
		System.out.println("Clacson Veicolo");
	}

}
