package priseRdv;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reponse {
	

	long id;
	Date datereponse;
	ListeReponse reponsequestion;
	
	Collection<ReponsePossible> reponsespossibles;

	public Reponse() {
	}
	@Id
	@GeneratedValue
	private long getId() {
		return id;
	}

	@Temporal(TemporalType.DATE)
	private Date getDatereponse() {
		return datereponse;
	}

	private void setDatereponse(Date datereponse) {
		this.datereponse = datereponse;
	}
	@ManyToOne
	private ListeReponse getReponsequestion() {
		return reponsequestion;
	}

	private void setReponsequestion(ListeReponse reponsequestion) {
		this.reponsequestion = reponsequestion;
	}
	@ManyToMany
	private Collection<ReponsePossible> getReponsespossibles() {
		return reponsespossibles;
	}

	private void setReponsespossibles(Collection<ReponsePossible> reponsespossibles) {
		this.reponsespossibles = reponsespossibles;
	}

}
