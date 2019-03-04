package priseRdv;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nourriture {

	public int idAliment;
	public String nomAliment;
	
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

	@Override
	public String toString() {
		return "Nourriture [id aliment=" + idAliment + ", nom aliment=" + nomAliment + "]";
	}
	
}
