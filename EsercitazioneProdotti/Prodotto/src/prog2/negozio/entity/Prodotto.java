/**
 * 
 */
package prog2.negozio.entity;

import java.util.Objects;

/**
 * Classe astratta Prodotto
 * 
 * @author Leonardo Birardi
 */
public abstract class Prodotto {
	private String codice;
	private String descrizione;
	private double prezzo;

	/**
	 * @param codice
	 * @param descrizione
	 * @param prezzo
	 */
	public Prodotto(String codice, String descrizione, double prezzo) {
		this.codice = codice;
		this.descrizione = descrizione;
		if (prezzo > Costante.MINPREZZOPRODOTTO) {
			this.prezzo = prezzo;
		} else {
			throw new IllegalArgumentException("Il prezzo inserito on è valido");
		}
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @return the prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * Metodo astratto da implementare nelle classi per il calcolo delle classi
	 * 
	 * @return double
	 */
	public abstract double calcolaPrezzo();

	@Override
	public int hashCode() {
		return Objects.hash(codice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Prodotto)) {
			return false;
		}
		Prodotto other = (Prodotto) obj;
		return Objects.equals(codice, other.codice);
	}

}
