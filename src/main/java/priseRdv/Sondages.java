package priseRdv;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import jpa.EntityManagerHelper;

@Entity
@NamedQueries({ @NamedQuery(name = "Sondages.findAll", query = "SELECT s FROM Sondages s"),
		@NamedQuery(name = "Sondages.findById", query = "SELECT s FROM Sondages s WHERE s.id = :id") })
public class Sondages {

	private long id;
	private Participant createurSondage;
	private String titre, theme;
	private Collection<Question> questions;
	private Collection<ListeReponse> reponses;
	private Reunion reunion;
	private String urlPAD;
	static EntityManagerHelper managerHelper;

	public Sondages(String theme, Collection<Question> listeQuestions) {
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

	@OneToMany(mappedBy = "sondage")
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

	public static void sauvgarder(Sondages sondage) {
		managerHelper.beginTransaction();
		managerHelper.getEntityManager().persist(sondage);
		managerHelper.commit();
	}

	public static List<Sondages> getSondagesList() {
		try {
		managerHelper.beginTransaction();
		return	managerHelper.getEntityManager().createNamedQuery("Sondages.findAll").getResultList();	
		}catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
	}

	public static Sondages findById(String idSondage) {
		try {
		managerHelper.beginTransaction();
		return	(Sondages) managerHelper.getEntityManager().createNamedQuery("Sondages.findById").setParameter(":id", idSondage).getSingleResult();
		}catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }	
	}

	public static void remove(Long idSondage) {
		try {
			managerHelper.beginTransaction();
			Sondages leSondage = (Sondages) managerHelper.getEntityManager().createNamedQuery("Sondages.findById")
					.setParameter(":id", idSondage).getSingleResult();
			managerHelper.getEntityManager().remove(leSondage);
			managerHelper.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Sondages getById(Long idSondage) {
		try {
			managerHelper.beginTransaction();
			Sondages leSondage = (Sondages) managerHelper.getEntityManager().createNamedQuery("Sondages.findById")
					.setParameter(":id", idSondage).getSingleResult();
			return leSondage;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
