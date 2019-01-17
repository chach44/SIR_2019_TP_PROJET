package priseRdv;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Reunion {

	@Id 
	@GeneratedValue
	int id;
	
	String intitule, resume, lieu, clearCode;
}
