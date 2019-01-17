package priseRdv;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Participant {

	String name;
	String firstname;
	
	@Id
	String email;

	@OneToMany(mappedBy = "participant")
	Collection<ListeReponse> reponses;
	
	public Participant() {
	}

	public Participant(String name, String firstname, String email) {
		this.name = name;
		this.firstname = firstname;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public Collection<ListeReponse> getReponses() {
		return reponses;
	}

	public void setReponses(Collection<ListeReponse> reponses) {
		this.reponses = reponses;
	}

	@Override
	public String toString() {
		return "Participant [name=" + name + ", firstname=" + firstname + ", email=" + email + ", reponses=" + reponses
				+ "]";
	}

}
