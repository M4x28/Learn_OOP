/**
 * 
 */
package veicoli.entity.motocicletta;

import veicoli.entity.Veicolo;

/**
 * Classe Motocicletta che eredita da Veicolo
 * 
 * @author Leonardo Birardi
 */
public class Motocicletta extends Veicolo {

	private TipoGuida tipoGuida;
	private short cilindrata;
	private short velocita = 0;
	private final int MINCILINDRATA = 1000;
	private final int MAXCILINDRATA = 2500;

	/**
	 * @param tipoGuida
	 * @param cilindrata
	 * @param modello
	 * @param annoProduzione
	 */
	public Motocicletta(String modello, int annoProduzione, TipoGuida tipoGuida, short cilindrata) {
		super(modello, annoProduzione);

		this.tipoGuida = tipoGuida;
		if (cilindrata >= MINCILINDRATA && cilindrata <= MAXCILINDRATA) {
			this.cilindrata = cilindrata;
		}
	}

	/*
	 * Simula l'accelerazione della motocicletta
	 */
	public void accelera() {
		velocita++;
		System.out.println(velocita);
	}

	/**
	 * Metodo Base suona clacson
	 */
	@Override
	public void suonaClacson() {
		System.out.println("Clacson motocicletta");
	}

	/**
	 * @return the tipoGuida
	 */
	public TipoGuida getTipoGuida() {
		return tipoGuida;
	}

	/**
	 * @return the cilindrata
	 */
	public short getCilindrata() {
		return cilindrata;
	}

	/**
	 * @return the velocita
	 */
	public short getVelocita() {
		return velocita;
	}

}
