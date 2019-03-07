package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "reunion", urlPatterns = { "/Reunion" })
public class ReunionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try (PrintWriter out = resp.getWriter();) {

			out.println("\"<!DOCTYPE html><HTML><BODY>"+
					"<H1>Ajouter une nouvelle reunion</H1>"+
					"<FORM Method=\"POST\" Action=\"/Reunion\">"
					+ "</BODY></HTML>"
					);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
