/**
 *
 */
package entity;

/**
 *
 */
public class ProdottoAlimentare extends Prodotto {
	private int energia;
	private int tempoConservazione;

	private final int DEFAULTTEMPOCONSERVAZIONE = 1;
	private final int MINTEMPOCONSERVAZIONE = 2;

	/**
	 * @param nome
	 * @param costo
	 * @param codiceProdotto
	 */
	public ProdottoAlimentare(String nome, double costo, int codiceProdotto, int energia, int tempoConservazione)
			throws ProdottiException {
		super(nome, costo, codiceProdotto);

		if (energia < 0)
			ProdottiException.energiaNegativa();
		else
			this.energia = energia;

		if (tempoConservazione < DEFAULTTEMPOCONSERVAZIONE)
			this.tempoConservazione = DEFAULTTEMPOCONSERVAZIONE;
		else
			this.tempoConservazione = tempoConservazione;
	}

	@Override
	public double calcolaCosto() {
		if (tempoConservazione <= MINTEMPOCONSERVAZIONE)
			return getCosto() / 2;
		else
			return getCosto();
	}

}
