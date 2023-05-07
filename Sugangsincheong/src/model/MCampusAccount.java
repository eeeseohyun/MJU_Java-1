package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VCampus;
import valueObject.VUserInfo;

public class MCampusAccount {
	public VUserInfo campus(VCampus vCampus) {
		VUserInfo vUserInfo = null;
		Scanner campusFile;
		try {
			campusFile = new Scanner(new File("data/root.txt"));
			while(campusFile.hasNext()) {
				String line = campusFile.nextLine();
				String[] tokens = line.split(" ");
				String campusCode = tokens[0];
				String campusName = tokens[1];
				String campusEngName= tokens[2];
				if(campusCode.equals(vCampus.getCampus())){
					vUserInfo = new VUserInfo();
					vUserInfo.setCampusCode(campusCode);
					vUserInfo.setCampusName(campusName);
					vUserInfo.setCampusEngName(campusEngName);
					System.out.println(campusCode+ " " + campusName);
			}
			}
			campusFile.close();
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vUserInfo;
	}
}
