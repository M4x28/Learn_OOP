package dipendente.entity;

/**
 * Impiegato con stipendio fisso e percentuale commissione
 * 
 * @author Leonardo Birardi
 *
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary; // stipendio base

	// Costruttore a sei argomenti
	/**
	 * 
	 * @param firstName            Nome
	 * @param lastName             Cognome
	 * @param socialSecurityNumber Numero della tessera sanitaria
	 * @param grossSales           Lordo delle vendite
	 * @param commissionRate       Percentuale di commissione
	 * @param baseSalary           Stipendio fisso
	 */
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		// Chiamata al costruttore della classe CommissionEmployee
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

		// Se l'importo dello stipendio base è negativo, lancia un'eccezione
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	/**
	 * Modifica l'importo dello stipendio base
	 * 
	 * @param baseSalary Stipendio base
	 */
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	/**
	 * 
	 * @return Restituisce l'importo dello stipendio base
	 */
	public double getBaseSalary() {
		return baseSalary;
	}

	@Override
	/**
	 * Calcola i guadagni, sovrascrivendo il metodo della classe CommissionEmployee
	 */
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}

	// Restituisce la rappresentazione String dell'oggetto
	// BasePlusCommissionEmployee
	@Override
	public String toString() {
		return String.format("%s %s%n%s: %.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}
}
