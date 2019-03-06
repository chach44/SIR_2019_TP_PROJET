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
	 int intDate = 1;
	 int intQuestion = 1;
	
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		resp.setContentType("text/html");
		// printWriter == Sys.out  -> flux de sortie dans lequel ont écrit
    	
		// le try catch permet de fermet le printWirte car il implémente l'interface autoclosable
		try (PrintWriter out = resp.getWriter();){
			
		    out.println("<!DOCTYPE html>\n<HTML>\n<BODY>\n" +
	                "<H1>Sondage</H1>\n" + 
					"<FORM Method=\"POST\" Action=\"/Sondage\">"+
					"Date Réunion : <INPUT type=text size=30 name=date"+intDate+"><BR>"+
					"<INPUT type=button value=Ajouter date size=20 name=addDate onclick=addField()><BR>"+
					
					"<INPUT type=hidden value="+intDate+" name=intDate><BR>"+
					"Question :         <INPUT type=text size=70 name=question"+intQuestion+"><BR>"+
					"<INPUT type=button value=Ajouter question size=20 name=addQuestion onclick=addQuestion()><BR>"+
					"<INPUT type=hidden value="+intQuestion+" name=intQuestion><BR>"+
					"<INPUT type=submit value=Send>"+
					"</FORM>  "      +
		    	    "<SCRIPT LANGUAGE=\"JavaScript\">  function  addField() {" + 
		    	    "	     var field = \"<input type='text' name=date"+intDate+1+" value=''/>;" + 
		    	    "	     document.getElementById(\"date"+intDate+").innerHtml += field;" + 	   
		    	    "	}"+
		    		
		    	    
					"function  addQuestion() {" + 
			    	    "	     var field = \"<input type='text' name=question"+intQuestion+1+" value=''/>;" + 
			    	    "	     document.getElementById(\"question"+intDate+").innerHtml += field;" + 	   
			    	    "	}"+
		    		"</script>"+
		    		"</BODY></HTML>");
		}
    	
  	 
    	
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
