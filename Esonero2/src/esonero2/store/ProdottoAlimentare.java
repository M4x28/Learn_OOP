/**
 * 
 */
package esonero2.store;

/**
 * 
 */
public class ProdottoAlimentare extends Prodotto {

	private int energia;
	private int tempoConservazione;
	private final int DEFAULT_TEMPO_CONSERVAZIONE = 1;

	/**
	 * @param codice
	 * @param nome
	 * @param costo
	 * @throws ProdottoException
	 */
	public ProdottoAlimentare(String codice, String nome, double costo, int energia, int tempoConservazione)
			throws ProdottoException {
		super(codice, nome, costo);
		if (energia < 0)
			throw new ProdottoException("Energia negativa");
		else
			this.energia = energia;
		if (tempoConservazione <= DEFAULT_TEMPO_CONSERVAZIONE)
			this.tempoConservazione = DEFAULT_TEMPO_CONSERVAZIONE;
		else
			this.tempoConservazione = tempoConservazione;
	}

	@Override
	public double calcolaCosto() {
		if (tempoConservazione <= 2)
			return super.calcolaCosto() * .5;
		else
			return super.calcolaCosto();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Prodotto [codice=");
		builder.append(super.getCodice());
		builder.append(", nome=");
		builder.append(super.getNome());
		builder.append(", costo=");
		builder.append(calcolaCosto());
		builder.append(", energia=");
		builder.append(energia);
		builder.append(", tempoConservazione=");
		builder.append(tempoConservazione);
		builder.append("]");
		return builder.toString();
	}

}
