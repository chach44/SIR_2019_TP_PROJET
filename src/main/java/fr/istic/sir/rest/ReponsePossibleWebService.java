package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import priseRdv.ReponsePossible;

@Path("/ReponsePossible")
public class ReponsePossibleWebService {

	 @GET
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Collection<ReponsePossible> list() {
	        return ReponsePossible.getReponsePossibleList();
	    }
	
}
