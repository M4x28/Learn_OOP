package veicolo.entity;

public class Telaio extends Componente {
	public Componente componente;
	public short numero;

	/**
	 * @param componente
	 * @param numero
	 */
	public Telaio(Componente componente, short numero) {
		super();
		this.componente = componente;
		this.numero = numero;
	}

	/**
	 * @return the numero
	 */
	public short getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(short numero) {
		this.numero = numero;
	}

}
