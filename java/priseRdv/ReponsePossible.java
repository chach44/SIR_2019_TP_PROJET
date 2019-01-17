package priseRdv;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ReponsePossible {
	
	@Id
	@GeneratedValue
	long id;
	
	boolean correct;
	
	@ManyToOne
	Question question;
	
	@ManyToMany(mappedBy="reponsespossibles")
	Collection<Reponse> reponse;
	
	public ReponsePossible() {
	}

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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Collection<Reponse> getReponse() {
		return reponse;
	}

	public void setReponse(Collection<Reponse> reponse) {
		this.reponse = reponse;
	}

	@Override
	public String toString() {
		return "ReponsePossible [id=" + id + ", correct=" + correct + ", question=" + question + ", reponse=" + reponse
				+ "]";
	}
	
	
}
