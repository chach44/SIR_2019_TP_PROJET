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
  	 
    	    out.println("<HTML>\n<BODY>\n" +
    	                "<H1>Sondage</H1>\n" + 
			"<FORM Method=\"POST\" Action=\"/Participant\">"+
			"Name :         <INPUT type=text size=20 name=name><BR>"+
			"Firstname :     <INPUT type=text size=20 name=firstname><BR>"+
			"email :     <INPUT type=text size=25 name=email><BR>"+
			"<INPUT type=submit value=Send>"+
			"</FORM>  "      +
    	    "</BODY></HTML>");
        
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
