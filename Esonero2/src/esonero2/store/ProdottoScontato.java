package esonero2.store;

public class ProdottoScontato extends Prodotto {

	private double percentualeSconto;
	private final double MINPERCENTUALESCONTO = .01;
	private final double MAXPERCENTUALESCONTO = .75;

	public ProdottoScontato(String codice, String nome, double costo, double percentualeSconto)
			throws ProdottoException {
		super(codice, nome, costo);

		if (percentualeSconto >= MINPERCENTUALESCONTO && percentualeSconto <= MAXPERCENTUALESCONTO)
			this.percentualeSconto = percentualeSconto;
		else
			throw new ProdottoException(
					"Percentuale Sconto non valida [" + MINPERCENTUALESCONTO + ", " + MAXPERCENTUALESCONTO + "]");

	}

	@Override
	public double calcolaCosto() {
		double prezzo = super.calcolaCosto();
		prezzo -= super.calcolaCosto() * this.percentualeSconto;
		return prezzo;
	}

	public double getPercentualeSconto() {
		return percentualeSconto;
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
		builder.append(", percentualeSconto=");
		builder.append(percentualeSconto);
		builder.append("]");
		return builder.toString();
	}

}
