/**
 * 
 */
package entity;

/**
 * 
 */
public class ProdottoAlimentare extends Prodotto {
	private PrincipioNutritivo principioNutritivo;
	private int tempoConservazione;

	private final int DEFAULTTEMPOCONSERVAZIONE = 1;

	/**
	 * @param codice
	 * @param prezzoIniziale
	 */
	public ProdottoAlimentare(String codice, double prezzoIniziale, PrincipioNutritivo principioNutritivo,
			int tempoConservazione) {

		super(codice, prezzoIniziale);
		this.principioNutritivo = principioNutritivo;

		if (tempoConservazione < DEFAULTTEMPOCONSERVAZIONE)
			this.tempoConservazione = DEFAULTTEMPOCONSERVAZIONE;
		else
			this.tempoConservazione = tempoConservazione;
	}

	@Override
	public double calcolaCosto() {
		if (tempoConservazione == 1)
			return super.getPrezzoIniziale() / 2;
		else
			return super.getPrezzoIniziale();
	}

}
