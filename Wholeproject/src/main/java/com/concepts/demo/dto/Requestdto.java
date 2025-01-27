package com.concepts.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Requestdto {

	@NotBlank
	String CoustmerName;
	@NotEmpty
	String day;
	@NotNull
	int pohnenuber;
	@JsonFormat(pattern = "dd/MM/yyyy")
	Date date;
	@Email
	String email;
	String todaytopic;
}
