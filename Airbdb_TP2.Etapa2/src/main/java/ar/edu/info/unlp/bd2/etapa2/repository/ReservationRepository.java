package ar.edu.info.unlp.bd2.etapa2.repository;



import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ar.edu.info.unlp.bd2.etapa2.utils.*;
import ar.edu.info.unlp.bd2.etapa2.model.Reservation;
import ar.edu.info.unlp.bd2.etapa2.model.User;
import ar.edu.info.unlp.bd2.etapa2.model.Property;

public class ReservationRepository {
	@Autowired
	private MongoTemplate mongoTemp;
	
	public ReservationRepository() {
		
	}
	
	public boolean checkReservation(String property_id, Date from, Date to) {
		//verify that the property is not reserved for the date
	 Query query = new Query(Criteria.where("property").is(property_id) .and("start_date").lt(to).and("end_date").gt(from));
      return ((this.mongoTemp.count(query, Reservation.class))==0);
	}
	
	public void createReservation(Reservation res) {
		this.mongoTemp.insert(res);
		User user=res.getUser();
		user.addReservation(res);
		Property prop=res.getProperty();
		prop.addReservations(res);
		this.mongoTemp.save(user);
		this.mongoTemp.save(prop);
	}
	
	public List<ReservationCount> getReservationCountByStatus(){
		 GroupOperation groupByReserStatus = group("status").count().as("countByStatus");
		 ProjectionOperation projectStage =project().andExpression("_id").as("status").andExpression("countByStatus").as("count");
	     return this.mongoTemp.aggregate(newAggregation(groupByReserStatus,projectStage), "reservations", ReservationCount.class).getMappedResults();
	}
}
