package com.HotelWebApp.HotelWeb.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelWebApp.HotelWeb.App.Entity.Rooms;
import com.HotelWebApp.HotelWeb.App.Repo.RoomWebRepo;

@Service
public class RoomWebServiceImp implements RoomWebService{
	@Autowired
	RoomWebRepo RoomRepo;

	@Override
	public void save(Rooms r) {
		RoomRepo.save(r);
	}

	@Override
	public List<Rooms> findAll() {
		
		return RoomRepo.findAll();
	}

	@Override
	public void insertReservation(String name, boolean occupied, Integer roomnum) {
		RoomRepo.insertReservation(name, occupied, roomnum);
		
	}

	
	

}
