package com.dto.programs;

public class Book {
	private int bid;
	private String bname;
	private String authour;
	private String subtitle;
	private double price;
	private int quantity;
	public Book() {
	}
	public Book(int bid, String bname, String authour, String subtitle, double price, int quantity) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.authour = authour;
		this.subtitle = subtitle;
		this.price = price;
		this.quantity = quantity;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthour() {
		return authour;
	}
	public void setAuthour(String authour) {
		this.authour = authour;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Library [bid=" + bid + ", bname=" + bname + ", authour=" + authour + ", subtitle=" + subtitle
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	

}
