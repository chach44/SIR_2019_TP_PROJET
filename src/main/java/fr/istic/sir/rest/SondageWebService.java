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

import priseRdv.Sondages;

@Path("/Sondage")
public class SondageWebService {
	 @GET
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Collection<Sondages> list() {
	        return Sondages.getSondagesList();
	    }
	 
	 @DELETE @Path("delete/{id}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("id") String arg0) {
	         Sondages.remove(Long.parseLong(arg0));
	    }
	 
	 @POST
		@Path("/post")
		@Consumes(MediaType.APPLICATION_JSON)
		public void createSondage(Sondages leSondage) {
		 Sondages.sauvgarder(leSondage);
		}
	 
	 @GET @Path("search/{id}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Sondages findById(@PathParam("id") String arg0) {
	        return Sondages.getById(Long.parseLong(arg0));
	    }

}
