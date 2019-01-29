package fr.istic.sir.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import priseRdv.Participant;
import priseRdv.Question;
import priseRdv.Sondages;

@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getQuestions() {
        return "Hello, how are you?";
    }
    
    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Sondages getSondage() {
    	Sondages sondage = new Sondages();
    	sondage.setTitre("La viande");

        ArrayList<Question> questions = new ArrayList<Question>();
        Question q1 = new Question();
        q1.setEnonce("Aime tu le veau ?");
        questions.add(q1);
        Question q2 = new Question();
        q2.setEnonce("As tu bien gouté ?");
        questions.add(q2);
        
        sondage.setQuestions(questions);
        return sondage;
    }
    
//    
//    @GET
//    @Path("/home")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Participant getParticipant() {
//    	Participant participant = new Participant("Toto", "Titi", "toto@titi.fr");
//        
//        return participant;
//    }
}
