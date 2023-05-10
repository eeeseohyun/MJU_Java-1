package main;
import java.util.Scanner;

import presentation.PLogin;
import presentation.Psugangsincheong;
import valueObject.VUserInfo;

public class Main {

	public Main() {
		
	}
	
	private void run() {
		Scanner keyboard = new Scanner(System.in);  
		PLogin pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login(keyboard);
		if(vUserInfo != null) {			
			Psugangsincheong psugangsincheong = new Psugangsincheong();
			psugangsincheong.run(vUserInfo, keyboard);
		}
		keyboard.close();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();		
	}
}
