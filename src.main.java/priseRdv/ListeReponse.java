package priseRdv;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListeReponse {


	/**
	 * TODO LIEN VERT A REVOIR
	 */




	@Id 
	@GeneratedValue
	long id;

	@ManyToOne
	Participant participant;

	@ManyToOne
	Sondage sondage;

	@OneToMany(mappedBy="reponsequestion")
	Collection<Reponse> reponses;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	public Collection<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(Collection<Reponse> reponses) {
		this.reponses = reponses;
	}

	@Override
	public String toString() {
		return "ListeReponse [id=" + id + ", participant=" + participant + ", sondage=" + sondage + ", reponses="
				+ reponses + "]";
	}

}
