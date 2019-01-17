package priseRdv;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nourriture {

	@Id 
	@GeneratedValue
	public int idAliment;
	public String nomAliment;
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
	
}
