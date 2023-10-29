/**
 * 
 */
package veicoli.entity;

/**
 * Classe concreta Bicicletta Elettrica che eredita Bicicletta con
 * implementazione dei metodi dichiarati nella classe Bicicletta.
 * 
 * @author Leonardo Birardi
 */
public class BiciclettaElettrica extends Bicicletta {

	private float autonomiaBatteria;

	/**
	 * @param modello
	 * @param annoProduzione
	 * @param telaio
	 * @param nMarce
	 * @param marciaAttuale
	 */
	public BiciclettaElettrica(String modello, int annoProduzione, String telaio, short nMarce, short marciaAttuale,
			float autonomiaBatteria) {
		super(modello, annoProduzione, telaio, nMarce, marciaAttuale);
		if (autonomiaBatteria > 0)
			this.autonomiaBatteria = autonomiaBatteria;
	}

	/**
	 * Implementazione metodo Cambia Marcia per la Bici Elettrica
	 * 
	 * @param nMarcia
	 */
	@Override
	public void cambiaMarcia(short nMarcia) {
		if (nMarcia <= getnMarce() && nMarcia >= super.MINMARCIAATTUALE) {
			while (nMarcia != super.getMarciaCorrente()) {
				if (nMarcia > super.getMarciaCorrente()) {
					this.marciaAttuale--;
				} else {
					this.marciaAttuale++;
				}
				System.out.println("Marcia inserita: " + super.getMarciaCorrente());
			}
		}

	}

	/*
	 * Metodo Suona Clacson Implementato per la Bici Elettrica
	 */
	@Override
	public void suonaClacson() {
		System.out.println("Suono bici elettrica");
	}

	/**
	 * @return the autonomiaBatteria
	 */
	public float getAutonomiaBatteria() {
		return autonomiaBatteria;
	}

}
