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
	
	private long id;
	private Date datereponse;
	private ListeReponse reponsequestion;
	private Collection<ReponsePossible> reponsespossibles;

	public Reponse() {
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	public Date getDatereponse() {
		return datereponse;
	}

	public void setDatereponse(Date datereponse) {
		this.datereponse = datereponse;
	}
	
	@ManyToOne
	public ListeReponse getReponsequestion() {
		return reponsequestion;
	}

	public void setReponsequestion(ListeReponse reponsequestion) {
		this.reponsequestion = reponsequestion;
	}
	
	@ManyToMany
	public Collection<ReponsePossible> getReponsespossibles() {
		return reponsespossibles;
	}

	public void setReponsespossibles(Collection<ReponsePossible> reponsespossibles) {
		this.reponsespossibles = reponsespossibles;
	}

}
