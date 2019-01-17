package priseRdv;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Sondages {
	
	@Id
	@GeneratedValue
	long id;
	
	@OneToOne
	Participant createurSondage;
	
	String titre, theme;

	@ManyToMany
	Collection<Question> questions;
	
	@OneToMany(mappedBy="question")
	Collection<ListeReponse> reponses;

	public Sondages() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Collection<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}

	public Collection<ListeReponse> getReponses() {
		return reponses;
	}

	public void setReponses(Collection<ListeReponse> reponses) {
		this.reponses = reponses;
	}

	@Override
	public String toString() {
		return "Sondage [id=" + id + ", titre=" + titre + ", theme=" + theme + ", questions=" + questions
				+ ", reponses=" + reponses + "]";
	}
	
	
}
