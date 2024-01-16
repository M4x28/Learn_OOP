/**
 * 
 */
package base;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// stream = elenco di elementi
		// stream pipeline = elenco di elementi su cui vengono applicate delle
		// operazioni

		// IntStream Data Source
		// rangeClosed intermediate operation
		// sun final operation (metodo statistico di riduzione)
		Object a = IntStream.rangeClosed(1, 10).sum();
		System.out.println(a);

		// map applica a ogni valore dei dati una lambda expression
		// -> arrow token
		// omissione tipo perchè il compilatore si occupa di infierire sul tipo (genera
		// errore in caso di più possibilitàà di tipi)
		// Se nel body abbiamo una sola espressione => posssiamo rimuovere {} e ;
		// Se tra la lista dei parametri ne abbiamo SOLO 1 => possiamo rimuovere ()
		// (int x) -> {return x * 2;}
		a = IntStream.rangeClosed(1, 10).map(x -> x * 2).sum();
		System.out.println(a);

		// Le operazioni intermedie sono di tipo LAZY(si fermano alla prima occorrenza)
		// e copiano i risultati in un nuovo stream Object

		// Finding sum of all elements
		List<Integer> array = Arrays.asList(-2, 0, 8, 6, 4);
		// 4 è il IDENTITY VALUE della variabile di riferimento (opzionale)
		int sum = array.stream().reduce(4, (element1, element2) -> element1 + element2);
		System.out.println(sum);

		// Uso di filter
		// Somma *3 dei numeri nel range 1-10
		a = IntStream.rangeClosed(1, 10).filter(x -> x % 2 == 0).map(x -> x * 3).sum();
		System.out.println(a);

		// Il Risultato di OGNI OPERAZIONE INTERMADIA è un NUOVO STREAM

		// esempio METODO DI RIFERIMENTO utilizza una classe di base per richiamare un
		// metodo appartenente alla classe stessa, il compilatore trasforma la chiamata
		// in una lambda expression
		array.stream().forEach(System.out::println);

		// collect è un metodo terminale
		// Il compilatore col map infierisce il tipo dal data source!
		// se lo stream del map ha un tipo diverso dallo data source utilizzare
		// maptoDouble, mapToLong, mpaToObj
		a = IntStream.rangeClosed(1, 10).mapToObj(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(a);

		// i metodi statistici terminali ritornano degli oggetti non dei tipi primitivi!
		a = IntStream.rangeClosed(1, 10).min().getAsInt();
		System.out.println(a);

		int[] values = { 3, 7, 1, 5, 2 };
		IntStream.of(values).sorted().forEach(System.out::println);

		// il metodo orElse() richiama getAsDouble prima e nel caso ritorna il valore
		// specificato per evitare di sollevare eccezioni
		int[] emptyValues = {};
		a = IntStream.of(emptyValues).average().orElse(-1);
		System.out.println(a);

		a = IntStream.of(values).summaryStatistics().getMin();
		System.out.println(a);

		// Collectors.toSet() si basa su un HashSet quando ritrovi gli elementi ordinati
		// significa che l'oggetto ha specificato il metodo hashCode()
		Integer[] valuess = { 3, 7, 1, 5, 2, 2 };
		Set<Integer> setIntegers = Arrays.stream(valuess).collect(Collectors.toUnmodifiableSet());
		System.out.println(setIntegers);

		// Conversione intStream to Stream<Integer> using boxed()
		Stream<Integer> b = IntStream.range(1, 10).boxed();
		b.forEach(System.out::print);

		// Frequenza dei risultati nel lancio di 2 dadi non truccati
		SecureRandom secureRandom = new SecureRandom();
		long numberOfRolls = 100;

		// Simula il lancio dei dadi e conta le occorrenze
		Map<Integer, Long> occurrencesMap = LongStream.range(0, numberOfRolls).mapToObj(
				i -> secureRandom.ints(1, 7).findFirst().getAsInt() + secureRandom.ints(1, 7).findFirst().getAsInt())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		// Visualizza le occorrenze utilizzando la mappa
		System.out.println("\nOccorrenze utilizzando la mappa:");
		occurrencesMap
				.forEach((summ, occurrences) -> System.out.println("Somma " + summ + ": " + occurrences + " volte"));

		// --- Esercizi ---

		// Es1 somma di 2 interi
		BinaryOperator<Integer> sommaBinaryOperator = (Integer x, Integer y) -> {
			return x + y;
		};
		System.out.println(sommaBinaryOperator.apply(2, 3));

		// Es2 verificare stringa vuota
		Predicate<String> isEmptyString = str -> str.isEmpty();
		System.out.println(isEmptyString.test(""));

		// Es3 convertire una liste di stringhe in maiuscolo
		UnaryOperator<String> convertiMaiuscolOperator = str -> {
			return str.toUpperCase();
		};
		final String[] colori = { "arancione", "azzurro", "beige", "blu", "grigio", "lilla", "marrone", "nero", "rosa",
				"rosso", "verde acqua", "verde chiaro", "verde oliva", "verde scuro", "viola melanzana", "viola prugna",
				"fucsia", "crema", "jeans", "bianco", "giallo tenue", "rosa salmone" };
		List<String> listaStringheList = Arrays.asList(colori);
		listaStringheList.stream().map(convertiMaiuscolOperator).forEach(System.out::println);

		// Es4 filtro per filtrare i numeri pari/dispari
		Predicate<Integer> filtraPariPredicate = p -> (p % 2 == 0);
		Predicate<Integer> filtradispariPredicate = d -> (d % 2 == 1);
		Set<Integer> pariStream = Arrays.stream(valuess).filter(filtradispariPredicate).collect(Collectors.toSet());
		Set<Integer> dispariStream = Arrays.stream(valuess).filter(filtraPariPredicate).collect(Collectors.toSet());
		System.out.println("Dispari: " + pariStream.toString());
		System.out.println("Pari: " + dispariStream.toString());

		// Es5 ordinare un elenco di stringhe in ordine alfabetico
		listaStringheList = listaStringheList.stream().sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList());
		System.out.println(listaStringheList.toString());

		// Es6 trovare la media di un elenco di double
		DoubleSupplier fornitoreDoubleSupplier = () -> {
			return Math.random() * 100;
		};
		double doubles = DoubleStream.generate(fornitoreDoubleSupplier).limit(7).average().getAsDouble();
		System.out.println(doubles);

		// Es7 rimuovere i duplicati da un elenco di numeri interi
		Arrays.stream(valuess).distinct().forEach(System.out::println);

		// Es8 calcolare il fattoriale di un dato numero
		LongUnaryOperator factorial = n -> {
			long result = 1;
			for (long i = 1; i <= n; i++) {
				result *= i;
			}
			return result;
		};
		System.out.println("Fattoriale di 10: " + factorial.applyAsLong(10));

		// Es10 concatenare due stringhe
		BinaryOperator<String> concatenaStr = (x, y) -> {
			return x.concat(y);
		};
		System.out.println("Concatenazione: " + concatenaStr.apply("ciao ", "Carlo"));

		// Es11 trovare le statistiche di un insieme di interi
		IntSummaryStatistics c = IntStream.rangeClosed(0, 50).summaryStatistics();
		System.out.println("stats: " + c.toString());

		// Es12 moltiplicare e sommare tutti gli elementi in un elenco di numeri interi
		Arrays.stream(values).sum();
		Arrays.stream(values).reduce(0, (x, y) -> {
			return x + y;
		});

		// Es personalizzato Abbinamento Colori Vestiti
		Map<String, Set<String>> abbinamentiMap = new HashMap<String, Set<String>>();

		Set<String> defaultSet = new HashSet<>(Arrays.asList("Nessuna Coincidenza"));
		Set<String> abbArancioneSet = new HashSet<>(
				Arrays.asList("jeans", "crema", "giallo tenue", "verde scuro", "nero", "bianco", "grigio", "marrone"));
		Set<String> abbBeigeSet = new HashSet<>(
				Arrays.asList("jeans", "crema", "marrone", "nero", "viola prugna", "verde scuro", "rosa", "azzurro"));

		Set<String> abbAzzurroSet = new HashSet<>(
				Arrays.asList("jeans", "crema", "nero", "rosa", "blu", "beige", "bianco"));
		Set<String> abbBluSet = new HashSet<>(
				Arrays.asList("jeans", "rosso", "giallo tenue", "rosa salmone", "salmone scuro", "verde acqua", "rosa",
						"azzurro", "beige", "crema", "grigio", "lilla", "bianco", "fucsia", "celeste"));
		Set<String> abbGrigioSet = new HashSet<>(Arrays.asList("jeans", "giallo tenue", "celeste", "blu", "viola",
				"verde chiaro", "verde scuro", "magenta", "lilla", "rosa", "azzurro", "fucsia"));
		Set<String> abbLillaSet = new HashSet<>(Arrays.asList("jeans", "bianco", "grigio", "nero", "blu"));
		Set<String> abbMarroneSet = new HashSet<>(
				Arrays.asList("jeans", "giallo tenue", "celeste", "nero", "viola prugna", "verde acqua", "verde scuro",
						"rosa salmone", "bianco", "rosa", "azzurro", "bianco", "beige"));
		Set<String> abbNeroSet = new HashSet<>(Arrays.asList("rosso", "giallo", "celeste", "blu", "viola melanzana",
				"viola prugna", "crema", "beige", "verde chiaro", "verde scuro", "verde acqua", "fucsia", "lilla",
				"rosa", "azzurro", "celeste", "arancione", "rosa salmone", "bianco"));
		Set<String> abbRosaSet = new HashSet<>(
				Arrays.asList("jeans", "crema", "marrone", "blu", "beige", "verde scuro", "nero", "bianco", "grigio"));
		Set<String> abbRossoSet = new HashSet<>(Arrays.asList("jeans", "blu", "nero", "grigio", "bianco", "crema"));

		abbinamentiMap.putIfAbsent("arancione", abbArancioneSet);
		abbinamentiMap.putIfAbsent("beige", abbBeigeSet);
		abbinamentiMap.putIfAbsent("azzurro", abbAzzurroSet);
		abbinamentiMap.putIfAbsent("blu", abbBluSet);
		abbinamentiMap.putIfAbsent("grigio", abbGrigioSet);
		abbinamentiMap.putIfAbsent("lilla", abbLillaSet);
		abbinamentiMap.putIfAbsent("marrone", abbMarroneSet);
		abbinamentiMap.putIfAbsent("nero", abbNeroSet);
		abbinamentiMap.putIfAbsent("rosa", abbRosaSet);
		abbinamentiMap.putIfAbsent("rosso", abbRossoSet);

		String primoColoreSceltoUtente = "arancione";
		String secondoColoreSceltoUtente = "nero";

		if (abbinamentiMap.getOrDefault(primoColoreSceltoUtente, defaultSet).contains(secondoColoreSceltoUtente)) {
			abbArancioneSet.stream().filter(color -> abbBeigeSet.stream().anyMatch(bc -> color.equalsIgnoreCase(bc)))
					.forEach(System.out::println);
		}

	}

}
