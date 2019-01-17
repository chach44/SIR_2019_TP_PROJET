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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getClearCode() {
		return clearCode;
	}

	public void setClearCode(String clearCode) {
		this.clearCode = clearCode;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public Collection<Participant> getParticipantPresent() {
		return ParticipantPresent;
	}

	public void setParticipantPresent(Collection<Participant> participantPresent) {
		ParticipantPresent = participantPresent;
	}

	public Collection<Participant> getParticipantAbsent() {
		return ParticipantAbsent;
	}

	public void setParticipantAbsent(Collection<Participant> participantAbsent) {
		ParticipantAbsent = participantAbsent;
	}

	public Sondages getS() {
		return s;
	}

	public void setS(Sondages s) {
		this.s = s;
	}
	
}
