/**
 * 
 */
package veicoli.test;

import veicoli.entity.Automobile;
import veicoli.entity.Bicicletta;
import veicoli.entity.BiciclettaElettrica;
import veicoli.entity.Veicolo;

/**
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Veicolo veicolo = new Veicolo("base", 2020); questo non si può istanziare
			// date che è una classe astratta
			Automobile auto = new Automobile("lusso", 1998, 4, .3);
			BiciclettaElettrica biciElettrica = new BiciclettaElettrica("ModelloBici1", 1980, "TelaioInCarbonio",
					(short) 4, (short) 3, 10);

			Veicolo[] veicoli = { auto, biciElettrica };

			veicoli[0] = FactoryVeicolo.getIstanceVeicolo(3);

			Veicolo[] veicoli2 = new Veicolo[2];
			veicoli2[0] = FactoryVeicolo.getIstanceVeicolo(3);

			if (veicoli2[0] instanceof BiciclettaElettrica) {
				BiciclettaElettrica biciElettrica2 = (BiciclettaElettrica) veicoli2[0];
				biciElettrica2.getMarciaCorrente();
			}

			for (Veicolo veicoloEl : veicoli) {
				System.out.print("\n" + veicoloEl.getModello() + " ");
				veicoloEl.suonaClacson();

				System.out.println("NUOVO " + veicoloEl.getModello());
			}

			Bicicletta[] biciclette = { biciElettrica };
			for (Bicicletta biciElemento : biciclette) {
				System.out.print("\n" + biciElemento.getMarciaCorrente() + " ");
			}

		} catch (Exception e) {
			System.out.println("ERRORE: " + e.getMessage());
		}
	}

}
