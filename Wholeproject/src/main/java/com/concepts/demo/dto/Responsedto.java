package com.concepts.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Responsedto {
	int bookingid;
	String CoustmerName;
	String day;
	int pohnenuber;
	@JsonFormat(pattern = "dd/MM/yyyy")
	Date date;
	String email;
	String todaytopic;
}
