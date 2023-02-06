package DTO;

import java.sql.DriverManager;
import java.sql.SQLException;

public class HorseInfo {
	private String name;
	private int max;
	private int min;
	private int rank;
	
	
	public HorseInfo(String name, int max, int min, int rank) {
		super();
		this.name = name;
		this.max = max;
		this.min = min;
		this.rank = rank;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}
	public int getMax() {
		return max;
	}
	public int getMin() {
		return min;
	}
	public int getRank() {
		return rank;
	}
	


}