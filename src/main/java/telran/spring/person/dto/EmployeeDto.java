package telran.spring.person.dto;

import lombok.Getter;

@Getter
public class EmployeeDto extends PersonDto {
	String company;
	Integer salary;

}
