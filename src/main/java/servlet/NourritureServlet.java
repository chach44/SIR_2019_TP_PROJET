package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="nourriture",
urlPatterns={"/Nourriture"})
public class NourritureServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
    	
    	 PrintWriter out = resp.getWriter();
    	 int intDate = 1;
    	 int intQuestion = 1;
  	 
    	    out.println("<HTML>\n<BODY>\n" +
    	                "<H1>Nouriture</H1>\n" + 
						"<FORM Method=\"POST\" Action=\"/Nourriture\">"+
						"Nom de l'aliment: <INPUT type=text size=30 name=nom><BR>"+
						"<INPUT type=submit value=Send>"+
						"</FORM>  "      +
			    	    "</BODY></HTML>");
    	
    	
        PrintWriter p = new PrintWriter(resp.getOutputStream());
        p.print("Nourriture");
        p.flush();
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    	resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

    
		out.println("<HTML>\n<BODY>\n" +
		            "<H1>Recapitulatif de l'ajout de type de nourriture</H1>\n" +
		            "<UL>\n" +            
		    " <LI>Nom: "
		            + req.getParameter("nom") + "\n" +
		                
		    "</BODY></HTML>");
    }    
}
