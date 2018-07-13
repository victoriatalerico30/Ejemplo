package ar.edu.info.unlp.bd2.etapa2.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="users")
public class User {

	@Id
	private String id;
	
	private String username;
	private String name;
	@DBRef
	private List<Reservation> reservations;
	private List<Property> properties;
	
	public User(){
		super();
	
	}
	
	public User(String userName,String name) {
		this.reservations = new ArrayList<Reservation>();
		this.properties= new ArrayList<Property>();
		this.name=name;
		this.username=userName;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getUsername() {
		return this.username;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}
	
	public void addReservation(Reservation res) {
		this.reservations.add(res);
	}


	
}
