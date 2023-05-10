package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VLogin;
import valueObject.VUserInfo;

public class MAccount {

	public VUserInfo login(VLogin vLogin) {
		VUserInfo vUserInfo = null; 
		// 항상 그릇을 null로 세팅하고 찾으면 그거 반환하고 못찾으면 null 반
		// 유저 아이디를 찾아서 vUserIdInfo를만들어서 반환 
		
		File file = new File("Account/account");
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(scanner.hasNext()) {
			// 끝까지 찾으면 종료
			
			String line = scanner.nextLine(); // 한 라인씩 읽어보자 - 아이디, 비밀번호, 이름 	
			String[] tokens = line.split(" "); // 빈 칸이 있으면 뜯어줌, 이거 제대로 되게 하는 것이 과제 
			
			if(tokens[0].equals(vLogin.getUserId())) {
				if(tokens[1].equals(vLogin.getPassword())) {
					// 아이디와 비밀번호가 다 같으면 찾은 것
					
					vUserInfo = new VUserInfo();
					vUserInfo.setName(tokens[2]);
					break;
				}
			}
		}
		scanner.close();
		
		return vUserInfo;
	}
	
	
}
