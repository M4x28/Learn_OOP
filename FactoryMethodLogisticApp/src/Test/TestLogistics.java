/**
 * 
 */
package Test;

import java.util.ArrayList;
import java.util.Random;

import entity.AbstractCreatorLogistics;
import entity.ConcreteCreatorRoadLogistics;
import entity.ConcreteCreatorSeaLogistics;

/**
 * Classe con metodo partente per il test del Factory Method
 * 
 * @author Leonardo Birardi
 */
public class TestLogistics {
	// Dichiarazione privata della factory
	private static ArrayList<AbstractCreatorLogistics> logistics;
	private static Random random;

	public TestLogistics() {
		logistics = new ArrayList<AbstractCreatorLogistics>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Inizializzazione ArrayList di Lofistic
		new TestLogistics();

		// Aggiunta di n random istanze all'ArrayList
		random = new Random();
		for (int i = 0; i < random.nextInt(5); i++) {
			configure();
		}

		// Run Logic Business per ogni istanza generata
		for (int i = 0; i < logistics.size(); i++) {
			runBusinessLogic(logistics.get(i));
		}
	}

	/**
	 * Creazione delle istanze concrete
	 */
	public static void configure() {
		random = new Random();
		if (random.nextInt(2) == 1) {
			logistics.add(new ConcreteCreatorRoadLogistics());
		} else {
			logistics.add(new ConcreteCreatorSeaLogistics());
		}
	}

	/**
	 * Esecuzione della logica del singolo oggetto concreto senza sapere la tipologia dell'oggetto vero e proprio
	 * 
	 * @param AbstractCreatorLogistics l oggetto singolo 
	 */
	public static void runBusinessLogic(AbstractCreatorLogistics l) {
		l.planDelivery();
	}

}
