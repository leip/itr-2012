/**
 * 
 */

/**
 * @author moreau
 *
 */
public class Entreprise {
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
}
