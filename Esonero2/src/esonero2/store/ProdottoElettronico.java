package esonero2.store;

public class ProdottoElettronico extends Prodotto {

	private int nMesiGaranzia;

	private final int DEFAULTNMESIGARANZIA = 12;
	private final int MINNMESIGARANZIA = 2;
	private final int MAXNMESIGARANZIA = 24;
	private final double PREZZOGARANZIAPRO = 1.5;
	private final double PREZZOGARANZIAAVANZATA = 1.2;
	private final double PREZZOGARANZIABASE = 1;

	public ProdottoElettronico(String codice, String nome, double costo, int garanzia) throws ProdottoException {
		super(codice, nome, costo);

		if (garanzia >= MINNMESIGARANZIA && garanzia <= MAXNMESIGARANZIA)
			this.nMesiGaranzia = garanzia;
		else
			this.nMesiGaranzia = DEFAULTNMESIGARANZIA;

	}

	@Override
	public double calcolaCosto() {
		double prezzo = super.calcolaCosto();

		if (this.nMesiGaranzia > 12) {
			prezzo += super.calcolaCosto() * PREZZOGARANZIAPRO;
		} else if (this.nMesiGaranzia > 6 && this.nMesiGaranzia <= 12) {
			prezzo += super.calcolaCosto() * PREZZOGARANZIAAVANZATA;
		} else {
			prezzo += super.calcolaCosto() * PREZZOGARANZIABASE;
		}

		return prezzo;
	}

	/**
	 * @return the nMesiGaranzia
	 */
	public int getnMesiGaranzia() {
		return nMesiGaranzia;
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
		builder.append(", mesiGaranzia=");
		builder.append(nMesiGaranzia);
		builder.append("]");
		return builder.toString();
	}

}
