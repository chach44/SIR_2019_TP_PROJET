package jpa;

import java.util.List;

import javax.persistence.*;

import priseRdv.Participant;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory =   
				Persistence.createEntityManagerFactory("manager");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createParticipants();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listEmployees();

		manager.close();
		System.out.println(".. done");
	}

	private void createParticipants() {
		int numOfParticipant = manager.createQuery("Select p From Participant as p", Participant.class).getResultList().size();
		if (numOfParticipant == 0) {
			manager.persist(new Participant("Guessant", "Thomas", "dfghjk@dfgh.fr"));
			manager.persist(new Participant("Captain", "Nemo", "sdfghjuk@ndhfyhnf.fr"));
		}
	}

	private void listParticipants() {
		List<Participant> resultList = manager.createQuery("Select p From Participant as p", Participant.class).getResultList();
		System.out.println("nombre de participant:" + resultList.size());
		for (Participant next : resultList) {
			System.out.println("Le participant: " + next);
		}
	}

}
