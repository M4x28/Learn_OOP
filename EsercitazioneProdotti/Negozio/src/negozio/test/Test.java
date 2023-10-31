/**
 * 
 */
package negozio.test;

import negozio.entity.Negozio;

/**
 * Classe Test per La creazione di negozi
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Negozio n = new Negozio();

		n.aggiungiProdotto(FactoryProdotto.getIstanceProdotto(3));
		n.aggiungiProdotto(FactoryProdotto.getIstanceProdotto(1));
		n.aggiungiProdotto(FactoryProdotto.getIstanceProdotto(2));

		n.stampaScontrino();
	}

}
