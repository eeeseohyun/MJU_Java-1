package main;
import java.util.Scanner;

import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;

public class Main {
	private Scanner keyboard;
	private PLogin pLogin;
	private PSugangsincheong vSugangsincheong;
	private VUserInfo vUserInfo;
	public Main() {
		
	}
	private void run() {
		keyboard = new Scanner(System.in);
		
		pLogin = new PLogin();
		vUserInfo = pLogin.login(keyboard);
		if ( vUserInfo != null) {
			vSugangsincheong = new PSugangsincheong();
			vSugangsincheong.run(vUserInfo, keyboard);
		}
		keyboard.close();
	}

	public static void main(String[] args) {
		
		Main main = new Main();
		
		main.run();
	}

	
}
