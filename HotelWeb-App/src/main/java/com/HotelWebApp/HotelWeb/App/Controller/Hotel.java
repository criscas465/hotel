package com.HotelWebApp.HotelWeb.App.Controller;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.HotelWebApp.HotelWeb.App.Entity.*;
import com.HotelWebApp.HotelWeb.App.Service.RoomWebService;

@Component
public class Hotel {
	@Autowired
	RoomWebService RoomService;
	public String Name;
	public String Location;
	public int occupiedCnt;
	public int numOfRooms;
	
	public void addHotel(String name, String location) {
		Name = name;
		Location = location;
		numOfRooms = 0;
	}
	
	public Hotel() {
		Name = "";
		Location = "";
		numOfRooms = 0;
	}
	public Hotel(String name, String location) {
		Name = name;
		Location = location;
		numOfRooms = 0;
	}
	
	public void addRoom(int Number, String bed, String smoke, double rate) {
		numOfRooms++;
		Rooms room = new Rooms();
		room.setRoomnum(Number);
		room.setBedtype(bed);
		room.setSmoking(smoke);
		room.setRate(rate);
		room.setOccupantname("");
		room.setOccupied(false);
		RoomService.save(room);
	}
	public boolean isFull() {
		int value=0;
		List<Rooms> rooms=RoomService.findAll();
		ListIterator<Rooms> iterator = rooms.listIterator();
		while (iterator.hasNext()) {
			Boolean Occupied = iterator.next().isOccupied();
			//System.out.println("Occupied: "+ Occupied);
			if (Occupied == false) {
				value++;
			}
		}
		//System.out.println("value= "+value);
		if (value>=1) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean isEmpty() {
		int value=0;
		List<Rooms> rooms=RoomService.findAll();
		ListIterator<Rooms> iterator = rooms.listIterator();
		while (iterator.hasNext()) {
			Boolean Occupied = iterator.next().isOccupied();
			//System.out.println("Occupied: "+ Occupied);
			if (Occupied == true) {
				value++;
			}
		}
		//System.out.println("value= "+value);
		if (value>=1) {
			return false;
		}
		else {
			return true;
		}
	}
	public void addReservation(String name, String smoke, String bed) {
		//System.out.println("Name: "+name);
		int value=0;
		int available=0;
		List<Rooms> rooms=RoomService.findAll();
		for (int i=0;i<rooms.size();i++) {
			String bt = (String) rooms.get(i).getBedtype();
			String sm = (String) rooms.get(i).getSmoking();
			Boolean Occupied = (Boolean) rooms.get(i).isOccupied();
			int rn = rooms.get(i).getRoomnum();
			//System.out.println("bt= -"+ bt +"-  bedtype: -"+ bed);
			//System.out.println("sm= "+ sm +"  smoking: "+ smoke);
			//System.out.println("occ= "+ Occupied +"  occ: "+ false);
			
		//System.out.println("Occupied: "+ Occupied);
			if (bt.equals(bed) & sm.equals(smoke) & Occupied == false) {
				value = rn;
				available = 1;					
				break;					
			}
		}
		if (available == 1 ) {
			RoomService.insertReservation(name, true, value);
			System.out.println("Room reserved with that specifications");
		}
		else {
			System.out.println("Room no availabe with that specifications");
		}
	}
	public void cancelReservation(String name) {
		//System.out.println("Name: "+name);
		int value=0;
		int available=0;
		List<Rooms> rooms=RoomService.findAll();
		for (int i=0;i<rooms.size();i++) {
			String occupantname = (String) rooms.get(i).getOccupantname();
			Boolean Occupied = (Boolean) rooms.get(i).isOccupied();
			int rn = rooms.get(i).getRoomnum();
			//System.out.println("bt= -"+ bt +"-  bedtype: -"+ bed);
			//System.out.println("sm= "+ sm +"  smoking: "+ smoke);
			//System.out.println("occ= "+ Occupied +"  occ: "+ false);
			
		//System.out.println("Occupied: "+ Occupied);
			if (occupantname.equals(name) & Occupied == true) {
				value = rn;
				available = 1;					
				break;					
			}
		}
		if (available == 1 ) {
			RoomService.insertReservation("", false, value);
			System.out.println("Reservation was canceled");
		}
		else {
			System.out.println("There is no reservation with that name");
		}
	}
	int findReservation(String name) {
		int value=0;
		int available=0;
		List<Rooms> rooms=RoomService.findAll();
		for (int i=0;i<rooms.size();i++) {
			String occupantname = (String) rooms.get(i).getOccupantname();
			Boolean Occupied = (Boolean) rooms.get(i).isOccupied();
			int rn = rooms.get(i).getRoomnum();
			//System.out.println("bt= -"+ bt +"-  bedtype: -"+ bed);
			//System.out.println("sm= "+ sm +"  smoking: "+ smoke);
			//System.out.println("occ= "+ Occupied +"  occ: "+ false);
			
		//System.out.println("Occupied: "+ Occupied);
			if (occupantname.equals(name) & Occupied == true) {
				value = rn;
				available = 1;					
				break;					
			}
		}
		if (available == 1 ) {
			return value;
		}
		else {
			return -1;
		}		
	}
	public String printReservationList(){
		String list="";

		List<Rooms> rooms=RoomService.findAll();
		for (int i=0;i<rooms.size();i++) {
			Boolean Occupied = (Boolean) rooms.get(i).isOccupied();
			if (Occupied == true) {
				System.out.println("Room Number: "+ rooms.get(i).getRoomnum());
		        System.out.println("Occupant name: "+ rooms.get(i).getOccupantname());
		        System.out.println("Smoking room: "+ rooms.get(i).getSmoking());
		        System.out.println("Bed Type: "+ rooms.get(i).getBedtype());
		        System.out.println("Rate: "+ rooms.get(i).getRate());
		        System.out.println("");	
		        list=list + "Room Number: "+ rooms.get(i).getRoomnum()+"\n";
		        list=list + "Occupant Name: "+ rooms.get(i).getOccupantname()+"\n";
		        list=list + "Smoking: "+ rooms.get(i).getSmoking()+"\n";
		        list=list + "Bed Type: "+ rooms.get(i).getBedtype()+"\n";
		        list=list + "Rate: "+ rooms.get(i).getRate()+"\n";
		        list=list + "\n";
		        	        
			}
		}	
		return list;
 }
	public double getDailySales() {
		 double sum=0;
		 List<Rooms> rooms=RoomService.findAll();
			for (int i=0;i<rooms.size();i++) {
				Boolean Occupied = (Boolean) rooms.get(i).isOccupied();
				if (Occupied == true) {
					sum=sum+rooms.get(i).getRate();				
				}
			}	 
		 
		return sum; 
	 }
	 public double occupancyPercentage() {
		 double sum=0;
		 List<Rooms> rooms=RoomService.findAll();
			for (int i=0;i<rooms.size();i++) {
				Boolean Occupied = (Boolean) rooms.get(i).isOccupied();
				if (Occupied == true) {
					sum++;			
				}
			}	 	 
		 return ((sum/numOfRooms)*100); 
	 }
		
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public int getOccupiedCnt() {
		return occupiedCnt;
	}
	public void setOccupiedCnt(int occupiedCnt) {
		this.occupiedCnt = occupiedCnt;
	}
	public int getNumOfRooms() {
		return numOfRooms;
	}
	public void setNumOfRooms(int numOfRooms) {
		this.numOfRooms = numOfRooms;
	}
	

}
