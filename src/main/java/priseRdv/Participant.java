package priseRdv;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
@Entity
public class Participant {

	private String name, firstname, email;
	private Collection<Nourriture> lesAllergies;
	private Collection<Nourriture> lesPreferences;
	private Collection<Sondages> lesSondagesCreer;


	public Participant(String name, String firstname, String email) {
		this.name = name;
		this.firstname = firstname;
		this.email = email;
	}

	public Participant() {

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

	@Id
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLesAllergies(Collection<Nourriture> lesAllergies) {
		this.lesAllergies = lesAllergies;
	}

	public void setLesPreferences(Collection<Nourriture> lesPreferences) {
		this.lesPreferences = lesPreferences;
	}

	public void addAllergies(Nourriture allergies) {
		lesAllergies.add(allergies);
	}

	public void addPreferences(Nourriture preferences) {
		lesPreferences.add(preferences);
	}

	@ManyToMany
	public Collection<Nourriture> getLesPreferences() {
		return lesPreferences;
	}

	@OneToMany(mappedBy="createurSondage")
	public Collection<Sondages> getLesSondagesCreer() {
		return lesSondagesCreer;
	}

	public void setLesSondagesCreer(Collection<Sondages> lesSondagesCreer) {
		this.lesSondagesCreer = lesSondagesCreer;
	}



	@ManyToMany
	public Collection<Nourriture> getLesAllergies() {
		return lesAllergies;
	}

}
