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
	private Collection<ReponsePossible> reponsepossibles;

	public Question(String enonce, boolean multiple ) {
		this.enonce =  enonce;
		this.multiple = multiple;
	}
	
	public Question( ) {
		
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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


	@OneToMany
	public Collection<ReponsePossible> getReponsepossibles() {
		return reponsepossibles;
	}

	public void setReponsepossibles(Collection<ReponsePossible> reponsepossibles) {
		this.reponsepossibles = reponsepossibles;
	}

	public void addReponsePossible(ReponsePossible reponseP) {
		this.reponsepossibles.add(reponseP);
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", enonce=" + enonce + ", multiple=" + multiple + ", reponsepossibles=" + reponsepossibles + "]";
	}
	
}
