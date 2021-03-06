package priseRdv;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import jpa.EntityManagerHelper;

@Entity
@NamedQueries({
		@NamedQuery(name = "ReponsePossible.findQuestion", query = "SELECT rP FROM ReponsePossible rP where rP.id = :idquestion "),
		@NamedQuery(name = "ReponsePossible.findAll", query = "SELECT rP FROM ReponsePossible rP "),
		@NamedQuery(name = "ReponsePossible.findById", query = "SELECT rP FROM ReponsePossible rP where rP.id = :id ") })
public class ReponsePossible {

	private long id;
	private boolean correct;
	private Question question;
	private Collection<Reponse> reponse;
	static EntityManagerHelper manager;

	public ReponsePossible(Question q, Collection<Reponse> listeReponse) {
		question = q;
		reponse = listeReponse;
	}

	public ReponsePossible() {
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	@ManyToOne
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@ManyToMany
	public Collection<Reponse> getReponse() {
		return reponse;
	}

	public void setReponse(Collection<Reponse> reponse) {
		this.reponse = reponse;
	}

	public static void sauvgarder(ReponsePossible rPossible) {
		try {
			manager.beginTransaction();
			manager.getEntityManager().persist(rPossible);
			manager.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<ReponsePossible> getReponsePossibleList(String idQuestion) {
		try {

			return manager.getEntityManager().createNamedQuery("ReponsePossible.findQuestion")
					.setParameter("idquestion", idQuestion).getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<ReponsePossible> getReponsePossibleList() {
		try {

			return manager.getEntityManager().createNamedQuery("ReponsePossible.findAll").getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void remove(Long id) {
		try {
			manager.beginTransaction();
			ReponsePossible LaRepPossible = (ReponsePossible) manager.getEntityManager()
					.createNamedQuery("ReponsePossible.findById").setParameter(":id", id).getSingleResult();
			manager.getEntityManager().remove(LaRepPossible);
			manager.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static ReponsePossible getById(Long id) {
		try {

			ReponsePossible LaRepPossible = (ReponsePossible) manager.getEntityManager()
					.createNamedQuery("ReponsePossible.findById").setParameter(":id", id).getSingleResult();
			return LaRepPossible;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
