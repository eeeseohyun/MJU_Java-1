package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VCollege;
import valueObject.VUserInfo;

public class MCollegeAccount {
	private String campusEngName;

	public MCollegeAccount(String campusEngName) {
		// TODO Auto-generated constructor stub
		this.campusEngName = campusEngName;
	}

	public VUserInfo college(VCollege vCollege) {
		// TODO Auto-generated method stub
		VUserInfo vUserInfo= null;
		Scanner collegeFile;
		try {
			String collegeCode=null;
			String collegeName=null;
			String collegeEngName=null;
			
			collegeFile = new Scanner(new File("data/"+campusEngName+".txt"));
			while(collegeFile.hasNext()) {
				String line = collegeFile.nextLine();
				String[] tokens = line.split(" ");
				 collegeCode = tokens[0];
				 collegeName = tokens[1];
				 collegeEngName = tokens[2];
				 if(collegeCode.equals(vCollege.getCollege())) {
						vUserInfo = new VUserInfo();
					 	vUserInfo.setCollegeCode(collegeCode);
						vUserInfo.setCollegeName(collegeName);
						vUserInfo.setCollegeEngName(collegeEngName);
						System.out.println(collegeCode + " " + collegeName);
						}
			}
			collegeFile.close();
			}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return vUserInfo;
	}
		
}
