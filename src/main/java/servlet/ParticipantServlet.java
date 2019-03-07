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

@WebServlet(name="Participant",
urlPatterns={"/Participant"})
public class ParticipantServlet extends HttpServlet {

	private EntityManager manager;
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("text/html");
    	 PrintWriter out = resp.getWriter();
    	 
    	 
    	 //Connexion à la base
    		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
    		EntityManager manager = factory.createEntityManager();
    		// Req qui va chercher toutes les réponses pour le sondage
//    		List<ListeReponse> ListPrecedenteReponse = manager.createQuery("SELECT r FROM ListeReponse r WHERE r.sondage = :idSondage")
//    			 .setParameter("idSondage", "1") //idSondage
//    			 .getResultList();
    	 
    	    out.println("<HTML>\n<BODY>\n" +
	                "<H1>Participant</H1>\n" + 
	                "<FORM Method=\"POST\" Action=\"/Participant\">"+
	                "<table>" 
	                
	                // Construction du header
				      + "<thead>"+
				       "<tr>"+
				       	   "<th colspan=\"1\">Nom \\ Date</th>"+
				           "<th colspan=\"1\">22/12/19</th>"+
				           "<th colspan=\"1\">23/12/19</th>"+
				           "<th colspan=\"1\">24/12/19</th>"+
				           "<th colspan=\"1\">25/12/19</th>"+
				       "</tr>"+
				   "</thead>"+		
				    		
				 "<tbody>"+
				  "<tr>");
    	    
    	    out.println("<td><INPUT type=text size=20 name=nom_prenom ></td>");
    		
//    		// construction du tableau des réponses déjà effectué
//    		for (ListeReponse laRep : ListPrecedenteReponse) 
//    		{ 
//    			 out.println("<td><INPUT type=text size=20 name=nom_prenom value="+laRep.getParticipant().getFirstname()+"></td>");
//    			
//    			laRep.getReponses();
//    		}

  	 
    	 //Exemple de lien participant
    	
 			                  
    		out.println("<td><input type=\"checkbox\" id=\"date1\"></td>"+
 			                   "<td><input type=\"checkbox\" id=\"date2\"></td>"+
 			                   "<td><input type=\"checkbox\" id=\"date3\"></td>"+
 			                   "<td><input type=\"checkbox\" id=\"date4\"></td>"+
 			                   "<td><INPUT type=submit value=Send></td>"+
 			               "</tr>"+
 			           "</tbody>"+
 				       "</table>" +
						"</FORM>  "      +
			    	    "</BODY></HTML>");
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    	
    	TypedQuery<Sondages> sondage;
    	
    	Participant part = new Participant(req.getParameter("name"), req.getParameter("firstname"), req.getParameter("email"));
    	
    	manager.persist(part);
    	
    	sondage = manager.createQuery("SELECT * from SONDAGES WHERE id="+req.getParameter("idSondage"), Sondages.class);
    	
    	Sondages s = sondage.getSingleResult();
    	
    	manager.persist(new ListeReponse(part, s));
        
    	//Participant p = new Participant(req.getParameter("name"), req.getParameter("firstname"), req.getParameter("email"));
        
    	//mettre les reponses en base 
       PrintWriter out = resp.getWriter();
       
       out.println("<HTML>\n<BODY>\n" +
	               "<H1>Reponse au sondage :</H1>\n" +
	               req.getParameter("nom_prenom")+" a repondu !"+
    		  	   "</BODY></HTML>");

        
    }    
}

