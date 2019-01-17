package priseRdv;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ReponsePossible {
	long id;
	boolean correct;
	Question question;
	Collection<Reponse> reponse;
	private ReponsePossible() {
	}

	@Id
	@GeneratedValue
	private long getId() {
		return id;
	}

	private boolean isCorrect() {
		return correct;
	}

	private void setCorrect(boolean correct) {
		this.correct = correct;
	}

	@ManyToOne
	private Question getQuestion() {
		return question;
	}

	private void setQuestion(Question question) {
		this.question = question;
	}

	@ManyToMany(mappedBy = "reponsespossibles")
	private Collection<Reponse> getReponse() {
		return reponse;
	}

	private void setReponse(Collection<Reponse> reponse) {
		this.reponse = reponse;
	}

	@Override
	public String toString() {
		return "ReponsePossible [id=" + id + ", correct=" + correct + ", question=" + question + ", reponse=" + reponse
				+ "]";
	}

}
