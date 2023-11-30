/**
 *
 */
package entity;

import java.util.Objects;

/**
 *
 */
public abstract class Prodotto {
	private String nome;
	private double costo;
	private int codiceProdotto;

	/**
	 * @param nome
	 * @param costo
	 * @param codiceProdotto
	 */
	public Prodotto(String nome, double costo, int codiceProdotto) throws ProdottiException {
		if (nome.isBlank() || nome.length() <= 3)
			ProdottiException.nomeErrore();
		else
			this.nome = nome;

		if (costo < 0)
			ProdottiException.costoNegativo();
		else
			this.costo = costo;

		this.codiceProdotto = codiceProdotto;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the costo
	 */
	public double getCosto() {
		return costo;
	}

	/**
	 * @return the codiceProdotto
	 */
	public int getCodiceProdotto() {
		return codiceProdotto;
	}

	public abstract double calcolaCosto();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Prodotto [nome=");
		builder.append(nome);
		builder.append(", costo=");
		builder.append(costo);
		builder.append(", codiceProdotto=");
		builder.append(codiceProdotto);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceProdotto);
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
		return codiceProdotto == other.codiceProdotto;
	}

}
