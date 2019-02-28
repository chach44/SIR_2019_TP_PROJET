package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="userinfo",
urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {

	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            
    	 PrintWriter out = resp.getWriter();
  	 
    	    out.println("<HTML>\n<BODY>\n" +
    	                "<H1>User</H1>\n" + 
						"Nom : toto"    + //aller chercher le nom en base
						"Prenom : toto"    + //aller chercher le prenom en base
						"Mail : toto.toto@gmail.com"    + //idem
			    	    "</BODY></HTML>");
        
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

    
		out.println("<HTML>\n<BODY>\n" +
		            "<H1>Recapitulatif des informations</H1>\n" +
		            "<UL>\n" +            
		    " <LI>Nom: "
		            + request.getParameter("name") + "\n" +
		            " <LI>Prenom: "
		            + request.getParameter("firstname") + "\n" +
		            " <LI>Age: "
		            + request.getParameter("age") + "\n" +
		            "</UL>\n" +                
		    "</BODY></HTML>");
	}
}
