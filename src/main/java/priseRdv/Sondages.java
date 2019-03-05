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

	private long id;
	private Participant createurSondage;
	private String titre, theme;
	private Collection<Question> questions;
	private Collection<ListeReponse> reponses;
	private Reunion reunion;
	private String urlPAD;

	public Sondages(String theme,Collection<Question> listeQuestions) {
		this.theme = theme;
		questions = listeQuestions;
	}
	public Sondages() {
		
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
	
	@OneToMany(mappedBy="sondage")
	public Collection<ListeReponse> getReponses() {
		return reponses;
	}

	public void setReponses(Collection<ListeReponse> reponses) {
		this.reponses = reponses;
	}

	@ManyToOne
	public Participant getCreateurSondage() {
		return createurSondage;
	}

	public void setCreateurSondage(Participant createurSondage) {
		this.createurSondage = createurSondage;
	}
	
	@OneToOne
	public Reunion getreunion() {
		return reunion;
	}

	public void setreunion(Reunion r) {
		
		this.reunion = r;
		reunion.setleSondage(this);
	}
	public String getUrlPAD() {
		return urlPAD;
	}
	public void setUrlPAD(String urlPAD) {
		this.urlPAD = urlPAD;
	}
	
}
