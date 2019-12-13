package nl.han.icdeapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Semester {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String passportNumber;
}