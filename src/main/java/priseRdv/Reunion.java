package priseRdv;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jpa.EntityManagerHelper;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Entity
@NamedQueries({ @NamedQuery(name = "Reunion.findAll", query = "SELECT r FROM Reunion r"),
		@NamedQuery(name = "Reunion.findById", query = "SELECT r FROM Reunion r  WHERE r.id = :id") })
public class Reunion {

	private int id;
	private String intitule, resume, lieu, clearCode;
	private boolean pause;
	private Collection<Participant> ParticipantAbsent;
	private Collection<Participant> ParticipantPresent;
	private Sondages leSondage;
	private Date dateReunion;
	static EntityManagerHelper manager ;

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

	@OneToOne(mappedBy = "reunion")
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

	public static void sauvgarder(Reunion r) {
		try {
			manager.beginTransaction();
			  manager.getEntityManager().persist(r);
			  manager.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<Reunion> getReunionList() {

		try {

			return manager.getEntityManager().createNamedQuery("Reunion.findAll").getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void remove(Long idReunion) {
		try {
			manager.beginTransaction();
			Reunion laReunion = (Reunion) manager.getEntityManager().createNamedQuery("Reunion.findById")
					.setParameter(":id", idReunion).getSingleResult();
			manager.getEntityManager().remove(laReunion);
			manager.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Reunion getById(Long idReunion) {
		try {
			
			Reunion laReunion = (Reunion) manager.getEntityManager().createNamedQuery("Reunion.findById")
					.setParameter(":id", idReunion).getSingleResult();
			return laReunion;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
