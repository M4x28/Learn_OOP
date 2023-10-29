/**
 * 
 */
package veicoli.entity.motocicletta;

/**
 * Tipo di Guida di Motocicletta
 * 
 * @author Leonardo Birardi
 */
enum TipoGuida {
	MODERATA("Moderata"), BRILLANTE("Brillante"), SPORTIVA("Sportiva");

	private String valore;

	/**
	 * Il costruttore può essere solo privato perché trattandosi di costanti bisogna
	 * mantenere l'immutabilità delle costanti stesse.
	 * 
	 * @param valore
	 */
	private TipoGuida(String valore) {
		this.valore = valore;
	}

	@Override
	public String toString() {
		return valore;
	}

}
