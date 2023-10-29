/**
 * 
 */
package veicoli.test;

import veicoli.entity.Automobile;
import veicoli.entity.BiciclettaElettrica;
import veicoli.entity.Veicolo;

/**
 * 
 */
public class FactoryVeicolo {

	private FactoryVeicolo() {
	}

	public static Veicolo getIstanceVeicolo(int scelta) {
		Veicolo istance = null;

		switch (scelta) {
		case 1:
			istance = new Automobile("lusso", 1998, 4, .3);
			break;
		case 2:
			System.out.println("devi inserire la motocicletta");
			break;
		case 3:
			istance = new BiciclettaElettrica("ModelloBici1", 1980, "TelaioInCarbonio", (short) 4, (short) 3, 10);
			break;

		}

		return istance; // Nonostante sia di tipo veicolo, torna comunque l'istanza specifica.
						// faccio up-casting, come da int a double.
	}

}
