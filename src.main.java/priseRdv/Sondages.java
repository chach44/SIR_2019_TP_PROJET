package priseRdv;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import job.Reunion;

import javax.persistence.CascadeType;
@Entity
public class Sondages {

	private long id;
	private Participant createurSondage;
	private String titre, theme;
	private Collection<Question> questions;
	private Collection<ListeReponse> reponses;
	private Reunion reunion;

	public Sondages(String theme,Collection<Question> listeQuestions) {
		this.theme = theme;
		questions = listeQuestions;
	}

	@Id
	@GeneratedValue
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
	
	@ManyToMany
	public Collection<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question questions) {
		this.questions.add(questions);
	}
	
	@ManyToMany
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

	@OneToOne
	public Participant getCreateurSondage() {
		return createurSondage;
	}

	public void setCreateurSondage(Participant createurSondage) {
		this.createurSondage = createurSondage;
	}
	
	@OneToOne
	public Reunion getR() {
		return reunion;
	}

	public void setR(Reunion r) {
		if (reunion.getleSondage() != null) {
			reunion.setleSondage(null);
		}
		
		this.reunion = r;
		reunion.setleSondage(this);
	}
	
}
