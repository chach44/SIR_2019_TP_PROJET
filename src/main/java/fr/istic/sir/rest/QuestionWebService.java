package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	 
	 
	 @DELETE @Path("delete/{id}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("id") String arg0) {
		 Question.remove(Long.parseLong(arg0));
	    }
	 
		@POST
		@Path("/post")
		@Consumes(MediaType.APPLICATION_JSON)
		public void createQuestion(Question laQuestion) {
			Question.sauvgarder(laQuestion);
		}
		
		 @GET @Path("search/{id}")
		    @Produces({ MediaType.APPLICATION_JSON })
		    public Question findById(@PathParam("id") String arg0) {
		        return Question.getById(Long.parseLong(arg0));
		    }
}
