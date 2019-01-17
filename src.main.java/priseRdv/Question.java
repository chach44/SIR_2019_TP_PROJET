package priseRdv;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Question {
	
	private long id;
	private String enonce;
	private boolean multiple;
	private Collection<Sondages> questionnaires;
	private Collection<ReponsePossible> reponsepossibles;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	@Column(length=2048)
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

	@ManyToMany(mappedBy="questions")
	public Collection<Sondages> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(Collection<Sondages> questionnaires) {
		this.questionnaires = questionnaires;
	}

	@OneToMany(mappedBy="question")
	public Collection<ReponsePossible> getReponsepossibles() {
		return reponsepossibles;
	}

	public void setReponsepossibles(Collection<ReponsePossible> reponsepossibles) {
		this.reponsepossibles = reponsepossibles;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", enonce=" + enonce + ", multiple=" + multiple + ", questionnaires="
				+ questionnaires + ", reponsepossibles=" + reponsepossibles + "]";
	}
	
}
