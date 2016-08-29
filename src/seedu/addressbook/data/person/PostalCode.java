package seedu.addressbook.data.person;

public class PostalCode {
	private final String postalCode;
	
	public PostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	/**
	 * Gets postal code of address
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
}
