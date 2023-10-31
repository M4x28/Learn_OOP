package prog2.negozio.entity;

/**
 * Classe che contiene le Costanti di programm
 * 
 * @author Leonardo Birardi
 */
final class Costante {
	// Classe Prodotto
	static final double MINPREZZOPRODOTTO = 1;
	// Classe ProdottoAlimentare
	static final double SCONTODATASCADENZAODIERNA = .5;
	static final double SCONTOPRODOTTOSCADUTO = .3;
	static final double SCONTOPRODOTTONONSCADUTO = 1;
	static final int MINTEMPCONSERVAZIONE = 1;
	// Classe ProdottoElettronico
	static final int DEFAULTNMESIGARANZIA = 12;
	static final int MINNMESIGARANZIA = 2;
	static final int MAXNMESIGARANZIA = 24;
	static final double PREZZOGARANZIAPRO = 1.5;
	static final double PREZZOGARANZIAAVANZATA = 1.2;
	static final double PREZZOGARANZIABASE = 1;
	// Classe ProdottoScontato
	static final double MINPERCENTUALESCONTO = .01;
	static final double MAXPERCENTUALESCONTO = .75;
}
