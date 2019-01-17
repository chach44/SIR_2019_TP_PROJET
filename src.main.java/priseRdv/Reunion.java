package priseRdv;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.util.Collection;

import javax.persistence.Entity;


@Entity
public class Reunion {

	int id;
	String intitule, resume, lieu, clearCode;
	boolean pause;
	Collection<Participant> ParticipantPresent;
	Collection<Participant> ParticipantAbsent;
	Sondages s;

	@Id 
	@GeneratedValue
	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private String getIntitule() {
		return intitule;
	}

	private void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	private String getResume() {
		return resume;
	}

	private void setResume(String resume) {
		this.resume = resume;
	}

	private String getLieu() {
		return lieu;
	}

	private void setLieu(String lieu) {
		this.lieu = lieu;
	}

	private String getClearCode() {
		return clearCode;
	}

	private void setClearCode(String clearCode) {
		this.clearCode = clearCode;
	}

	private boolean isPause() {
		return pause;
	}

	private void setPause(boolean pause) {
		this.pause = pause;
	}
	@ManyToMany(mappedBy="ParticipantPresent")
	private Collection<Participant> getParticipantPresent() {
		return ParticipantPresent;
	}

	private void setParticipantPresent(Collection<Participant> participantPresent) {
		ParticipantPresent = participantPresent;
	}
	@ManyToMany(mappedBy="ParticipantAbsent")
	private Collection<Participant> getParticipantAbsent() {
		return ParticipantAbsent;
	}

	private void setParticipantAbsent(Collection<Participant> participantAbsent) {
		ParticipantAbsent = participantAbsent;
	}
	@ManyToOne
	private Sondages getS() {
		return s;
	}

	private void setS(Sondages s) {
		this.s = s;
	}
	
}
