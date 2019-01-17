package priseRdv;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.util.Collection;

import javax.persistence.Entity;


@Entity
public class Reunion {

	@Id 
	@GeneratedValue
	int id;
	
	String intitule, resume, lieu, clearCode;
	
	boolean pause;
	
	@ManyToMany
	Collection<Participant> ParticipantPresent;
	
	@ManyToMany
	Collection<Participant> ParticipantAbsent;
	
	@ManyToOne
	Sondages s;
	
}
