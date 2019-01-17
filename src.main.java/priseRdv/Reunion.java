package priseRdv;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Collection;

import javax.persistence.Entity;


@Entity
public class Reunion {

	@Id 
	@GeneratedValue
	int id;
	
	String intitule, resume, lieu, clearCode;
	
	boolean pause;
	Collection<Participant> ParticipantPresent;
	Collection<Participant> ParticipantAbsent;
}
