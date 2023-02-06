package DTO;

public class horseInfo {
	private String horseName;
	private int max;
	private int min;
	private int rank;
	
	
	public horseInfo(String horseName, int max, int min, int rank) {
		super();
		this.horseName = horseName;
		this.max = max;
		this.min = min;
		this.rank = rank;
	}
	
	
	public String getHorseName() {
		return horseName;
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
