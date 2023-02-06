package DTO;

public class joinInformation {
	private String name;
	private String pw;
	private String id;
	
	//회원가입
	public joinInformation(String name, String pw, String id) {
		super();
		this.name = name;
		this.pw = pw;
		this.id = id;
	}
	//로그인
	public joinInformation(String id, String pw) {
		this.id = id;
		this.pw = pw;
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
