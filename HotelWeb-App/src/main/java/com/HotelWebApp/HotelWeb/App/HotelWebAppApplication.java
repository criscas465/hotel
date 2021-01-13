package com.HotelWebApp.HotelWeb.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.HotelWebApp.HotelWeb.App.Controller.Hotel;

@SpringBootApplication
public class HotelWebAppApplication implements CommandLineRunner {
	@Autowired
	Hotel hotel;

	public static void main(String[] args) {
		SpringApplication.run(HotelWebAppApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		hotel.addHotel("Cristian Hotel", "Quito");
		hotel.addRoom(100, "king", "n", 753.25);
		hotel.addRoom(101, "king", "n", 102.5);
	    hotel.addRoom(102, "king", "y", 90.0);
	    hotel.addRoom(103, "queen", "y", 102.5);
	    hotel.addRoom(104, "twin", "n", 80);
	    hotel.addRoom(105, "king", "n", 100.0);
	    hotel.addRoom(106, "twin", "n", 90);
		
	/*
		hotel.addHotel("Hotel Cristian", "Quito");
		hotel.addRoom(100, "king", "n", 753.25);
		hotel.addRoom(101, "king", "n", 102.5);
	    hotel.addRoom(102, "king", "y", 90.0);
	    hotel.addRoom(103, "queen", "y", 102.5);
	    hotel.addRoom(104, "twin", "n", 80);
	    hotel.addRoom(105, "king", "n", 100.0);
	    hotel.addRoom(106, "twin", "n", 90);
	    String str=hotel.getName();
		System.out.println(str);
		hotel.addReservation("Cristian","y","queen");
	    hotel.addReservation("Karen","n","twin");
	    hotel.addReservation("Ruth","n","king");
	    hotel.addReservation("Carlos","n","king");
	
	  //print information
	    System.out.println(hotel.toString());

	    // Cancel reservation
	    hotel.cancelReservation("Carlos");

	    //  //print information
	    System.out.println(hotel.toString());
	    
		boolean val = hotel.isFull();
		System.out.println("is full: "+val);
		val = hotel.isEmpty();
		System.out.println("is empty: "+val);
		 // print reservation
	    hotel.printReservationList();
	    // get sales 
	    double sales = hotel.getDailySales();
	    System.out.println("Daily Sales: "+sales);
	    // Occupancy Percentage 
	    double occupancy = hotel.occupancyPercentage();
	    System.out.println("Occupancy Percentage: "+occupancy);
		
		*/
	}

}
