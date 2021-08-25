package com.tesfai.sebtibeb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEMBER_TBL")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	
	@NotNull(message = "First name can't be empty")
	private String firstName;
	
	private String middleName;
	
	@NotNull(message = "Last name can't be empty")
	private String lastName;
	
	@NotNull(message = "Date of birth can't be empty")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String dateOfBirth;
	
	@NotNull(message = "Last name can't be empty")
	private String gender;
	
	@NotNull(message = "Date of birth can't be empty")
	private String martialStatus;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

}
