package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}
