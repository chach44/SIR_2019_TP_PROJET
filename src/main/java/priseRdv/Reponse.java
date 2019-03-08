package priseRdv;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jpa.EntityManagerHelper;

@Entity
@NamedQueries({ @NamedQuery(name = "Reponse.findAll", query = "SELECT r FROM Reponse r "),
		@NamedQuery(name = "Reponse.findById", query = "SELECT r FROM ReponsePossible r  r.id = :id ") })
public class Reponse {

	private long id;
	private Date datereponse;
	private ListeReponse reponsequestion;
	private Collection<ReponsePossible> reponsespossibles;
	static EntityManagerHelper managerHelper;

	public Reponse() {
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	public Date getDatereponse() {
		return datereponse;
	}

	public void setDatereponse(Date datereponse) {
		this.datereponse = datereponse;
	}

	@ManyToOne
	public ListeReponse getReponsequestion() {
		return reponsequestion;
	}

	public void setReponsequestion(ListeReponse reponsequestion) {
		this.reponsequestion = reponsequestion;
	}

	@ManyToMany
	public Collection<ReponsePossible> getReponsespossibles() {
		return reponsespossibles;
	}

	public void setReponsespossibles(Collection<ReponsePossible> reponsespossibles) {
		this.reponsespossibles = reponsespossibles;
	}

	public static void sauvgarder(Reponse rep) {
		try {
			managerHelper.beginTransaction();
			managerHelper.getEntityManager().persist(rep);
			managerHelper.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<Reponse> getReponseList() {
		try {
			managerHelper.beginTransaction();
			return managerHelper.getEntityManager().createNamedQuery("Reponse.findAll").getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void remove(Long id) {
		try {
			managerHelper.beginTransaction();
			Reponse laReponse = (Reponse) managerHelper.getEntityManager().createNamedQuery("Reponse.findById")
					.setParameter(":id", id).getSingleResult();
			managerHelper.getEntityManager().remove(laReponse);
			managerHelper.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Reponse getById(Long id) {
		try {
			managerHelper.beginTransaction();
			Reponse laReponse = (Reponse) managerHelper.getEntityManager().createNamedQuery("Reponse.findById")
					.setParameter(":id", id).getSingleResult();
			return laReponse;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
