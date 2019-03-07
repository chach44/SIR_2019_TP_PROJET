package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}
