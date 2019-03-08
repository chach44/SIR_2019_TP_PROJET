package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priseRdv.Nourriture;
import priseRdv.Participant;

@WebServlet(name = "nourriture", urlPatterns = { "/Nourriture" })
public class NourritureServlet extends HttpServlet {
	private EntityManager manager;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter p = new PrintWriter(resp.getOutputStream());

		p.println("<HTML>\n<BODY>\n" + "<H1>Les aliments</H1>\n");
		for (Nourriture n : Nourriture.getNourritureList()) {
			p.println("Nom : " + n.getNomAliment());
		}
		p.println(" <br> <a href=\"http://localhost:8080/index.html\">retour menu</a>"
				+ "</BODY></HTML>");
		p.flush();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des Aliments</H1>\n" + "<UL>\n" + " <LI>Nom: "
				+ req.getParameter("nom") + "\n" + " <br> <a href=\"http://localhost:8080/index.html\">retour menu</a>"
				+ "</BODY></HTML>");
		Nourriture.sauvgarder(new Nourriture(req.getParameter("nom")));

	}
}
