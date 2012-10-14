
public class ContactMail extends Contact {
	private String email;
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getContactInfo() {
		return this.email;
	}
	
	public String toString() {
		return "email : "+this.email;
	}

	/**
	 * @param email
	 */
	public ContactMail(String email) {
		super();
		this.email = email;
	}
}
