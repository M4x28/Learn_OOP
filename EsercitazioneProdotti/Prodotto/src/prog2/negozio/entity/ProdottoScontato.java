/**
 * 
 */
package prog2.negozio.entity;

/**
 * Classe Prodotto Scontato che eredita da Prodotto
 * 
 * @author Leonardo Birardi
 */
public class ProdottoScontato extends Prodotto {

	private double percentualeSconto;

	/**
	 * @param codice
	 * @param descrizione
	 * @param prezzo
	 * @param percentualeSconto
	 */
	public ProdottoScontato(String codice, String descrizione, double prezzo, double percentualeSconto) {
		super(codice, descrizione, prezzo);

		if (percentualeSconto >= Costante.MINPERCENTUALESCONTO && percentualeSconto <= Costante.MAXPERCENTUALESCONTO) {
			this.percentualeSconto = percentualeSconto;
		} else {
			throw new IllegalArgumentException("Percentuale Sconto non valida [" + Costante.MINPERCENTUALESCONTO + ", "
					+ Costante.MAXPERCENTUALESCONTO + "]");
		}
	}

	/**
	 * Override Calcolo Prezzo Scontato
	 */
	@Override
	public double calcolaPrezzo() {
		double prezzo = super.getPrezzo();
		prezzo -= super.getPrezzo() * this.percentualeSconto;
		return prezzo;
	}

	/**
	 * @return the percentualeSconto
	 */
	public double getPercentualeSconto() {
		return percentualeSconto;
	}

}
