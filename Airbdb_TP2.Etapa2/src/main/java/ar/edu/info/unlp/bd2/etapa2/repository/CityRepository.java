package ar.edu.info.unlp.bd2.etapa2.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import ar.edu.info.unlp.bd2.etapa2.model.City;

public interface  CityRepository extends MongoRepository<City,String> {
	City findByNameCity(String nameCity);
    List<City> findByNameCityContainsOrderByNameCity(String content);
}
