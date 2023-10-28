/**
 * 
 */
package veicolo.entity;

/**
 * 
 */
public class Motore extends Componente {
	public Componente componente;
	public short cilindrata;
	public Alimentazione alimentazione;

	/**
	 * @param componente
	 * @param cilindrata
	 * @param alimentazione
	 */
	public Motore(Componente componente, short cilindrata, Alimentazione alimentazione) {
		super();
		this.componente = componente;
		this.cilindrata = cilindrata;
		this.alimentazione = alimentazione;
	}

}
