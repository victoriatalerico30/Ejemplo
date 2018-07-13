package ar.edu.info.unlp.bd2.etapa2.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document (collection="reservations")
public class Reservation {

	@Id
	private String id;
	private User user;
	@DBRef
	private Property property;
	private Date start_date;
	private Date end_date;
	@Field ("status")
	private ReservationStatus reservation_status;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Property prop, User user, Date startDate, Date endDate, ReservationStatus reservationState) {
		super();
		this.user = user;
		this.property = prop;
		this.start_date = startDate;
		this.end_date = endDate;
		this.reservation_status = reservationState;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public ReservationStatus getReservation_status() {
		return reservation_status;
	}

	public void setReservation_status(ReservationStatus reservation_status) {
		this.reservation_status = reservation_status;
	}


	public double getPrice() {
		long diff = (this.end_date.getTime() - this.start_date.getTime());
		return this.property.getPrice() * TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
}
