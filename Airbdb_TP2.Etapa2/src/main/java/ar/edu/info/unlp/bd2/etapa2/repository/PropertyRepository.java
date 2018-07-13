package ar.edu.info.unlp.bd2.etapa2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import ar.edu.info.unlp.bd2.etapa2.model.*;

public class PropertyRepository {

	@Autowired
	private MongoTemplate mongoTemp;
	

	public PropertyRepository() {
		
	}
	
	public void createProperty(Property prop){
		 new City(prop.getCity());
		 this.mongoTemp.insert(prop);
			 
	}
	
	public Property getPropertyById(String propertyId) {
	     Query query = new Query(Criteria.where("id").is(propertyId));
	     Property prop= this.mongoTemp.findOne(query, Property.class, "properties");
	     return prop;
	}
	
}