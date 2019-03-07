package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import priseRdv.Participant;

@Path("/Participant")
public class ParticipantWebService {

	 @GET
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Collection<Participant> list() {
	        return Participant.getParticipantList();
	    }
	
}
