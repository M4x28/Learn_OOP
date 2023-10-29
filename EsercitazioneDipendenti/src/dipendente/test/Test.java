/**
 * 
 */
package dipendente.test;

import dipendente.entity.BasePlusCommissionEmployee;
import dipendente.entity.CommissionEmployee;

/**
 * Testa le classi Commission
 * 
 * @author Leonardo Birardi
 *
 */
public class Test {
	/**
	 * Avvia il programma per testare le classi Commission
	 * 
	 * @param args Argomento di input non richiesti
	 */
	public static void main(String[] args) {
		// Crea un oggetto CommissionEmployee
		CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 10000, 0.06);

		// Stampa le informazioni sul CommissionEmployee
		System.out.println("Commission Employee Details:");
		System.out.println(employee);

		// Calcola e stampa i guadagni del CommissionEmployee
		System.out.printf("Earnings: $%.2f%n%n", employee.earnings());

		// Crea un oggetto BasePlusCommissionEmployee
		BasePlusCommissionEmployee baseEmployee = new BasePlusCommissionEmployee("Jane", "Smith", "987-65-4321", 5000,
				0.04, 300);

		// Stampa le informazioni sul BasePlusCommissionEmployee
		System.out.println("Base Plus Commission Employee Details:");
		System.out.println(baseEmployee);

		// Calcola e stampa i guadagni del BasePlusCommissionEmployee
		System.out.printf("Earnings: $%.2f%n", baseEmployee.earnings());
	}
}
