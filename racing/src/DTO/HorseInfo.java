package DTO;

import java.sql.DriverManager;
import java.sql.SQLException;

public class HorseInfo {
	private String name;
	private int max;
	private int min;
	private int rank;
	private String id;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}



	public HorseInfo(String name, int max, int min, int rank, String id) {
		super();
		this.name = name;
		this.max = max;
		this.min = min;
		this.rank = rank;
		this.id = id;
	}
	public HorseInfo() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public void setMax(int max) {
		this.max = max;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public void setRank(int rank) {
		this.rank = rank;
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