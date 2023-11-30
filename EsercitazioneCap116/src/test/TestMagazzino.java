/**
 *
 */
package test;

import entity.Magazzino;
import entity.ProdottiException;
import entity.ProdottoAlimentare;
import entity.ProdottoElettronico;

/**
 * @author Leonardo Birardi
 */
public class TestMagazzino {

	public static void main(String[] args) throws ProdottiException {
		// Scenario 1: Aggiunta di Prodotti
		Magazzino magazzino = new Magazzino();

		try {
			System.out.println(magazzino.aggiungiProdotto(new ProdottoAlimentare("Pasta", 2.5, 150, 5, 1)));
			System.out.println(magazzino.aggiungiProdotto(new ProdottoElettronico("Laptop", 1200, 24, 2)));
			System.out.println(magazzino.aggiungiProdotto(new ProdottoAlimentare("Frutta", 3.0, 120, 3, 3)));
			System.out.println(magazzino.aggiungiProdotto(new ProdottoElettronico("Smartphone", 800, 12, 2)));
			System.out.println(magazzino.aggiungiProdotto(new ProdottoElettronico("ab", 800, 12, 4)));
			System.out.println(magazzino.aggiungiProdotto(new ProdottoAlimentare("Pasta", 7.8, 220, 6, 8)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Scenario 2: Ricerca di un Prodotto per Codice
		try {
			System.out.println(magazzino.searchByCodice(1));
			System.out.println(magazzino.searchByCodice(7));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Scenario 3: Cancellazione di Prodotti per Costo
		System.out.println(magazzino.cancellaProdottiByCosto(2.0));
		System.out.println(magazzino.cancellaProdottiByCosto(1.5));

		// Scenario 4: Elenco di Prodotti per Costo Superiore
		System.out.println(magazzino.getProdottiCostoSuperiore(1.0));

		// Scenario 5: Elenco di Prodotti per Nome
		System.out.println(magazzino.getProdottiByNome("Pasta"));

		// Scenario 6: Elenco di Prodotti per Costo Decrescente
		System.out.println(magazzino.getProdottiByCostoDecr());
	}
}
