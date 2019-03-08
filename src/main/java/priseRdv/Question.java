package priseRdv;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import jpa.EntityManagerHelper;

@Entity
@NamedQueries({ @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
		@NamedQuery(name = "Question.findById", query = "SELECT q FROM Question q where q.id = :id ") })
public class Question {

	private long id;
	private String enonce;
	private boolean multiple;
	private Collection<ReponsePossible> reponsepossibles;
	private Collection<Sondages> lesSondages;
	static EntityManagerHelper manager ;


	public Question(String enonce, boolean multiple) {
		this.enonce = enonce;
		this.multiple = multiple;
	}

	public Question() {

	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(length = 2048)
	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public boolean isMultiple() {
		return multiple;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	@OneToMany(mappedBy = "question")
	public Collection<ReponsePossible> getReponsepossibles() {
		return reponsepossibles;
	}

	public void setReponsepossibles(Collection<ReponsePossible> reponsepossibles) {
		this.reponsepossibles = reponsepossibles;
	}

	public void addReponsePossible(ReponsePossible reponseP) {
		this.reponsepossibles.add(reponseP);
	}

	@ManyToMany(mappedBy = "questions")
	public Collection<Sondages> getLesSondages() {
		return lesSondages;
	}

	public void setLesSondages(Collection<Sondages> lesSondages) {
		this.lesSondages = lesSondages;
	}

	public void addSondages(Sondages lesondage) {
		lesSondages.add(lesondage);
	}

	public static void sauvgarder(Question q) {
		try {
			manager.beginTransaction();
			  manager.getEntityManager().persist(q);
			  manager.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<Question> getQuestionList() {
		try {
			return manager.getEntityManager().createNamedQuery("Question.findAll").getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void remove(Long id) {
		try {
			manager.beginTransaction();
			Question laQuestion = (Question) manager.getEntityManager().createNamedQuery("Question.findById")
					.setParameter(":id", id).getSingleResult();
			manager.getEntityManager().remove(laQuestion);
			manager.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Question getById(Long id) {
		try {
			
			Question laQuestion = (Question) manager.getEntityManager().createNamedQuery("Question.findById")
					.setParameter(":id", id).getSingleResult();
			return laQuestion;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
