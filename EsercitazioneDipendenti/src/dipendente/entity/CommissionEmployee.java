/**
 * 
 */
package dipendente.entity;

/**
 * Impiegato con percentuale commissione
 * 
 * @author Leonardo Birardi
 *
 */
public class CommissionEmployee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private double grossSales; // vendite settimanali lordo
	private double commissionRate; // percentuale di commissione

	/**
	 * 
	 * @param firstName            Nome
	 * @param lastName             Cognome
	 * @param socialSecurityNumber Numero della tessera sanitaria
	 * @param grossSales           Lordo delle vendite
	 * @param commissionRate       Percentuale di commissione
	 */
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		// chiamata implicita al costruttore di Object
		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}

		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	/**
	 * 
	 * @return Restituisce il nome
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @return Restituisce il cognome
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @return Restituisce il numero di previdenza sociale
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * 
	 * @param grossSales Imposta l'ammontare lordo delle vendite
	 */
	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		this.grossSales = grossSales;
	}

	/**
	 * 
	 * @return Restituisce l'ammontare lordo delle vendite
	 */
	public double getGrossSales() {
		return grossSales;
	}

	/**
	 * Modifica la percentuale di commissione
	 * 
	 * @param commissionRate Percentuale di commissione
	 */
	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}

		this.commissionRate = commissionRate;
	}

	/**
	 * 
	 * @return Restituisce la percentuale di commissione
	 */
	public double getCommissionRate() {
		return commissionRate;
	}

	/**
	 * 
	 * @return Calcola il guadagno
	 */
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}

	@Override
	/**
	 * Restituisce la rappresentazione String dell'oggetto CommissionEmployee
	 * 
	 */
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", "commission employee", getFirstName(),
				getLastName(), "social security number", getSocialSecurityNumber(), "gross sales", getGrossSales(),
				"commission rate", getCommissionRate());
	}
}