package com.HotelWebApp.HotelWeb.App.Repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.HotelWebApp.HotelWeb.App.Entity.Rooms;
@Repository
public interface RoomWebRepo extends JpaRepository<Rooms, Integer>{
	@Modifying
	@Transactional
	@Query(value = "UPDATE roomweb SET occupantname = (?),occupied = (?) WHERE roomnum = (?)", 
	  nativeQuery = true)
	void insertReservation(String name ,boolean occupied,Integer roomnum);
	

}
