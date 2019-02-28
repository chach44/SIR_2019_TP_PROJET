package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "sondage", urlPatterns = { "/Sondage" })
public class SondageServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            
    	 PrintWriter out = resp.getWriter();
    	 int i = 1;
  	 
    	    out.println("<HTML>\n<BODY>\n" +
    	                "<H1>Sondage</H1>\n" + 
						"<FORM Method=\"POST\" Action=\"/Sondage\">"+
						"Question :         <INPUT type=text size=20 name=question"+i+"><BR>"+
						"<INPUT type=button value=Ajouter size=20 name=add><BR>"+
						"<INPUT type=hidden value="+i+" name=i><BR>"+
						"<INPUT type=submit value=Send>"+
						"</FORM>  "      +
			    	    "</BODY></HTML>");
        //ajouter du javascript pour ajouter des questions dans le form
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int i= Integer.parseInt(req.getParameter("i"));
		
		//ajouter les questions en base
		
		 PrintWriter out = resp.getWriter();
	       
		 out.println("<HTML>\n<BODY>\n" +
		 "<H1>Recapitulatif des questions : </H1>\n" +
		 "<UL>\n");
		 for(int j = 0; j<i;j++) {
			 out.println(" <LI>Question "+i+" : "
					 + req.getParameter("question"+i) + " </LI>\n" );
		 }
		 out.println("</UL>\n" +                
		 "</BODY></HTML>");
	}
}
