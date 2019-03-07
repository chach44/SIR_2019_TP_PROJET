package priseRdv;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import jpa.EntityManagerHelper;

@Entity
public class Nourriture {

	public int idAliment;
	public String nomAliment;
	static EntityManagerHelper managerHelper;
	
	public Nourriture(String nomAliment) {
		this.nomAliment = nomAliment;
	}
	
	@Id 
	@GeneratedValue
	public int getIdAliment() {
		return idAliment;
	}
	
	public void setIdAliment(int idAliment) {
		this.idAliment = idAliment;
	}
	
	public String getNomAliment() {
		return nomAliment;
	}
	
	public void setNomAliment(String nomAliment) {
		this.nomAliment = nomAliment;
	}

	public static void sauvgarder(Nourriture n) {
	managerHelper.beginTransaction();
	managerHelper.getEntityManager().persist(n);
	managerHelper.commit();
}
}
