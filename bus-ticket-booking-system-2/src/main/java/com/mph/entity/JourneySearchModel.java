package com.mph.entity;

/**
 * This Model is for the JourneySearchModel class
 * @author Divya G
 * @version 1.0
 */
public class JourneySearchModel {

	private String source;
	private String dest;
	private String date;
	public JourneySearchModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JourneySearchModel(String source, String dest, String date) {
		super();
		this.source = source;
		this.dest = dest;
		this.date = date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
