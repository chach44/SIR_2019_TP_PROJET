package priseRdv;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Sondages {
	

	long id;
	Participant createurSondage;
	String titre, theme;
	Collection<Question> questions;
	Collection<ListeReponse> reponses;
	
	Reunion r;

	public Sondages() {
	}

	@Id
	@GeneratedValue
	private long getId() {
		return id;
	}

	private String getTitre() {
		return titre;
	}

	private void setTitre(String titre) {
		this.titre = titre;
	}

	private String getTheme() {
		return theme;
	}

	private void setTheme(String theme) {
		this.theme = theme;
	}
	@ManyToMany
	private Collection<Question> getQuestions() {
		return questions;
	}

	private void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}
	@OneToMany(mappedBy="question")
	private Collection<ListeReponse> getReponses() {
		return reponses;
	}

	private void setReponses(Collection<ListeReponse> reponses) {
		this.reponses = reponses;
	}

	@Override
	public String toString() {
		return "Sondage [id=" + id + ", titre=" + titre + ", theme=" + theme + ", questions=" + questions
				+ ", reponses=" + reponses + "]";
	}

	@OneToOne
	public Participant getCreateurSondage() {
		return createurSondage;
	}

	private void setCreateurSondage(Participant createurSondage) {
		this.createurSondage = createurSondage;
	}
	@OneToOne
	private Reunion getR() {
		return r;
	}

	private void setR(Reunion r) {
		this.r = r;
	}
	
	
}
