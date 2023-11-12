/**
 * 
 */
package entity;

/**
 * 
 */
public class ProdottoElettronico extends Prodotto {

	private int garanzia;

	private final int DEFAULTGARANZIA = 2;
	private final int MINGARANZIA = 2;
	private final int MAXGARANZIA = 24;

	/**
	 * @param codice
	 * @param prezzoIniziale
	 */
	public ProdottoElettronico(String codice, double prezzoIniziale, int garanzia) {
		super(codice, prezzoIniziale);

		if (garanzia < MINGARANZIA && garanzia > MAXGARANZIA)
			this.garanzia = DEFAULTGARANZIA;
		else
			this.garanzia = garanzia;
	}

	@Override
	public double calcolaCosto() {
		if (garanzia > 12)
			return getPrezzoIniziale() * 1.1;
		else
			return getPrezzoIniziale();
	}

}
