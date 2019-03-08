package priseRdv;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import jpa.EntityManagerHelper;

@Entity
@NamedQueries({ @NamedQuery(name = "Nourriture.findAll", query = "SELECT n FROM Nourriture n"),
		@NamedQuery(name = "Nourriture.findById", query = "SELECT n FROM Nourriture n where n.idAliment = :idAliment ") })
public class Nourriture {

	public int idAliment;
	public String nomAliment;
	static EntityManagerHelper manager ;

	public Nourriture(String nomAliment) {
		this.nomAliment = nomAliment;
	}

	@Id
	@GeneratedValue
	public int getIdAliment() {
		return idAliment;
	}

	public void setIdAliment(int idAliment) {
		this.idAliment = idAliment;
	}

	public String getNomAliment() {
		return nomAliment;
	}

	public void setNomAliment(String nomAliment) {
		this.nomAliment = nomAliment;
	}

	public static void sauvgarder(Nourriture n) {
		try {
			  manager.beginTransaction();
			  manager.getEntityManager().persist(n);
			  manager.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<Nourriture> getNourritureList() {
		try {
		
			return manager.getEntityManager().createNamedQuery("Nourriture.findAll").getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void remove(int id) {
		try {
			 manager.beginTransaction();
			Nourriture laNourriture = (Nourriture) manager.getEntityManager()
					.createNamedQuery("Nourriture.findById").setParameter(":idAliment", id).getSingleResult();
			manager.getEntityManager().remove(laNourriture);
			manager.commit();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public static Nourriture getById(int id) {
		try {
		
			Nourriture laNourriture = (Nourriture) manager.getEntityManager()
					.createNamedQuery("Nourriture.findById").setParameter(":idAliment", id).getSingleResult();
			return laNourriture;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
