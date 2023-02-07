package controller;

import DAO.JoinDAO;
import DTO.joinInformation;

public class LoginCon {
	private boolean isLogin = false;
	private String loginId;
	// 회원가입
	public void Join(String id, String pw, String name) {
		joinInformation dto = new joinInformation(id, pw, name);
		JoinDAO dao = new JoinDAO();
		int row = dao.join(dto);
		if (row > 0) {
			System.out.println("회원가입 성공!");
			
		} else {
			System.out.println("회원가입 실패!");
			
		}
	}
	public boolean getIslogIn() {
		return isLogin;
	}
	public String getLoginId() {
		return loginId;
	}
	
	// 로그인
	public void Login(String id, String pw) {
		joinInformation dto = new joinInformation(id, pw);
		JoinDAO dao = new JoinDAO();
		boolean result = dao.Login(dto);
		if(result) {
			System.out.println("로그인 성공!");
			isLogin =  true;
			loginId = id;
		}else {
			System.out.println("아이디나 비밀번호를 확인해주세요!");
			isLogin =  false;
		}
	}
	
}
