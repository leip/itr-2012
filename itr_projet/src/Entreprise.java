/**
 * 
 */

/**
 * @author moreau
 *
 */
public class Entreprise implements Contactable {
	/**
	 * adresse mail 
	 */
	private ContactMail email;
	
	/**
	 * téléphone
	 */
	private ContactTelephonique telephone;
	
	/**
	 * nom de l'entreprise
	 */
	private String nom;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * constructeur qui crée une entreprise
	 */
	public Entreprise(String nom) {
		this.nom = nom;
	}

	@Override
	public void setContact(Contact c) {
		if (c instanceof ContactTelephonique) {
			this.telephone = (ContactTelephonique) c;
		}
		if (c instanceof ContactMail) {
			this.email = (ContactMail) c;
		}
	}

	@Override
	public Contact getContact() {
		// on privilégie l'adresse mail
		if (this.email != null) {
			return this.email;
		}
		return this.telephone;
	}
}
