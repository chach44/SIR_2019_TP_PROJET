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

import priseRdv.Reponse;




@Path("/Reponse")
public class ReponseWebService {
	 @GET
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Collection<Reponse> list() {
	        return Reponse.getReponseList();
	    }
	 
	 
	 @DELETE @Path("delete/{id}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("id") String arg0) {
		 Reponse.remove(Long.parseLong(arg0));
	    }
	 
	 @POST
		@Path("/post")
		@Consumes(MediaType.APPLICATION_JSON)
		public void createReponse(Reponse laRep) {
		 Reponse.sauvgarder(laRep);
		}
	 
	 @GET @Path("search/{id}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Reponse findById(@PathParam("id") String arg0) {
	        return Reponse.getById(Long.parseLong(arg0));
	    }
}
