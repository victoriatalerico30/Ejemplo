package ar.edu.info.unlp.bd2.etapa2.repository;

import ar.edu.info.unlp.bd2.etapa2.exceptions.RepeatedUsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ar.edu.info.unlp.bd2.etapa2.model.*;

public class UserRepository {

	@Autowired
	private MongoTemplate mongoTemp;

	public UserRepository() {
		
	}
	
	
    public User getUserById(String id) {
       Query query = new Query(Criteria.where("_id").is(id));
       return this.mongoTemp.findOne(query, User.class, "users");
    }

    public User getUserByUsername(String email) {
        Query query = new Query(Criteria.where("username").is(email));
        User user= this.mongoTemp.findOne(query, User.class, "users");
        return user;
    }
    
	public void createUser(User user) throws RepeatedUsernameException{
		 if (this.getUserByUsername(user.getUsername()) != null) {
	          throw new RepeatedUsernameException("Creating more than one user with the same username should not be allowed.");
	      }
		 else {
		  this.mongoTemp.insert(user);
		 }
	}
}
