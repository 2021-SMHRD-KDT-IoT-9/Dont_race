package DTO;

public class GameDTO {
	private int max;
	private int min;
	private int myMax;
	private int myMin;
	private int fieldSize;
	private int trun;
	private int win;
	private int loss;
	private int gameCount;
	
	public int getGameCount() {
		return gameCount;
	}
	public void setGameCount(int gameCount) {
		this.gameCount = gameCount;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getFieldSize() {
		return fieldSize;
	}
	public void setFieldSize(int fieldSize) {
		this.fieldSize = fieldSize;
	}
	public int getTrun() {
		return trun;
	}
	public void setTrun(int trun) {
		this.trun = trun;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLoss() {
		return loss;
	}
	public void setLoss(int loss) {//sd
		this.loss = loss;
	}
	public int getMyMax() {
		return myMax;
	}
	public void setMyMax(int myMax) {
		this.myMax = myMax;
	}
	public int getMyMin() {
		return myMin;
	}
	public void setMyMin(int myMin) {
		this.myMin = myMin;
	}
	
}
