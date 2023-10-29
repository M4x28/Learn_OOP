/**
 * 
 */
package veicolo.entity;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Rappresenta la classe Autoveicolo come specificate nella traccia di esempio
 * 
 * @author Leonardo Birardi
 *
 */
public class Autoveicolo {

	private String targa;
	private Motore motore;
	private Telaio telaio;
	private ArrayList<Ruota> ruote = new ArrayList<>(); // Dichirazione e inizializzazione di un ArrayList di tipo Ruota
														// vuoto
	private static final int NUMERORUOTE = 4; // private = accessibile solo all'interno della classe che la contiene
												// static = condivisa tra tutte le istanze della classe
												// final = costante non modificabile

	/**
	 * @param targa
	 * @param motore
	 * @param telaio
	 * @param ruote
	 */
	public Autoveicolo(String targa, Motore motore, Telaio telaio, ArrayList<Ruota> ruote) {
		super(); // Si può sottointendere perché in questo caso è una classe figlia di Object
		this.targa = targa;
		this.motore = motore;
		this.telaio = telaio;
		// Il numero di ruote dev'essere necessariamente uguale a NUMERORUOTE
		if (ruote.size() == NUMERORUOTE) {
			this.ruote = ruote;
		}
	}

	/**
	 * @return the targa
	 */
	public String getTarga() {
		return targa;
	}

	/**
	 * @return the motore
	 */
	public Motore getMotore() {
		return motore;
	}

	/**
	 * @return the telaio
	 */
	public Telaio getTelaio() {
		return telaio;
	}

	/**
	 * @return the ruote
	 */
	public ArrayList<Ruota> getRuote() {
		return ruote;
	}

	/**
	 * 
	 * @return Restituisce il tipo di alimentazione
	 */
	public String getAlimentazione() {
		return motore.getAlimentazione().toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(targa);
	}

	@Override
	/**
	 * L'equivalenza si basa sulla targa
	 */
	public boolean equals(Object obj) {
		if (this == obj) // Confronta istanza corrente con un obj Generico
			return true;
		if (obj == null) // Confronta obj con null
			return false;
		if (getClass() != obj.getClass()) // Confronta le classi di appartenenza dei due oggetti
			return false;
		Autoveicolo other = (Autoveicolo) obj; // Coercizione di un oggetto generico in un oggetto di tipo Autoveicolo
		/*
		 * Il confronto tra due Autoveicoli al nocciolo si basa sul valore del campo
		 * targa. Quindi viene validata l'equivalenza tra due oggetti se sono uguali le
		 * loro targhe oppure più semplicemente se stiamo confrontando due oggetti
		 * identici.
		 */
		return Objects.equals(targa, other.targa);
	}

}
