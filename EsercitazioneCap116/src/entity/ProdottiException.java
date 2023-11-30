/**
 *
 */
package entity;

/**
 *
 */
public class ProdottiException extends Exception {

	/**
	 * @param message
	 */
	public ProdottiException(String message) {
		super(message);
	}

	public static void costoNegativo() throws ProdottiException {
		throw new ProdottiException("Il costo non può essere negativo");
	}

	public static void nomeErrore() throws ProdottiException {
		throw new ProdottiException("Nome non valido");
	}

	public static void garanziaNegativa() throws ProdottiException {
		throw new ProdottiException("La garanzia non può essere negativa");
	}

	public static void tempoConservazioneNegativo() throws ProdottiException {
		throw new ProdottiException("Il tempo di conservazione non può essere negativo");
	}

	public static void energiaNegativa() throws ProdottiException {
		throw new ProdottiException("L'energia non può essere negativa");
	}

	public static void prodottoInesistente() throws ProdottiException {
		throw new ProdottiException("Prodotto Inesistente");
	}
}
