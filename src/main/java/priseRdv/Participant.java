package priseRdv;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Participant {

	private String name, firstname, email;
	private Collection<Nourriture> lesAllergies;
	private Collection<Nourriture> lesPreferences;

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
	public Collection<Nourriture> getlesAllergies() {
		return lesAllergies;
	}
	@ManyToMany
	public Collection<Nourriture> getLesPreferences(){
		return lesPreferences;
	}
	
	@Override
	public String toString() {
		return "Participant [name=" + name + ", firstname=" + firstname + ", email=" + email ;
	}

}
