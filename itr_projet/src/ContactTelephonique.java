
public class ContactTelephonique extends Contact {
	private String telephone;
	
	
	/**
	 * @param telephone
	 */
	public ContactTelephonique(String telephone) {
		super();
		this.telephone = telephone;
	}


	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}


	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public String getContactInfo() {
		// TODO Auto-generated method stub
		return this.telephone;
	}

	public String toString() {
		return "Telephone :"+this.telephone;
	}
}
