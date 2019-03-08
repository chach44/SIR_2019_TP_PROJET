package priseRdv;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import jpa.EntityManagerHelper;

@Entity
@NamedQueries({ @NamedQuery(name = "ListeReponse.findAll", query = "SELECT lp FROM ListeReponse lp"),
		@NamedQuery(name = "ListeReponse.findById", query = "SELECT lp FROM ListeReponse lp WHERE lp.id = :id") })

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
		try {
			managerHelper.beginTransaction();
			managerHelper.getEntityManager().persist(lRep);
			managerHelper.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<ListeReponse> getListReponseList() {
		try {
			managerHelper.beginTransaction();
			return managerHelper.getEntityManager().createNamedQuery("ListeReponse.findAll").getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void remove(long id) {
		try {
			managerHelper.beginTransaction();
			ListeReponse laListeReponse = (ListeReponse) managerHelper.getEntityManager()
					.createNamedQuery("ListeReponse.findById").setParameter(":id", id).getSingleResult();
			managerHelper.getEntityManager().remove(laListeReponse);
			managerHelper.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static ListeReponse getById(long id) {
		try {
			managerHelper.beginTransaction();
			ListeReponse laListeReponse = (ListeReponse) managerHelper.getEntityManager()
					.createNamedQuery("ListeReponse.findById").setParameter(":id", id).getSingleResult();
			return laListeReponse;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
