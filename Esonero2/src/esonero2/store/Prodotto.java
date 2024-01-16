/**
 * 
 */
package esonero2.store;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 */
public class Prodotto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codice;
	private String nome;
	private double costo;

	/**
	 * @param codice
	 * @param nome
	 * @param costo
	 * @throws ProdottoException
	 */
	public Prodotto(String codice, String nome, double costo) throws ProdottoException {
		if (codice.isBlank())
			throw new ProdottoException("Codice Invalido");
		else
			this.codice = codice;

		this.nome = nome;

		if (costo < 0)
			throw new ProdottoException("Costo negativo");
		else
			this.costo = costo;
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @return Nome del prodotto.
	 */
	public String getNome() {
		return nome;
	}

	/*
	 * Metodo per il calcolo del prezzo
	 */
	public double calcolaCosto() {
		return costo;
	};

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Prodotto [codice=");
		builder.append(codice);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", costo=");
		builder.append(costo);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(codice, costo, nome);
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
		return Objects.equals(codice, other.codice)
				&& Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo)
				&& Objects.equals(nome, other.nome);
	}

}
