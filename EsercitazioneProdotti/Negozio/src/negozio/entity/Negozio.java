/**
 * 
 */
package negozio.entity;

import java.util.ArrayList;

import prog2.negozio.entity.Prodotto;

/**
 * Classe Negozio
 * 
 * @author Leonardo Birardi
 */
public class Negozio {
	ArrayList<Prodotto> prodotti;

	/**
	 * Costruttore negozio
	 */
	public Negozio() {
		prodotti = new ArrayList<Prodotto>();
	}

	/**
	 * Aggiungi Prodotto all'Array List del negozio
	 * 
	 * @param prodotto
	 */
	public boolean aggiungiProdotto(Prodotto prodotto) {
		if (!prodotti.contains(prodotto)) {
			prodotti.add(prodotto);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calcola Totale Prodotti nel Negozio
	 * 
	 * @return
	 */
	private double calcolaTotale() {
		double totale = 0.0;
		for (Prodotto prodotto : prodotti) {
			totale += prodotto.getPrezzo();
		}
		return totale;
	}

	/*
	 * Metodo per la Stampa dello scontrino
	 */
	public void stampaScontrino() {
		System.out.println("-----------------------------");
		for (Prodotto prodotto : prodotti) {
			System.out.println("-   " + prodotto.getDescrizione() + "   " + prodotto.getPrezzo() + "€    -");
		}
		System.out.println("-   Totale: " + calcolaTotale() + "€    -");
		System.out.println("----------------------------");
	}

}
