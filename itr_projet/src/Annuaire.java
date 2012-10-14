import java.util.*;

public class Annuaire {
	private List<Contactable> ann;
	
	public Annuaire() {
		this.ann = new LinkedList<Contactable>();
	}
	
	public void ajouter(Contactable c) {
		this.ann.add(c);
	}
	
	public Contact chercher(String nom) throws NoContactInfoException {
		Contact c = null;
		for (Contactable x : this.ann) {
			if (nom.equals(x.getNom())) {
				c = x.getContact();
				if (c == null) {
					throw new NoContactInfoException("Pas d'information de contact pour "+nom);
				}
				break;
			}
		}
		return c;
	}
}
