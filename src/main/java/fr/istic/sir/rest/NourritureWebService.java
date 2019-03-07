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

import priseRdv.Nourriture;


@Path("/Nourriture")
public class NourritureWebService {

	 @GET
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Collection<Nourriture> list() {
	        return Nourriture.getNourritureList();
	    }
	 
	 
	 @DELETE @Path("delete/{id}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("id") String arg0) {
		 Nourriture.remove(Integer.parseInt(arg0));
	    }

		@POST
		@Path("/post")
		@Consumes(MediaType.APPLICATION_JSON)
		public void createNourriture(Nourriture laNourriture) {
			Nourriture.sauvgarder(laNourriture);
		}
}
