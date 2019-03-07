package priseRdv;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import jpa.EntityManagerHelper;

@Entity
public class ReponsePossible {
	
	private long id;
	private boolean correct;
	private Question question;
	private Collection<Reponse> reponse;
	static EntityManagerHelper managerHelper;
	
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

	public static void sauvgarder() {
	managerHelper.beginTransaction();
	managerHelper.getEntityManager().persist();
	managerHelper.commit();
}

}
