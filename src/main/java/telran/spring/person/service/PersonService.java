package telran.spring.person.service;

import telran.spring.person.dto.AddressDto;
import telran.spring.person.dto.CityPopulationDto;
import telran.spring.person.dto.PersonDto;

public interface PersonService {

	Boolean addPerson(PersonDto personDto);

	PersonDto findPersonById(Integer id);

	PersonDto removePerson(Integer id);

	PersonDto updatePersonName(Integer id, String name);

	PersonDto updatePersonAddress(Integer id, AddressDto addressDto);

	Iterable<PersonDto> findPersonsByCity(String city);

	Iterable<PersonDto> findPersonsByName(String name);

	Iterable<PersonDto> findPersonsBetweenAge(Integer minAge, Integer maxAge);

	Iterable<CityPopulationDto> getCitiesPopulation();

	Iterable<PersonDto> findEmployeeBySalary(int min, int max);

	Iterable<PersonDto> getChildren();
}
