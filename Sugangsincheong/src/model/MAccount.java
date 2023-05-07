package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VLogin;
import valueObject.VUserInfo;

public class MAccount {
	public VUserInfo login(VLogin vLogin) throws FileNotFoundException{
		VUserInfo vUserInfo = null;
		Scanner scanner = null;
		File file = new File("C:\\Users\\User\\eclipse-workspace\\Sugangsincheong\\data\\Account");
			scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] tokens = line.split(" ");
				if(tokens[0].equals(vLogin.getUserId())) {
					if(tokens[1].equals(vLogin.getPassword())) {
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
