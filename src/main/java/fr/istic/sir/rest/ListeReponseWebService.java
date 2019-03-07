package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import priseRdv.ListeReponse;
@Path("/ListeReponse")
public class ListeReponseWebService {

	
	 @GET
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Collection<ListeReponse> list() {
	        return ListeReponse.getListReponseList();
	    }
	
}
