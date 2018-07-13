package ar.edu.info.unlp.bd2.etapa2.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection="cities")
public class City {

	
	@Id
	private String id;
	private String nameCity;
	private List<Reservation> reservations;
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public City(String name) {
		this.nameCity=name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getName() {
		return nameCity;
	}

	public void setName(String name) {
		this.nameCity = name;
	}
	
}
