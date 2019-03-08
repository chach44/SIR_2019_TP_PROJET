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

import priseRdv.Reunion;

@Path("/Reunion")
public class ReunionWebService {
	 @GET
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Collection<Reunion> list() {
	        return Reunion.getReunionList();
	    }
	 
	 
	 @DELETE @Path("delete/{id}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("id") String arg0) {
		 Reunion.remove(Long.parseLong(arg0));
	    }
	 
	 
	 @POST
		@Path("/post")
		@Consumes(MediaType.APPLICATION_JSON)
		public void createRenuion(Reunion laReunion) {
		 Reunion.sauvgarder(laReunion);
		}
	 
	 @GET @Path("search/{id}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Reunion findById(@PathParam("id") String arg0) {
	        return Reunion.getById(Long.parseLong(arg0));
	    }
}
