package controller;

public class Difficulty {
	
	MainControll mc = new MainControll();
	
	public void getEasy() {
		mc.setMax(3);
		mc.setMin(1);
	}
	public void getMiddle() {
		mc.setMax(4);
		mc.setMin(1);
	}
	public void getHard() {
		mc.setMax(5);
		mc.setMin(2);
	}
	
	
	

}
