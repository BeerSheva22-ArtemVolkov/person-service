package telran.spring.person.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Getter;

@Getter
// use = Id.NAME: Указывает, что информация о типе будет храниться в виде имени класса. То есть, в JSON будет создано свойство "type", которое будет содержать имя класса объекта.
// include = As.PROPERTY: Говорит, что информация о типе будет включена как свойство JSON объекта.
// property = "type": Указывает имя свойства, в котором будет храниться информация о типе.
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
// Возможные подтипы
@JsonSubTypes({ @Type(name = "child", value = ChildDto.class), @Type(name = "employee", value = EmployeeDto.class),
		@Type(name = "person", value = PersonDto.class) })
public class PersonDto {
	Integer id;
	String name;
	LocalDate birthDate;
	AddressDto address;
}