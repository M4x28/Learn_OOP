/**
 * 
 */
package prog2.negozio.entity;

/**
 * Classe Prodotto Elettronico che eredita da Prodotto
 * 
 * @author Leonardo Birardi
 */
public class ProdottoElettronico extends Prodotto {

	private int nMesiGaranzia;

	/**
	 * @param codice
	 * @param descrizione
	 * @param prezzo
	 * @param garanzia    nMesiGaranzia
	 */
	public ProdottoElettronico(String codice, String descrizione, double prezzo, int garanzia) {
		super(codice, descrizione, prezzo);
		if (garanzia >= Costante.MINNMESIGARANZIA && garanzia <= Costante.MAXNMESIGARANZIA) {
			this.nMesiGaranzia = garanzia;
		} else {
			this.nMesiGaranzia = Costante.DEFAULTNMESIGARANZIA;
		}
	}

	/**
	 * Calcola Prezzo di un Prodotto Elettronico
	 */
	@Override
	public double calcolaPrezzo() {
		double prezzo = super.getPrezzo();

		if (this.nMesiGaranzia > 12) {
			prezzo -= super.getPrezzo() * Costante.PREZZOGARANZIAPRO;
		} else if (this.nMesiGaranzia > 6 && this.nMesiGaranzia <= 12) {
			prezzo -= super.getPrezzo() * Costante.PREZZOGARANZIAAVANZATA;
		} else {
			prezzo -= super.getPrezzo() * Costante.PREZZOGARANZIABASE;
		}

		return prezzo;
	}

	/**
	 * @return the nMesiGaranzia
	 */
	public int getnMesiGaranzia() {
		return nMesiGaranzia;
	}

}
