/**
 * 
 */
package veicoli.entity;

/**
 * Classe astratta Bicicletta che eredita Veicolo
 * 
 * @author Leonardo Birardi
 */
public abstract class Bicicletta extends Veicolo {

	private String telaio;
	private short nMarce;
	protected short marciaAttuale; // Servirà alle classi che estenderanno Bicicletta
	protected final short MINMARCIAATTUALE = 1;

	/**
	 * @param telaio
	 * @param nMarce
	 * @param marciaAttuale
	 * @param modello
	 * @param annoProduzione
	 */
	public Bicicletta(String modello, int annoProduzione, String telaio, short nMarce, short marciaAttuale) {
		super(modello, annoProduzione);

		this.telaio = telaio;

		if (nMarce >= Costante.MINMARCE && nMarce <= Costante.MAXMARCE) {
			this.nMarce = nMarce;
		} else {
			throw new IllegalArgumentException(
					"Valore numero marce non in [" + Costante.MINMARCE + ", " + Costante.MAXMARCE + "]");
		}

		if (marciaAttuale >= MINMARCIAATTUALE && marciaAttuale <= nMarce) {
			this.marciaAttuale = marciaAttuale;
		} else {
			throw new IllegalArgumentException("Valore marcia attuale non valido.");
		}
	}

	/*
	 * Metodo astratto per il cambio marcia, definizione della dichiarazione del
	 * metodo, l'implementazione spetterà alle classi che erediteranno Bicicletta.
	 */
	public abstract void cambiaMarcia(short nMarcia);

	/**
	 * Metodo Base suona clacson per i tipi Bicicletta
	 */
	@Override
	public abstract void suonaClacson();

	/**
	 * @return the telaio
	 */
	public String getTelaio() {
		return telaio;
	}

	/**
	 * @param telaio the telaio to set
	 */
	public void setTelaio(String telaio) {
		this.telaio = telaio;
	}

	/**
	 * @return the nMarce
	 */
	public short getnMarce() {
		return nMarce;
	}

	/**
	 * @return the marciaAttuale
	 */
	public short getMarciaCorrente() {
		return marciaAttuale;
	}

}
