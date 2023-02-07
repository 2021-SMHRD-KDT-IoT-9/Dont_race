package DTO;

import java.sql.DriverManager;
import java.sql.SQLException;

public class HorseInfo {
	private String name;
	private int max;
	private int min;
	private int rank;
	private String id;
	private int game;
	







	public HorseInfo(String name, int max, int min, int rank, String id, int game) {
		super();

		this.name = name;
		this.game = game;
		this.min = min;
		this.max = max;
		this.rank = rank;
		this.id = id;
	}


	public HorseInfo() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public void setGame(int game) {
		this.game = game;
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
	public String getId() {
		return id;
	}
	
	public int getGame() {
		return game;
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