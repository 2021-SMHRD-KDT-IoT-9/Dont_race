package controller;

public class Difficulty {
	private int easy ;
	private int middle;
	private int hard;
	MainControll mc = new MainControll();
	
	public void Easy() {
		mc.setMax(3);
		mc.setMin(1);
	}
	public void Middle() {
		
	}
	public void Hard() {
		mc.setMax(5);
		mc.setMin(2);
	}
	
	
	

}
