/**
 * 
 */
package esonero2.store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 */
public class Magazzino<T extends Prodotto> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<String, T> prodotti;

	public Magazzino() {
		prodotti = new HashMap<String, T>();
	}

	public boolean aggiungiProdotto(T prodotto) {
		return prodotti.putIfAbsent(prodotto.getCodice(), prodotto) != null ? true : false;
	}

	public boolean rimuoviProdottoByCodice(String codice) {
		return prodotti.remove(codice) != null ? true : false;
	}

	public long rimuoviProdottiByCosto(String descrizione, Predicate<T> filtro) {
		System.out.print(descrizione + " ");
		return prodotti.values().stream().filter(filtro).count();
	}

	// prodotti ordinata in ordine discendente per costo del prodotto
	// per ordinare abbiamo bisogno solo di: Comparator
	public Collection<Prodotto> getLista(String descrizione, Comparator<T> operazione) {
		System.out.println(descrizione);
		return prodotti.values().stream().sorted(operazione).collect(Collectors.toList());
	}

	// prodotti il cui costo sia inferiore ad un valore specificato
	// prodotti la cui descrizione inizi con un carattere specificato
	// per filtrare abbiamo bisogno di: Predicate
	public Collection<Prodotto> getLista(String descrizione, Predicate<T> filtro) {
		System.out.println(descrizione);
		return prodotti.values().stream().filter(filtro).collect(Collectors.toList());
	}

	// prodotto che contenga il prodotto con il costo più elevato.
	// per filtrare abbiamo bisogno di: BinaryOperator
	public Collection<T> getLista(String descrizione, BinaryOperator<T> operazione) {
		System.out.println(descrizione);
		List<T> temp = new ArrayList<T>();
		temp.add(prodotti.values().stream().reduce(operazione).orElse(null));
		return temp;
	}

	public Collection<T> getCollectionScontati() {
		return prodotti.values().stream().filter(x -> x instanceof ProdottoScontato).collect(Collectors.toList());
	}
}
