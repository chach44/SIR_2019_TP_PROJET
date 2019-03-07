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


import priseRdv.ReponsePossible;

@Path("/ReponsePossible")
public class ReponsePossibleWebService {

	 @GET
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Collection<ReponsePossible> list() {
	        return ReponsePossible.getReponsePossibleList();
	    }
	 
	 @DELETE @Path("delete/{id}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteById(@PathParam("id") String arg0) {
		 ReponsePossible.remove(Long.parseLong(arg0));
	    }
	 
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createReponsePossible(ReponsePossible laRepPossible) {
		ReponsePossible.sauvgarder(laRepPossible);
	}
}
