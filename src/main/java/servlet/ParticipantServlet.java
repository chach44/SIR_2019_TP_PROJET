package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priseRdv.Participant;

@WebServlet(name="Participant",
urlPatterns={"/Participant"})
public class ParticipantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
    	 PrintWriter out = resp.getWriter();
    	 int i = 1;
  	 
    	 //Exemple de lien participant
    	    out.println("<HTML>\n<BODY>\n" +
    	                "<H1>Participant</H1>\n" + 
    	                "<FORM Method=\"POST\" Action=\"/Participant\">"+
    	                "<table>" +
 		               "<thead>"+
 			               "<tr>"+
 			               	   "<th colspan=\"1\">Nom \\ Date</th>"+
 			                   "<th colspan=\"1\">22/12/19</th>"+
 			                   "<th colspan=\"1\">23/12/19</th>"+
 			                   "<th colspan=\"1\">24/12/19</th>"+
 			                   "<th colspan=\"1\">25/12/19</th>"+
 			               "</tr>"+
 		               "</thead>"+
 		               "<tbody>"+
 			               "<tr>"+
 			                   "<td><INPUT type=text size=20 name=nom_prenom></td>"+
 			                   "<td><input type=\"checkbox\" id=\"date1\"></td>"+
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
    	
    	//resp.setContentType("text/html");
        
    	//Participant p = new Participant(req.getParameter("name"), req.getParameter("firstname"), req.getParameter("email"));
        
    	//mettre les reponses en base 
       PrintWriter out = resp.getWriter();
       
       out.println("<HTML>\n<BODY>\n" +
	               "<H1>Reponse au sondage :</H1>\n" +
	               req.getParameter("nom_prenom")+" a repondu !"+
    		  	   "</BODY></HTML>");

        
    }    
}

