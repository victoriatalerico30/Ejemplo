package ar.edu.info.unlp.bd2.etapa2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document (collection="properties") 
public class Property {

	@Id
	private String id;
	private Integer rooms;
	private List<Reservation> reservations;
	private String city;
	private String name;	
	private String description;
	private double price_per_night;
	private Integer capacity;
	
	public Property(){
		super();
		
	}
	
	public Property(String name, String description, double price_per_night, int capacity, int rooms, String cityName) {
		this.city = cityName;
		this.name = name;
		this.description = description;
		this.price_per_night = price_per_night;
		this.capacity = capacity;
		this.rooms=rooms;
		this.reservations = new ArrayList<Reservation>();
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price_per_night;
	}

	public void setPrice(double price_per_night) {
		this.price_per_night = price_per_night;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public Integer getRooms() {
		return rooms;
	}

	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}
	
	public void addReservations(Reservation res) {
		reservations.add(res);
	}


}
