package ar.edu.info.unlp.bd2.etapa2.repository;
import org.springframework.beans.factory.annotation.Autowired;

public class AirBdbRepository {	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PropertyRepository propertyRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	

	public AirBdbRepository(){
		
		
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}
	
	public PropertyRepository getPropertyRepository() {
		return propertyRepository;
	}
	public CityRepository getCityRepository() {
		return cityRepository;
	}

	public ReservationRepository getReservationRepository() {
		return reservationRepository;
	}

}
