package presentation;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import control.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin {
	private VUserInfo vUserInfo =null;
	public VUserInfo login(Scanner keyboard){
		
		System.out.println("사용자 이름을 입력해주세요.");
		String userId = keyboard.next();
		System.out.println("비밀번호를 입력해주세요.");
		String password = keyboard.next();
		
		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId);
		vLogin.setPassword(password);
		
		CLogin cLogin = new CLogin();
		vUserInfo = cLogin.login(vLogin);
		
		if (vUserInfo == null) {
			this.notlogin(keyboard);
			
		}
		else {
			System.out.println(vUserInfo.getName() + "님 안녕하세요");
	
		}

		return vUserInfo;
	}
	private void notlogin(Scanner keyboard) {
		// TODO Auto-generated method stub
		System.out.println("잘 못 입력하였습니다.");
		System.out.println("1 회원가입 2 다시로그인");
		int login=keyboard.nextInt();
		if(login==1) {
			this.join(keyboard);
			this.login(keyboard);
		}else if(login==2) {
			this.login(keyboard);
		}else {
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			this.notlogin(keyboard);
			
		}
	}
	private void join(Scanner keyboard) {
		// TODO Auto-generated method stub
		System.out.println("사용자 이름을 입력해주세요.");
		String userId = keyboard.next();
		System.out.println("비밀번호를 입력해주세요.");
		String password = keyboard.next();
		System.out.println("이름을 입력해주세요.");
		String name = keyboard.next();
		System.out.println("레벨을 입력해주세요.(R1,R2,R3,R4)");
		String level = keyboard.next();
		String filePath = "account/account";
        FileWriter fw;
		try {
			fw = new FileWriter(filePath, true);
			String lineToAppend = userId+" "+password+" "+name+" "+level;    
	        fw.write(lineToAppend);
	        fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
        
	}
}
