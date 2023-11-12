/**
 * 
 */
package entity;

/**
 * 
 */
public enum PrincipioNutritivo {
	CARBOIDRATI("carboidrati"), GRASSI("grassi"), PROTEINE("proteine"), VITAMINE("vitamine"), LIPIDI("lipidi");

	private String value;

	/**
	 * @param value
	 */
	private PrincipioNutritivo(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}
