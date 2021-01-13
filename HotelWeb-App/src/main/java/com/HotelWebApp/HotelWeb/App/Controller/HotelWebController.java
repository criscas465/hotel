package com.HotelWebApp.HotelWeb.App.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.HotelWebApp.HotelWeb.App.Entity.Rooms;
import com.HotelWebApp.HotelWeb.App.Service.RoomWebService;


@Controller
public class HotelWebController {
	@Autowired
	Hotel hotel;
	@Autowired
	RoomWebService RoomService;
	
	@RequestMapping("/")
	public String welcomeHotel(Model model)
	{
		model.addAttribute("Location", hotel.getLocation());
		model.addAttribute("HotelName", hotel.getName());
		return "index";
	}
	@RequestMapping("/request_room")
	public String requestRoom(Model model)
	
	{
		Rooms r = new Rooms();
		model.addAttribute(r);
		return "new_reservation";
	}
	@RequestMapping("/cancel_room")
	public String cancelRoom(Model model)
	{
		Rooms r = new Rooms();
		model.addAttribute(r);
		return "cancel_reservation";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveReservation(@ModelAttribute("rooms") Rooms r)
	{
		String name=r.getOccupantname();
		String smoke=r.getSmoking();
		String bedtype=r.getBedtype();
		hotel.addReservation(name, smoke, bedtype);
		return "redirect:/list_room";
	}
	@RequestMapping("/list_room")
	public String listRooms(Model model)
	{
		List<Rooms> listRoom=RoomService.findAll();
		model.addAttribute("room",listRoom);
		
		return "listRooms";
	}
	@RequestMapping(value="/cancel",method = RequestMethod.POST)
	public String cancelReservation(@ModelAttribute("rooms") Rooms r)
	{
		String name=r.getOccupantname();
		hotel.cancelReservation(name);
		return "redirect:/list_room";
	}
	@RequestMapping("/option")
	public String option(Model model)
	{
		boolean val1 = hotel.isFull();
		String isFull = "is full: "+val1;
		System.out.println(isFull);
		
		boolean val2 = hotel.isEmpty();
		String isEmpty = "is empty" + val2;
		System.out.println(isEmpty);
		 // print reservation
	    String list = hotel.printReservationList();
	    // get sales 
	    double sales = hotel.getDailySales();
	    System.out.println("Daily Sales: "+sales);
	    // Occupancy Percentage 
	    double occupancy = hotel.occupancyPercentage();
	    System.out.println("Occupancy Percentage: "+occupancy);
	    
	    model.addAttribute("list", list );
	    model.addAttribute("isEmpty", val2 );
	    model.addAttribute("isfull", val1 );
		model.addAttribute("Location", hotel.getLocation());
		model.addAttribute("HotelName", hotel.getName());
		model.addAttribute("sales", sales );
		model.addAttribute("occupancy", occupancy );
		return "option";
	}
	
	

}
