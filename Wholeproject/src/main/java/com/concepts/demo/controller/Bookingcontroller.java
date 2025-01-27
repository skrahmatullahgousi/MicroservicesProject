package com.concepts.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.concepts.demo.userexception.CustomNotFoundException;
import com.concepts.demo.userexception.Handlingpredefined;
import com.concepts.demo.dto.Requestdto;
import com.concepts.demo.dto.Responsedto;
import com.concepts.demo.entity.Bookingentity;
import com.concepts.demo.exceptionhandle.Euniversalhandler;
import com.concepts.demo.feign.Acess;
import com.concepts.demo.service.Bookingservice;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/thispath")
public class Bookingcontroller {
	@Autowired
	Acess fobj;
	@Autowired
	Bookingservice bs;
	@Autowired
	Euniversalhandler exobj;

	@PostMapping("/postdetails")
	public Responsedto postdetails(@Valid @RequestBody Requestdto reqdto) {

		return bs.postdetails(reqdto);
	}

	@GetMapping("/getdetailsbyid/{id}")
	public Responsedto getalldetailsbyid(@Valid @PathVariable int id) {
		Responsedto res = bs.getalldetailsbyid(id);

		if (res == null) {
			throw new CustomNotFoundException("the data is not found with the id" + id);
		}
		return res;
	}

	@GetMapping("/getalladetails")
	public List<Responsedto> getalldetails() {
		return bs.getalldetails();
	}

	@PutMapping("/updatedetails/{id}")
	public Responsedto updatedetails(@Valid @PathVariable int id, @RequestBody Requestdto rd) {
		if (bs.updatedetails(id, rd) == null) {
			throw new Handlingpredefined("the id is not valid" + id, HttpStatus.BAD_REQUEST.value());

		}
		return bs.updatedetails(id, rd);

	}

	@DeleteMapping("/deletebyid/{id}")
	public String deletebyid(@Valid @PathVariable int id) {

		return bs.deletebyid(id);

	}

	@GetMapping("/getdetailsbypagenation")
	Page<Bookingentity> allpagedetails(@RequestParam int pageno, @RequestParam int pagerecord,
			@RequestParam String feild) {
		return bs.allpagedetails(pageno, pagerecord, feild);
	}

	@GetMapping("/returnstring")
	public String callservice() {
		return fobj.callservice();
	}
}
