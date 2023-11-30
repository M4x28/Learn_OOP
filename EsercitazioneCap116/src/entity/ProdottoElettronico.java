/**
 *
 */
package entity;

/**
 *
 */
public class ProdottoElettronico extends Prodotto {
	private int garanzia;

	private final int DEFAULTGARANZIA = 12;
	private final int MINGARANZIA = 2;
	private final int MAXGARANZIA = 24;

	/**
	 * @param nome
	 * @param costo
	 * @param codiceProdotto
	 */
	public ProdottoElettronico(String nome, double costo, int codiceProdotto, int garanzia) throws ProdottiException {
		super(nome, costo, codiceProdotto);

		if (garanzia >= MINGARANZIA && garanzia <= MAXGARANZIA)
			this.garanzia = garanzia;
		else
			this.garanzia = DEFAULTGARANZIA;
	}

	@Override
	public double calcolaCosto() {
		if (garanzia > DEFAULTGARANZIA)
			return getCosto() * 1.1;
		else
			return getCosto();
	}

}
