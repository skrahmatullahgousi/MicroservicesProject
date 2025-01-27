package com.concepts.demo.repostitory;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concepts.demo.entity.Bookingentity;

@Repository
public interface Bookingrepostitory extends JpaRepository<Bookingentity, Integer> {
	Page<Bookingentity> findAll(Pageable obj);

}
