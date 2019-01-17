package priseRdv;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class Reunion {

	@Id 
	@GeneratedValue
	int id;
	
	String intitule, resume, lieu, clearCode;
	
	boolean pause;
}
