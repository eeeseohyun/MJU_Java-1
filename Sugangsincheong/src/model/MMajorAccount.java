package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VMajor;
import valueObject.VUserInfo;

public class MMajorAccount {
	private String collegeEngName;
	public MMajorAccount(String collegeName) {
		// TODO Auto-generated constructor stub
		this.collegeEngName = collegeName;
	}

	public VUserInfo major(VMajor vMajor) {
		// TODO Auto-generated method stub
		VUserInfo vUserInfo = null;
		Scanner majorFile;
		try {
			String MajorCode=null;
			String MajorName=null;
			String MajorEngName=null;
			
			majorFile= new Scanner(new File("data/"+collegeEngName+".txt"));
			while(majorFile.hasNext()) {
				String line = majorFile.nextLine();
				String[] tokens = line.split(" ");
				 MajorCode = tokens[0];
				 MajorName = tokens[1];
				 MajorEngName = tokens[2];
				 if(MajorCode.equals(vMajor.getMajor())) {
						vUserInfo = new VUserInfo();
					 	vUserInfo.setMajorCode(MajorCode);
						vUserInfo.setMajorName(MajorName);
						vUserInfo.setMajorEngName(MajorEngName);
						System.out.println(MajorCode + " " + MajorName);
						}
			}
			majorFile.close();
			}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return vUserInfo;
	}
}
