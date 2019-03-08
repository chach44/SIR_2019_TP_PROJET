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

import priseRdv.ListeReponse;

@Path("/ListeReponse")
public class ListeReponseWebService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Collection<ListeReponse> list() {
		return ListeReponse.getListReponseList();
	}

	@DELETE
	@Path("delete/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public void deleteById(@PathParam("id") String arg0) {
		ListeReponse.remove(Long.parseLong(arg0));
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createListeReponse(ListeReponse listeRep) {
		ListeReponse.sauvgarder(listeRep);
	}
	
	 @GET @Path("search/{id}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public ListeReponse findById(@PathParam("id") String arg0) {
	        return ListeReponse.getById(Long.parseLong(arg0));
	    }
}
