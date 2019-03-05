package jpa;

import java.util.List;

import javax.persistence.*;

import priseRdv.Participant;
import priseRdv.Question;
import priseRdv.Reunion;
import priseRdv.Sondages;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createParticipants();
			test.createSondageReunion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tx.commit();

		test.listParticipants();

		manager.close();
		System.out.println(".. done");
	}

	private void createParticipants() {
		int numOfParticipant = manager.createQuery("Select p From Participant as p", Participant.class).getResultList()
				.size();
		if (numOfParticipant == 0) {
			manager.persist(new Participant("Guessant", "Thomas", "dfghjk@dfgh.fr"));
			manager.persist(new Participant("Captain", "Nemo", "sdfghjuk@ndhfyhnf.fr"));
		}
	}

	private void listParticipants() {
		List<Participant> resultList = manager.createQuery("Select p From Participant as p", Participant.class)
				.getResultList();
		System.out.println("nombre de participant:" + resultList.size());
		for (Participant next : resultList) {
			System.out.println("Le participant: " + next);
		}
	}

	private void createSondageReunion() {
		List<Question> LesQuestion = manager.createQuery("Select p From Question as p", Question.class).getResultList();

		if (LesQuestion.size() == 0) {
			Question q1 = new Question("La question 1", false);
			manager.persist(q1);
			LesQuestion.add(q1);
			Question q2 = new Question("La question 2", false);
			manager.persist(q2);
			LesQuestion.add(q2);
		}
		Reunion unReunion = new Reunion();
		manager.persist(unReunion);
		Sondages unSondage = new Sondages("Sondage sur le theme..", LesQuestion);
		unSondage.setreunion(unReunion);
		manager.persist(unSondage);
	}

}
