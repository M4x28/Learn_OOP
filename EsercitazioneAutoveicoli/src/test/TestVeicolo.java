/**
 * 
 */
package test;

import java.util.ArrayList;

import veicolo.entity.Alimentazione;
import veicolo.entity.Autoveicolo;
import veicolo.entity.Motore;
import veicolo.entity.Ruota;
import veicolo.entity.Telaio;

/**
 * Classe che testa la classe Veicolo Soluzione realizzata in aula in data 24
 * ottobre 2023.
 * 
 * @author Leonardo Birardi
 */
public class TestVeicolo {

	/**
	 * Esegue il test della classe Autoveicolo
	 * 
	 * @param args Argomenti a linea di comando (non richiesti)
	 */
	public static void main(String[] args) {
		// Creazione aggregato
		String targa = "123";
		Motore motore = new Motore("modello", "BMW", (short) 2000, Alimentazione.BENZINA);
		Telaio telaio = new Telaio("modello", "prodTelaio", (short) 1000);
		ArrayList<Ruota> ruote = new ArrayList<Ruota>();

		Ruota ruota = new Ruota("modelloRuota1", "prodRuota1");
		ruote.add(ruota);
		ruota = new Ruota("modelloRuota2", "prodRuota2");
		ruote.add(ruota);
		ruota = new Ruota("modelloRuota3", "prodRuota3");
		ruote.add(ruota);
		ruota = new Ruota("modelloRuota4", "prodRuota4");
		ruote.add(ruota);

		// Creazione aggregati
		Autoveicolo auto = new Autoveicolo(targa, motore, telaio, ruote);
		Autoveicolo auto2 = new Autoveicolo(targa.repeat(2), motore, telaio, ruote);

		// soluzione accettabile in data 24 ottobre 2023
		ArrayList<Autoveicolo> veicoli = new ArrayList<Autoveicolo>();
		if (!veicoli.contains(auto))
			veicoli.add(auto);
		if (!veicoli.contains(auto2))
			veicoli.add(auto2);

		for (Autoveicolo autoLista : veicoli) {
			System.out.println(autoLista.getTarga());
		}

		for (Autoveicolo autoLista : veicoli) {
			System.out.println(autoLista.getAlimentazione());
		}
	}

}
