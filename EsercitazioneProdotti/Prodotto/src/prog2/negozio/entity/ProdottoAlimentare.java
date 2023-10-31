/**
 * 
 */
package prog2.negozio.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe Prodotto Alimentare che eredita da Prodotto
 * 
 * @author Leonardo Birardi
 */
public class ProdottoAlimentare extends Prodotto {

	private String dataScadenza; // nel formato: dd/MM/yyyy
	private int tempConservazione; // in giorni
	private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private final Date today = new Date();

	/**
	 * @param codice
	 * @param descrizione
	 * @param prezzo
	 * @param dataScadenza
	 * @param tempConservazione
	 */
	public ProdottoAlimentare(String codice, String descrizione, double prezzo, String dataScadenza,
			int tempConservazione) {
		super(codice, descrizione, prezzo);
		
		// Conversione data
		Date convertedProductDate;
		try {
			convertedProductDate = formatter.parse(dataScadenza);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Data Scadenza è in un formato non accettato [dd/MM/yyyy]");
		}
		
		if (convertedProductDate.before(today)) {
			throw new IllegalArgumentException("Il prodotto è già scaduto, non è possibile inserirlo.");
		} else {
			this.dataScadenza = dataScadenza;
		}
		
		if (tempConservazione >= Costante.MINTEMPCONSERVAZIONE) {
			this.tempConservazione = tempConservazione;
		} else {
			throw new IllegalArgumentException("Tempo di Scadenza non valido, inserire un valore >= 1");
		}
	}

	/**
	 * Conversione Data di tipo Stringa in formato: dd/MM/yyyy in tipo Data
	 * 
	 * @param dataScadenza
	 * @return Data
	 * @throws IllegalArgumentException nel caso in cui la data non è nel formato
	 *                                  corretto
	 */
	private Date dataStringToData(String dataScadenza) throws IllegalArgumentException {
		Date convertedProductDate;
		try {
			convertedProductDate = formatter.parse(dataScadenza);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Data Scadenza è in un formato non accettato [dd/MM/yyyy]");
		}
		return convertedProductDate;
	}

	/**
	 * Calcolo Prezzo di un Prodotto Alimentare
	 */
	@Override
	public double calcolaPrezzo() {
		double prezzo = super.getPrezzo();

		Date convertedProductDate = dataStringToData(this.dataScadenza);

		// Controllo sulla scadenza
		if (convertedProductDate.equals(today)) {
			prezzo -= super.getPrezzo() * Costante.SCONTODATASCADENZAODIERNA;
		} else if (convertedProductDate.after(today)) {
			prezzo -= super.getPrezzo() * Costante.SCONTOPRODOTTOSCADUTO;
		} else {
			prezzo -= super.getPrezzo() * Costante.SCONTOPRODOTTONONSCADUTO;
		}

		return prezzo;
	}

	/**
	 * @return the dataScadenza
	 */
	public String getDataScadenza() {
		return dataScadenza;
	}

	/**
	 * @return the tempConservazione
	 */
	public int getTempConservazione() {
		return tempConservazione;
	}

}
