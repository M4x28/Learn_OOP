package veicolo.entity;

/**
 * Rappresenta un telaio di un Veicolo
 * 
 * @author Leonardo Birardi
 *
 */
public class Telaio extends Componente {

	private short numero;

	/**
	 * @param produttore
	 * @param modello
	 * @param componente
	 * @param numero
	 */
	public Telaio(String produttore, String modello, short numero) {
		super(produttore, modello);
		this.numero = numero;
	}

	/**
	 * @return the numero
	 */
	public short getNumero() {
		return numero;
	}

}
