/**
 * 
 */
package test;

import entity.Negozio;
import entity.PrincipioNutritivo;
import entity.ProdottoAlimentare;
import entity.ProdottoElettronico;

/**
 * 
 */
public class TestNegozio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Negozio n = new Negozio();

		ProdottoAlimentare p = new ProdottoAlimentare("1", 10.0, PrincipioNutritivo.GRASSI, 1);
		n.aggiungiProdotto(p);
		p = new ProdottoAlimentare("2", 8.0, PrincipioNutritivo.LIPIDI, -2);
		n.aggiungiProdotto(p);
		ProdottoElettronico pe = new ProdottoElettronico("1", 1.80, 4);
		n.aggiungiProdotto(pe);
		pe = new ProdottoElettronico("3", 10, 20);
		n.aggiungiProdotto(pe);

		System.out.println("Totale: " + n.calcolaTotale());
	}

}
