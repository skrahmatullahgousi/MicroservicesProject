package com.concepts.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bookingentity {
	@Id
	@GeneratedValue
	int bookingid;
	String CoustmerName;
	String day;
	int pohnenuber;
	@JsonFormat(pattern = "dd/MM/yyyy")
	Date date;
	String email;
	String todaytopic;

}
