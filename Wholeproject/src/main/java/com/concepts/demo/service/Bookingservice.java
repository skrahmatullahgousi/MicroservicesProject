package com.concepts.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.concepts.demo.dto.Requestdto;
import com.concepts.demo.dto.Responsedto;
import com.concepts.demo.entity.Bookingentity;
import com.concepts.demo.repostitory.Bookingrepostitory;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Bookingservice {
	@Autowired
	Bookingrepostitory Repo;
	@Autowired
	ModelMapper mp;

	public Responsedto postdetails(Requestdto reqdto) {
		Bookingentity en = (mp.map(reqdto, Bookingentity.class));
		return mp.map(Repo.save(en), Responsedto.class);
	}

	public Responsedto getalldetailsbyid(int id) {
		Optional<Bookingentity> lisen = Repo.findById(id);

		if (lisen.isPresent()) {
			Bookingentity details = lisen.get();
			return mp.map(details, Responsedto.class);
		}

		return null;
	}

	public List<Responsedto> getalldetails() {
		List<Bookingentity> allentity = Repo.findAll();
		return allentity.stream().map(e -> mp.map(e, Responsedto.class)).collect(Collectors.toList());

	}

	public Responsedto updatedetails(int id, Requestdto rd) {
		Optional<Bookingentity> existentity = Repo.findById(id);
		if (existentity.isPresent()) {
			Bookingentity present = existentity.get();
			present.setCoustmerName(rd.getCoustmerName());
			present.setDate(rd.getDate());
			present.setEmail(rd.getEmail());
			present.setPohnenuber(rd.getPohnenuber());
			present.setTodaytopic(rd.getTodaytopic());
			Repo.save(present);
			return mp.map(present, Responsedto.class);

		}
		return null;
	}

	public String deletebyid(@PathVariable int id) {
		Optional<Bookingentity> en = Repo.findById(id);
		if (en.isPresent()) {
			Repo.deleteById(id);
			return "it was deleted";
		}
		return "it was not deleted";
	}

	public Page<Bookingentity> allpagedetails(int pageno, int pagerecord, String feild) {
		Pageable obj = PageRequest.of(pageno, pageno, Sort.by(feild));
		return Repo.findAll(obj);
	}
}
