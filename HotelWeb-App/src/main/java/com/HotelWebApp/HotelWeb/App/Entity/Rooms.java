package com.HotelWebApp.HotelWeb.App.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="roomweb")
public class Rooms {
	  @Id
	  @Column
	  public int roomnum;
	  @Column
	  public String bedtype;
	  @Column
	  public double rate;
	  @Column
	  public String occupantname;
	  @Column
	  public String smoking;
	  @Column
	  public boolean occupied;
	  
	public Rooms() {
		this.roomnum = 0;
		this.bedtype = "";
		this.rate = 0;
		this.smoking = "";
		this.occupantname ="";
		this.occupied=false;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public String getBedtype() {
		return bedtype;
	}

	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getOccupantname() {
		return occupantname;
	}

	public void setOccupantname(String occupantname) {
		this.occupantname = occupantname;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	  

}
