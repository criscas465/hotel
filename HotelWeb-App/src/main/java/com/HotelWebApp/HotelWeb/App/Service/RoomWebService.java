package com.HotelWebApp.HotelWeb.App.Service;

import java.util.List;

import com.HotelWebApp.HotelWeb.App.Entity.Rooms;

public interface RoomWebService {
	public void save(Rooms r);
	public List<Rooms> findAll();
	void insertReservation(String name ,boolean occupied,Integer roomnum);

}
