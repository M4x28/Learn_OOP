/**
 * 
 */
package negozio.test;

import prog2.negozio.entity.Prodotto;
import prog2.negozio.entity.ProdottoAlimentare;
import prog2.negozio.entity.ProdottoElettronico;
import prog2.negozio.entity.ProdottoScontato;

/**
 * Factory Negozio per la creazione di diversi prodotti
 */
public class FactoryProdotto {

	private FactoryProdotto() {
	}

	public static Prodotto getIstanceProdotto(int scelta) {
		Prodotto istance = null;

		switch (scelta) {
		case 1:
			istance = new ProdottoAlimentare("AAA", "Carne", 3.5, "22/11/2023", 10);
			break;
		case 2:
			istance = new ProdottoElettronico("BBB", "Telefono", 100, 24);
			break;
		case 3:
			istance = new ProdottoScontato("CCC", "Buono Sconto", 20, .75);
			break;

		}

		return istance; // Nonostante sia di tipo veicolo, torna comunque l'istanza specifica.
						// faccio up-casting, come da int a double.
	}
}
