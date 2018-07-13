package ar.edu.info.unlp.bd2.etapa2.service.impl;
import ar.edu.info.unlp.bd2.etapa2.repository.AirBdbRepository;
import ar.edu.info.unlp.bd2.etapa2.repository.*;
import ar.edu.info.unlp.bd2.etapa2.service.AirBdbService;
import ar.edu.info.unlp.bd2.etapa2.utils.ReservationCount;
import ar.edu.info.unlp.bd2.etapa2.exceptions.*;
import ar.edu.info.unlp.bd2.etapa2.model.*;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AirBdbServiceImpl implements AirBdbService {
	@Autowired
	private AirBdbRepository airbdbRepository;
	@Autowired 
	private MongoTemplate mongoTemp;


	
	public AirBdbServiceImpl (AirBdbRepository repository) {
		this.airbdbRepository=repository;
	}
	
	@Override
	public void clearDb () {
		this.mongoTemp.getDb().drop();
	}
	
	 @Override
	public User createUser(String username, String name) throws RepeatedUsernameException{
		User new_user = new User(username,name);
		this.airbdbRepository.getUserRepository().createUser(new_user);
		return new_user;
		
	}
	 
	 @Override
	 public User getUserById(String id) {
		 UserRepository userRepo=this.airbdbRepository.getUserRepository();
		 return userRepo.getUserById(id);
	 }
	 
	 @Override
	 public  User getUserByUsername(String email) {
		 UserRepository userRepo=this.airbdbRepository.getUserRepository();
		 return userRepo.getUserByUsername(email);
	 }
	 
	 
	 @Override
	 public Property createProperty(String name, String description, double price, int capacity, int rooms, String cityName) {
		 City city=new City(cityName);
		this.airbdbRepository.getCityRepository().save(city);
		 Property property=new Property(name,description,price,capacity, rooms, cityName);
		 PropertyRepository propRepo=this.airbdbRepository.getPropertyRepository();
		 propRepo.createProperty(property);
	
	     return property;
	 
	 }
	 
	 
	 @Override
	 public City getCityByName(String city) {
		 return this.airbdbRepository.getCityRepository().findByNameCity(city);
		 
	 }
	 
	 @Override
	  public List<Reservation> getReservationsForProperty(String propertyId){
		 Property prop=this.airbdbRepository.getPropertyRepository().getPropertyById(propertyId);
		 return prop.getReservations();
	 }
	 
	 
	 @Override
	 public Reservation createReservation(String propertyId, String userId, Date from, Date to, ReservationStatus initialStatus) throws ReservationException{
		
		 if(this.airbdbRepository.getReservationRepository().checkReservation(propertyId,from,to)) {
			 Property prop=this.airbdbRepository.getPropertyRepository().getPropertyById(propertyId);
			 User user=this.airbdbRepository.getUserRepository().getUserById(userId);
			 Reservation reservation= new Reservation(prop, user,from,to, initialStatus);
			 this.airbdbRepository.getReservationRepository().createReservation(reservation);
			 return reservation;
          }
		 
		 else {
	         throw new ReservationException("Last reservation should not be allowed since property is already reserved in those dates");

		 }
		  	
	 }
	 
	 
	 @Override
	 public City registerCity(String name) {
		 City city=new City(name);
		 this.airbdbRepository.getCityRepository().save(city);
		 return city;
	 }
	 
	 @Override
	 public List<City> getCitiesMatching(String content){
		 return this.airbdbRepository.getCityRepository().findByNameCityContainsOrderByNameCity(content);
	 }
	 

	 @Override
	 public List<City> getAllCities() {
		 return this.airbdbRepository.getCityRepository().findAll();
		 
	 }
	 
	 @Override
	  public List<ReservationCount> getReservationCountByStatus(){
		return this.airbdbRepository.getReservationRepository().getReservationCountByStatus();
	 }

	
	

}



