package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priseRdv.ListeReponse;
import priseRdv.Nourriture;
import priseRdv.Participant;
import priseRdv.Sondages;

@WebServlet(name = "Participant", urlPatterns = { "/Participant" })
public class ParticipantServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<HTML>\n<BODY>\n" + "<H1>Les participants</H1>\n");
		for (Participant p : Participant.getParticipantList()) {
			out.println("Nom : " + p.getName() + " "+ p.getFirstname());
		}
		out.println(" <br> <a href=\"http://localhost:8080/index.html\">retour menu</a>"
				+ "</BODY></HTML>");
		out.flush();


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Participant participant = new Participant(req.getParameter("name"), req.getParameter("firstname"),
				req.getParameter("email"));
		Participant.sauvgarder(participant);

	//	Sondages sondage = Sondages.findById(req.getParameter("firstname"));

	//	ListeReponse.sauvgarder(new ListeReponse(participant, sondage));

		//PrintWriter out = resp.getWriter();

	//	out.println("<HTML>\n<BODY>\n" + "<H1>Reponse au sondage :</H1>\n" + req.getParameter("nom_prenom")
	//			+ " a repondu !" + "</BODY></HTML>");

	}
}
