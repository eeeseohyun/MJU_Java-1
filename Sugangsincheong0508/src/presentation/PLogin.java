package presentation;
import java.util.Scanner;

import controll.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin {
	
	public static void main(String[] args) {
		
	}

	public VUserInfo login(Scanner keyboard) {
//		Scanner keyboard = new Scanner(System.in); 
		System.out.println("사용자 아이디를 입력하세요.");
		String userId = keyboard.next(); 
		System.out.println("사용자 비밀번호 입력하세요.");
		String password = keyboard.next();
//		keyboard.close();
		
		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId); 
		vLogin.setPassword(password);
		
		CLogin cLogin = new CLogin();
		VUserInfo vUserInfo = cLogin.login(vLogin);
		
		if(vUserInfo == null) {
			System.out.println("잘못입력하셨습니다.");
		} else {
			System.out.println(vUserInfo.getName() + "님 안녕하세요.");
		}
		
		return vUserInfo;
	}

}
