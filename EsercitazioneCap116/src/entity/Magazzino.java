/**
 *
 */
package entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 */
public class Magazzino {
	private HashSet<Prodotto> prodotti;

	public Magazzino() {
		prodotti = new HashSet<>();
	}

	public boolean aggiungiProdotto(Prodotto prodotto) {
		return prodotti.add(prodotto);
	}

	public boolean cancellaProdottiByCosto(double costo) {
		boolean trovato = false;
		Iterator<Prodotto> iterator = prodotti.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getCosto() <= costo) {
				iterator.remove();
				trovato = true;
			}
		}
		return trovato;
	}

	public Set<Prodotto> getProdottiCostoSuperiore(double costo) {
		HashSet<Prodotto> prodottiPrezzo = new HashSet<>();
		Iterator<Prodotto> iterator = prodotti.iterator();
		Prodotto prodotto;

		while (iterator.hasNext()) {
			prodotto = iterator.next();
			if (prodotto.getCosto() >= costo) {
				prodottiPrezzo.add(prodotto);
			}
		}

		Set<Prodotto> prodottiPrezzoImmutabile = Collections.unmodifiableSet(prodottiPrezzo);
		return prodottiPrezzoImmutabile;
	}

	public Prodotto searchByCodice(int codiceProdotto) throws ProdottiException {
		Iterator<Prodotto> iterator = prodotti.iterator();
		Prodotto prodotto, prodottoTrovato = null;

		while (iterator.hasNext()) {
			prodotto = iterator.next();
			if (prodotto.getCodiceProdotto() == codiceProdotto) {
				prodottoTrovato = prodotto;
			}
		}

		if (prodottoTrovato == null)
			ProdottiException.prodottoInesistente();

		return prodottoTrovato;
	}

	// Attenzione a questa
	public SortedSet<Prodotto> getProdottiByNome(String nomeProdotto) {
		TreeSet<Prodotto> prodottiNome = new TreeSet<>(new RelazioneOrdineProdottoNome());
		Iterator<Prodotto> iterator = prodotti.iterator();
		Prodotto prodotto;

		while (iterator.hasNext()) {
			prodotto = iterator.next();
			if (prodotto.getNome().equals(nomeProdotto)) {
				prodottiNome.add(prodotto);
			}
		}

		SortedSet<Prodotto> prodottiOrdinatiImmutabile = Collections.unmodifiableSortedSet(prodottiNome);
		return prodottiOrdinatiImmutabile;
	}

	// Attenzione a questa
	public SortedSet<Prodotto> getProdottiByCostoDecr() {
		TreeSet<Prodotto> prodottiPrezzo = new TreeSet<>(new RelazioneOrdineProdottoPrezzoDec());
		prodottiPrezzo.addAll(prodotti);

		// Attenzione ordino in base al calcolaPrezzo!
		SortedSet<Prodotto> prodottiOrdinatiImmutabile = Collections.unmodifiableSortedSet(prodottiPrezzo);
		return prodottiOrdinatiImmutabile;
	}

	public void stampa() {
		for (Prodotto p : prodotti) {
			System.out.println(p.toString());
		}
	}

}
