package priseRdv;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import jpa.EntityManagerHelper;

@Entity
public class ListeReponse {

	private long id;
	private Participant participant;
	private Sondages sondage;
	private Collection<Reponse> reponses;
	static EntityManagerHelper managerHelper;
	
	public ListeReponse(Participant participant, Sondages sondage) {
		this.participant = participant;
		this.sondage = sondage;
	}

	@Id 
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	@ManyToOne
	public Sondages getSondage() {
		return sondage;
	}

	public void setSondage(Sondages sondage) {
		this.sondage = sondage;
	}

	@OneToMany
	public Collection<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(Collection<Reponse> reponses) {
		this.reponses = reponses;
	}

	public void addReponse(Reponse reponses) {
		this.reponses.add(reponses);
	}
	public static void sauvgarder(ListeReponse lRep) {
	managerHelper.beginTransaction();
	managerHelper.getEntityManager().persist(lRep);
	managerHelper.commit();
}
}
