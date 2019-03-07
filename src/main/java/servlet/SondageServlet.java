package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priseRdv.Participant;
import priseRdv.Question;
import priseRdv.Reponse;
import priseRdv.ReponsePossible;
import priseRdv.Sondages;

@WebServlet(name = "sondage", urlPatterns = { "/Sondage" })
public class SondageServlet extends HttpServlet {
	
	 int intDate = 1;
	 int intQuestion = 1;
	 private EntityManager manager;
	 private Collection<Question> listeQuestions;
	 private Collection<Reponse> reponse;
	
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
					"<INPUT type=checkbox  name=\"ChoixMultiple\"> <label for=\"ChoixMultiple\">Question à choix multiple ?</label><BR>"+
					 "<label for=\"reponsonse\">Réponses possible :</label>"+
					"<INPUT type=text size=70 name=\"reponsonse\"><BR>"+
					"<INPUT type=button value=Ajouter des réponses possibles size=20 name=addReponses onclick=addReponses()><BR>"+
					
					"<INPUT type=submit value=Send>"+
					"</FORM>  "      +
		    	    "<SCRIPT LANGUAGE=\"JavaScript\">  function  addField() {" + 
		    	    "	     var field = \"<input type='text' name=date"+intDate+1+" value=''/>;" + 
		    	    "	     document.getElementById(\"date"+intDate+").innerHtml += field;" + 	   
		    	    "	}"+
		    		
		    	    
					"function  addQuestion() {" + 
			    	    "	     var field = \"<input type='text' name=question"+intQuestion+1+" value=''/>;" + 
			    	    "	     document.getElementById(\"question"+intQuestion+").innerHtml += field;" + 	   
			    	    "	}"+
			    	    "function  addReponses() {" + 
			    	    "	     var field = \"<input type='text' name=question"+intQuestion+1+" value=''/>;" + 
			    	    "	     document.getElementById(\"addReponses\").innerHtml += field;" + 	   
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
		
		
		TypedQuery<Question> quest;
    	
    	for(int j = 0; j<intQuestion;j++) {
    		boolean mult = Boolean.parseBoolean(req.getParameter("mult"+intQuestion));
    		Question q = new Question(req.getParameter("question"+intQuestion), mult);
    		manager.persist(q);
    		listeQuestions.add(q);
    		if(mult) {
    			int intnbRep= Integer.parseInt(req.getParameter("nbRep")); //ATTENTION les reponses ne sont actuellement pas bien récupérées
    			for(int a = 0; a<intQuestion;a++) {
    				//reponse.add(req.getParameter("rep"));
    			}
    		}
    		
    		ReponsePossible repPo = new ReponsePossible(q,reponse);
    		manager.persist(repPo);
    	}
    	
    	Sondages s = new Sondages(req.getParameter("theme"),listeQuestions);
    	
    	manager.persist(s);
    	
    	//Sondages s = sondage.getSingleResult();
		
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
