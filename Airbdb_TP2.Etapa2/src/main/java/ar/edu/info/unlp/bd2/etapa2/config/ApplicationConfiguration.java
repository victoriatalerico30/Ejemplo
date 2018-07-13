package ar.edu.info.unlp.bd2.etapa2.config;

import ar.edu.info.unlp.bd2.etapa2.repository.AirBdbRepository;
import ar.edu.info.unlp.bd2.etapa2.repository.UserRepository;
import ar.edu.info.unlp.bd2.etapa2.repository.PropertyRepository;
import ar.edu.info.unlp.bd2.etapa2.repository.ReservationRepository;
import ar.edu.info.unlp.bd2.etapa2.service.AirBdbService;
import ar.edu.info.unlp.bd2.etapa2.service.impl.AirBdbServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public AirBdbService createService() {
    AirBdbRepository repository = this.createRepository();
    return new AirBdbServiceImpl(repository);
  }

  @Bean
  public AirBdbRepository createRepository() {
    return new AirBdbRepository();
  }
  
  @Bean
  public PropertyRepository createPropertyRepository() {
	  return new PropertyRepository();
  }
  
  @Bean ReservationRepository createReservationRepository() {
	  return new ReservationRepository();
  }
  
  @Bean
  public UserRepository createUserRepository() {
    return new UserRepository();
  }
  
}
