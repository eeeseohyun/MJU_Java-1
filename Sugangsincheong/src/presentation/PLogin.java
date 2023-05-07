package presentation;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controll.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin {
	
	public VUserInfo login() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("사용자 아이디를 입력하세요.");
		String userId = scanner.next();

		System.out.println("비밀번호를 입력하세요.");
		String password = scanner.next();

		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId);
		vLogin.setPassword(password);
		
		CLogin cLogin = new CLogin();
		VUserInfo vUserInfo=cLogin.login(vLogin);
		
		if(vUserInfo==null) {
			System.out.println("잘 못 입력하였습니다.");
		}else {
			System.out.println(vUserInfo.getName()+"님 안녕하세요");
		}
		return vUserInfo;
	}

}
