import java.util.LinkedList;

/**
 * 
 */

/**
 * @author moreau
 * une classe Manager
 */
public class Manager extends Employe {
	/**
	 * liste des personnes sous les ordres du Manager
	 */
	private LinkedList<Employe> employes;
	
	/**
	 * supérieur hiérarchique
	 * 
	 * pour le patron de l'entreprise, le supérieur vaudra null
	 */
	private Manager manager;
	
	/**
	 * @return the manager
	 */
	public Manager getManager() {
		return manager;
	}

	/* (non-Javadoc)
	 * @see Employe#toString()
	 */
	@Override
	public String toString() {
		return "MANAGER "+super.toString();
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	/**
	 * ajoute un employé à la liste des gens sous les ordres du 
	 * manager
	 * @param nouveau l'employé à ajouter
	 */
	public void ajouteEmploye(Employe nouveau) {
		// ajout à la liste des nouveaux
		this.employes.add(nouveau);
		
		// on vérifie si nouveau est lui-même un Manager
		if (nouveau instanceof Manager) {
			// sous-classement
			Manager m1 = (Manager) nouveau;
			m1.setManager(this);
		}
	}
	
	/**
	 * donne le nombre d'employés sous les ordres d'un manager
	 */
	public int nombreEmployes() {
		int s = this.employes.size();
		for (Employe e : this.employes) {
			if (e instanceof Manager) {
				Manager m = (Manager) e;
				s += m.nombreEmployes();
			}
		}
		return s;
	}
	
	/**
	 * compte le nombre de femmes sous la responsabillité d'un manager
	 * @return
	 */
	public int nombreFemmes() {
		int f = 0;
		for (Employe e: this.employes) {
			if (!e.isSexe()) {
				f++;
			}
			if (e instanceof Manager) {
				Manager m = (Manager) e;
				f += m.nombreFemmes();
			}
		}
		return f;
	}
	
	/**
	 * 
	 * pourcentage de femmes sous la responsabilité d'un manager
	 */
	float pourcentageFemmes() throws PasDEmployeException {
		int nf = nombreFemmes();
		int ne = nombreEmployes();
		if (ne == 0) {
			throw new PasDEmployeException();
		}
		float r = ((float) nf / (float) ne)*100f;
		return r;
	}
	
	/**
	 * afficher la hierarchie d'un manager sur le modele
	 * A a pour chef B
	 * B a pour chef C
	 * C a pour chef D
	 * D est le patron
	 */
	void afficheHierarchie() {
		if (this.manager == null) {
			System.out.println(this.getNomComplet()+" est le patron");
		}
		else {
			System.out.println(this.manager.getNomComplet()+" est le chef de "+this.getNomComplet());
			this.manager.afficheHierarchie();
		}
	}
	
	/**
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param anneeNaissance
	 * @param numero
	 * @param entreprise
	 */
	public Manager(String nom, String prenom, boolean sexe, int anneeNaissance,
			int numero, Entreprise entreprise) {
		super(nom, prenom, sexe, anneeNaissance, numero, entreprise);
		this.employes = new LinkedList<Employe>();
	}

}
