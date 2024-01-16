/**
 * 
 */
package esonero2.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import esonero2.store.Magazzino;
import esonero2.store.Prodotto;
import esonero2.store.ProdottoAlimentare;
import esonero2.store.ProdottoElettronico;
import esonero2.store.ProdottoException;
import esonero2.store.ProdottoScontato;

/**
 * 
 */
public class MagazzinoTest {

	public static void main(String[] args) {
		Magazzino<Prodotto> magazzino = new Magazzino<Prodotto>();
		aggiungiProdottiAlMagazzino(magazzino);

		// Prodotti ordinati discendente per costo
		Comparator<Prodotto> comparatordiscentComparator = Comparator.comparing(Prodotto::calcolaCosto)
				.thenComparing(Prodotto::getCodice).reversed();
		magazzino.getLista("Prodotti ordinati desc:", comparatordiscentComparator).forEach(System.out::println);
		System.out.println("\n");

		// Prodotti il cui costo sia inferiore ad un valore specificato
		int valSpecificato = 30;
		Predicate<Prodotto> valoreSpecificatoPredicate = x -> {
			return x.calcolaCosto() < valSpecificato ? true : false;
		};
		magazzino.getLista("Prodotti costo minore di 30:", valoreSpecificatoPredicate).forEach(System.out::println);
		System.out.println("\n");

		// Prodotti la cui descrizione inizi con un carattere specificato
		String carSpecificato = "P";
		Predicate<Prodotto> carattereSpecificatoPredicate = x -> {
			return x.getNome().startsWith(carSpecificato);
		};
		magazzino.getLista("Prodotti nome inizia con P:", carattereSpecificatoPredicate).forEach(System.out::println);
		System.out.println("\n");

		// Prodotto con costo maggiore
		BinaryOperator<Prodotto> maggioreBinaryOperator = BinaryOperator.maxBy(comparatordiscentComparator.reversed());
		magazzino.getLista("Prodotto maggiore:", maggioreBinaryOperator).forEach(System.out::println);
		System.out.println("\n");

		// rimuovi Prodotti by Costo
		double costoSpecificato = 1.0;
		Predicate<Prodotto> rimuoviPredicate = x -> {
			return x.calcolaCosto() == costoSpecificato ? false : true;
		};
		System.out.println(magazzino.rimuoviProdottiByCosto("N Prodotti che non costano 1.0:", rimuoviPredicate));
		System.out.println("\n");

		serializza(magazzino, "mappa.dat");
		try {
			deserializza("mappa.dat");
		} catch (IOException e) {
			// cane
		}

	}

	// Aggiungere un prodotto al magazzino
	private static void aggiungiProdotto(Magazzino<Prodotto> magazzino, String codice, String descrizione,
			double costo) {
		try {
			Prodotto prodotto = new Prodotto(codice, descrizione, costo);
			magazzino.aggiungiProdotto(prodotto);
		} catch (ProdottoException e) {
			System.err.println(e.getMessage());
		}
	}

	// Aggiungere un prodotto alimentare al magazzino
	private static void aggiungiProdottoAlimentare(Magazzino<Prodotto> magazzino, String codice, String descrizione,
			double costo, int scadenza, int temperaturaConservazione) {
		try {
			ProdottoAlimentare prodottoAlimentare = new ProdottoAlimentare(codice, descrizione, costo, scadenza,
					temperaturaConservazione);
			magazzino.aggiungiProdotto(prodottoAlimentare);
		} catch (ProdottoException e) {
			System.err.println(e.getMessage());
		}
	}

	// Aggiungere un prodotto alimentare al magazzino
	private static void aggiungiProdottoElettronico(Magazzino<Prodotto> magazzino, String codice, String descrizione,
			double costo, int garanzia) {
		try {
			ProdottoElettronico prodottoElettronico = new ProdottoElettronico(codice, descrizione, costo, garanzia);
			magazzino.aggiungiProdotto(prodottoElettronico);
		} catch (ProdottoException e) {
			System.err.println(e.getMessage());
		}
	}

	// Aggiungere un prodotto alimentare al magazzino
	private static void aggiungiProdottoScontato(Magazzino<Prodotto> magazzino, String codice, String descrizione,
			double costo, double percentualeSconto) {
		try {
			ProdottoScontato prodottoScontato = new ProdottoScontato(codice, descrizione, costo, percentualeSconto);
			magazzino.aggiungiProdotto(prodottoScontato);
		} catch (ProdottoException e) {
			System.err.println(e.getMessage());
		}
	}

	// Aggiungere prodotti al magazzino
	private static void aggiungiProdottiAlMagazzino(Magazzino<Prodotto> magazzino) {
		aggiungiProdotto(magazzino, "G001", "Libro", 20.0);
		aggiungiProdotto(magazzino, "G002", "Orologio", 100.0);
		aggiungiProdotto(magazzino, "G002", "Orologio", 100.0);
		aggiungiProdottoAlimentare(magazzino, "A000", "Mela", 1.0, 40, 7);
		aggiungiProdottoAlimentare(magazzino, "A001", "Mela", 1.0, -2, 7);
		aggiungiProdottoAlimentare(magazzino, "A002", "Pane", 2.0, 80, 2);
		aggiungiProdottoElettronico(magazzino, "A003", "Telefono", 200.0, 24);
		aggiungiProdottoScontato(magazzino, "A004", "Vestito", 30.0, .6);
	}

	public static void serializza(Object a, String nomeFile) {
		// Serializza e scrive l'oggetto nel file
		try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
			outStream.writeObject(a);
			System.out.println("Serializzazione completata con successo: " + nomeFile);
		} catch (IOException e) {
			System.err.println("Errore durante la scrittura del file: " + e.getMessage());
		}
	}

	public static Object deserializza(String nomeFile) throws IOException {
		Object obj = null;

		// Deserializza l'oggetto dal file
		try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(nomeFile))) {
			obj = inStream.readObject();
			System.out.println("Deserializzazione completata con successo da: " + nomeFile);
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Errore durante la lettura del file: " + e.getMessage());
		}

		return obj;
	}

}
