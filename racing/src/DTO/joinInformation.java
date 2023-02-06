package DTO;

public class joinInformation {
	private String name;
	private String pw;
	private String id;
	
	
	public joinInformation(String name, String pw, String id) {
		super();
		this.name = name;
		this.pw = pw;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}


	public String getPw() {
		return pw;
	}


	public String getId() {
		return id;
	}


	
}
