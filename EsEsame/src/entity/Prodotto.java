/**
 * 
 */
package entity;

import java.util.Objects;

/**
 * 
 */
public abstract class Prodotto {
	private String codice;
	private double prezzoIniziale;

	private final double DEFAULTPREZZOINIZIALE = 0.0;

	/**
	 * @param codice
	 * @param prezzoIniziale
	 */
	public Prodotto(String codice, double prezzoIniziale) {
		if (prezzoIniziale < 0)
			this.prezzoIniziale = DEFAULTPREZZOINIZIALE;
		else
			this.prezzoIniziale = prezzoIniziale;

		if (!codice.isBlank())
			this.codice = codice;
		else
			throw new IllegalArgumentException("Il codice non può essere vuoto");
	}

	public abstract double calcolaCosto();

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @return the prezzoIniziale
	 */
	public double getPrezzoIniziale() {
		return prezzoIniziale;
	}

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
