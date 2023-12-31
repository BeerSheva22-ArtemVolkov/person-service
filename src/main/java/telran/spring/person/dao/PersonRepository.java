package telran.spring.person.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import telran.spring.person.dto.CityPopulationDto;
import telran.spring.person.model.Child;
import telran.spring.person.model.Employee;
import telran.spring.person.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

	// Person - нужно использовать имя которое описано в @Entity(name = <...>) в классе Person
	@Query("select p from Person p where p.name=?1") // ?1 - первый аргумент из метода findByName(String name)
	Stream<Person> findByName(String name);

	@Query("select p from Person p where p.address.city=:city")
	Stream<Person> findByAddressCity(@Param("city") String city);

	Stream<Person> findByBirthDateBetween(LocalDate from, LocalDate to);

	@Query("select new telran.spring.person.dto.CityPopulationDto(p.address.city, count(p)) from Person p group by p.address.city order by count(p) desc")
	List<CityPopulationDto> getCitiesPopulation();

//	@Query("select e from Employee e where e.salary between ?1 and ?2")
	Stream<Employee> findBySalaryBetween(int min, int max);

//	@Query("select c from Child c")
	Stream<Child> findChildrenBy();

}
