/**
 * 
 */
package entity;

import java.util.ArrayList;

/**
 * 
 */
public class Negozio {
	private ArrayList<Prodotto> prodotti;

	/**
	 * 
	 */
	public Negozio() {
		this.prodotti = new ArrayList<Prodotto>();
	}

	/**
	 * @param prodotti
	 */
	public Negozio(ArrayList<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public void aggiungiProdotto(Prodotto p) {
		if (!prodotti.contains(p))
			prodotti.add(p);
	}

	public double calcolaTotale() {
		double totale = 0.0;
		for (Prodotto prodotto : prodotti) {
			totale += prodotto.calcolaCosto();
			System.out.println(prodotto.getCodice());
			System.out.println(prodotto.calcolaCosto());
		}
		return totale;
	}

}
