package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import priseRdv.Question;

@Path("/Question")
public class QuestionWebService {
	 @GET
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Collection<Question> list() {
	        return Question.getQuestionList();
	    }
}