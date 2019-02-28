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
    	 int intDate = 1;
    	 int intQuestion = 1;
  	 
    	    out.println("<HTML>\n<BODY>\n" +
    	                "<H1>Sondage</H1>\n" + 
						"<FORM Method=\"POST\" Action=\"/Sondage\">"+
						"Date Réunion : <INPUT type=text size=30 name=date"+intDate+"><BR>"+
						"<INPUT type=button value=Ajouter date size=20 name=addDate><BR>"+
						"<INPUT type=hidden value="+intDate+" name=intDate><BR>"+
						"Question :         <INPUT type=text size=70 name=question"+intQuestion+"><BR>"+
						"<INPUT type=button value=Ajouter question size=20 name=addQuestion><BR>"+
						"<INPUT type=hidden value="+intQuestion+" name=intQuestion><BR>"+
						"<INPUT type=submit value=Send>"+
						"</FORM>  "      +
			    	    "</BODY></HTML>");
        //ajouter du javascript pour ajouter des questions/dates dans le form
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int intDate= Integer.parseInt(req.getParameter("intDate"));
		int intQuestion= Integer.parseInt(req.getParameter("intQuestion"));
		
		//ajouter les questions en base
		
		 PrintWriter out = resp.getWriter();
	       
		 out.println("<HTML>\n<BODY>\n" +
		 "<H1>Recapitulatif des questions : </H1>\n" +
		 "<UL>\n");
		 for(int j = 0; j<intQuestion;j++) {
			 out.println(" <LI>Question "+intQuestion+" : "
					 + req.getParameter("question"+intQuestion) + " </LI>\n" );
		 }
		 out.println("</UL>\n" +     
		 "<UL>\n");
		 for(int i = 0; i<intDate;i++) {
			 out.println(" <LI>Date "+intDate+" : "
					 + req.getParameter("date"+intDate) + " </LI>\n" );
		 }
		 out.println("</UL>\n" +           
		 "</BODY></HTML>");
	}
}
