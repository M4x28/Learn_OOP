/**
 * 
 */
package veicoli.entity;

/**
 * Classe Automobile eredita attributi della classe astratta Veicolo
 * 
 * @author Leonardo Birardi
 */
public class Automobile extends Veicolo {

	private int nPorte;
	private double consumoBasePerKm;

	/**
	 * @param modello
	 * @param annoProduzione
	 */
	public Automobile(String modello, int annoProduzione, int nPorte, double consumoBasePerKm) {
		super(modello, annoProduzione);

		if (nPorte >= Costante.MINPORTE && nPorte <= Costante.MAXPORTE) {
			this.nPorte = nPorte;
		} else {
			throw new IllegalArgumentException(
					"Numero porte non in [" + Costante.MINPORTE + ", " + Costante.MAXPORTE + "]");
		}

		if (consumoBasePerKm >= Costante.MINCONSUMOBASEPERKM && consumoBasePerKm <= Costante.MAXCONSUMOBASEPERKM) {
			this.consumoBasePerKm = consumoBasePerKm;
		} else {
			throw new IllegalArgumentException("Consumo base per km non in [" + Costante.MINCONSUMOBASEPERKM + ", "
					+ Costante.MAXCONSUMOBASEPERKM + "]");
		}
	}

	/**
	 * Calcolo Consumo auto
	 * 
	 * @param kmPercorsi
	 * @return
	 */
	public double calcolaConsumo(double kmPercorsi) {
		double consumo = kmPercorsi * consumoBasePerKm;

		if (calcoloConsumoMaggiorato())
			consumo += consumo * Costante.PERCENTUALEMAGGIORAZIONE;
		return consumo;

	}

	/**
	 * Maggiorazione sul calcolo del consumo se l'auto è stata prodotta prima di una
	 * data predefinita. Single Responsibility Principle
	 * 
	 * @return boolean
	 */
	private boolean calcoloConsumoMaggiorato() {
		boolean maggiorazione = this.getAnnoProduzione() < Costante.MINMAGGIORAZIONE ? true : false;
		return maggiorazione;
	}

	/**
	 * @return the nPorte
	 */
	public int getnPorte() {
		return nPorte;
	}

	/**
	 * @param nPorte the nPorte to set
	 */
	public void setnPorte(int nPorte) {
		this.nPorte = nPorte;
	}

	/**
	 * @param consumoBasePerKm the consumoBasePerKm to set
	 */
	public void setConsumoBasePerKm(double consumoBasePerKm) {
		this.consumoBasePerKm = consumoBasePerKm;
	}

	/**
	 * Metodo Base suona clacson
	 */
	@Override
	public void suonaClacson() {
		System.out.println("Clacson automobile");
	}

}
