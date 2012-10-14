
public class EntrepriseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Entreprise gouv = new Entreprise("Gouvernement Français");
		gouv.setContact(new ContactMail("gouvernement@gouv.fr"));
		
		Manager fh = new Manager("Hollande","François",true, 1939,342,gouv);
		fh.setContact(new ContactMail("francois.holland@matignon.gouv.fr"));
		
		Manager jma = new Manager("Ayrault","Jean-Marc",true, 1939,787,gouv);
		fh.ajouteEmploye(jma);
		Manager db = new Manager("Batho","Delphine",false,1973,423,gouv);
		jma.ajouteEmploye(db);
		Manager gf = new Manager("Fioraso","Genevieve",false,1950,23,gouv);
		jma.ajouteEmploye(gf);
		Manager dd = new Manager("Dagot","Dimitri",true,1960,3243,gouv);
		dd.setContact(new ContactMail("dimitri.dagot@ecp.fr"));
		
		gf.ajouteEmploye(dd);
		Employe gm = new Employe("Moreau","Guillaume",true,1973,0,gouv);
		gm.setContact(new ContactMail("guillaume.moreau@ec-nantes.fr"));
		
		Employe yl = new Employe("Yu","Lei",true,1973,467,gouv);
		Employe yc = new Employe("Yin","Chuantao",true,1977,9,gouv);
		dd.ajouteEmploye(gm);
		dd.ajouteEmploye(yl);
		dd.ajouteEmploye(yc);
		
		fh.afficheHierarchie();
		System.out.println("F. Hollande a "+fh.nombreEmployes()+" employes");
		System.out.println("D. Batho a "+db.nombreEmployes()+" employes");
		
		System.out.println("---------");
		
		jma.afficheHierarchie();

		System.out.println("---------");

		dd.afficheHierarchie();
		
		// pourcentage de femmes
		try {
			System.out.println("Pourcentage de femmes sous la responsabilité de DD : "+dd.pourcentageFemmes());
			System.out.println("Pourcentage de femmes sous la responsabilité de FH : "+fh.pourcentageFemmes());
			System.out.println("Pourcentage de femmes sous la responsabilité de DB : "+db.pourcentageFemmes());
		}
		catch (PasDEmployeException e) {
			System.out.println("On ne peut pas calculer le pourcentage de femmes si 0 employes");
		}
		
		Annuaire a = new Annuaire();
		a.ajouter(gouv);
		a.ajouter(fh);
		a.ajouter(jma);
		a.ajouter(db);
		a.ajouter(gf);
		a.ajouter(dd);
		a.ajouter(gm);
		a.ajouter(yl);
		a.ajouter(yc);
		
		try {
			System.out.println(a.chercher("Moreau"));
			System.out.println(a.chercher("Gouvernement Français"));
			System.out.println(a.chercher("Dagot"));
			System.out.println(a.chercher("Yin"));
		}
		catch (NoContactInfoException e) {
			System.out.println("Une recherche a échoué : "+e.getMessage());
		}
	}

}
