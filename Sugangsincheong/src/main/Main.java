package main;
import java.io.FileNotFoundException;
import java.util.Scanner;

import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;

public class Main {
	private void run() throws FileNotFoundException {
		PLogin pLogin =new PLogin();
		VUserInfo vUserInfo = pLogin.login();
		Scanner scanner = new Scanner(System.in);
		if(vUserInfo!=null) {
			PSugangsincheong pSugangsincheong = new PSugangsincheong(vUserInfo);
			pSugangsincheong.run(scanner);
		}
		
//		scanner.close();
	 
	}
	public static void main(String[] args) throws FileNotFoundException {//시작점을 알려주는 함수
		// TODO Auto-generated method stub
		Main main =new Main();
		main.run();
		
	}

}
