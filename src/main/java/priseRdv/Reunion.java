package priseRdv;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Reunion {

	private int id;
	private String intitule, resume, lieu, clearCode;
	private boolean pause;
	private Collection<Participant> ParticipantAbsent;
	private Collection<Participant> ParticipantPresent;
	private Sondages leSondage;
	private Date dateReunion;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public Reunion() {
		this.ParticipantAbsent = new ArrayList<Participant>();
		this.ParticipantPresent = new ArrayList<Participant>();
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

	@ManyToMany
	public Collection<Participant> getParticipantPresent() {
		return ParticipantPresent;
	}

	public void setParticipantPresent(Collection<Participant> participantPresent) {
		ParticipantPresent = participantPresent;
	}
	
	@ManyToMany
	public Collection<Participant> getParticipantAbsent() {
		return ParticipantAbsent;
	}

	public void setParticipantAbsent(Collection<Participant> participantAbsent) {
		ParticipantAbsent = participantAbsent;
	}
	
	public void addParticipantAbsent(Participant participantAbsent) {
		ParticipantAbsent.add(participantAbsent);
	}

	public void addParticipantPresent(Participant participantPresent) {
		ParticipantPresent.add(participantPresent);
	}

	@OneToOne(mappedBy="reunion")
	public Sondages getleSondage() {
		return leSondage;
	}

	public void setleSondage(Sondages sondage) {

		this.leSondage = sondage;

	}
	 @Temporal(TemporalType.DATE)
	public Date getDateReunion() {
		return dateReunion;
	}

	public void setDateReunion(Date dateReunion) {
		this.dateReunion = dateReunion;
	}
}
