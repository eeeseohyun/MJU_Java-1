package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class MLectureAccount {
	private String majorEngName;
	public MLectureAccount(String majorEngName) {
		// TODO Auto-generated constructor stub
		this.majorEngName=majorEngName;
	}

	public VUserInfo lecture(VLecture vLecture) {
		// TODO Auto-generated method stub
		VUserInfo vUserInfo = null;
		Scanner lectureFile;
		
		try {
			String LectureCode=null;
			String LectureName=null;
			String LectureCredit=null;
			String LectureTime=null;
			String LectureProfessor=null;
			
			lectureFile= new Scanner(new File("data/"+majorEngName+".txt"));
			while(lectureFile.hasNext()) {
				String line = lectureFile.nextLine();
				String[] tokens = line.split(" ");
				 LectureCode = tokens[0];
				 LectureName = tokens[1];
				 LectureProfessor = tokens[2];
				 LectureCredit = tokens[3];
				 LectureTime = tokens[4];
				 if(LectureCode.equals(vLecture.getLecture())) {
						vUserInfo = new VUserInfo();
					 	vUserInfo.setLectureCode(LectureCode);
						vUserInfo.setLectureName(LectureName);
						vUserInfo.setLectureProfessor(LectureProfessor);
						vUserInfo.setLectureCredit(LectureCredit);
						vUserInfo.setLectureTime(LectureTime);
						System.out.println(LectureCode + " " + LectureName + " " +LectureProfessor + " " +LectureCredit + " "+ LectureTime );
						}
			}
			lectureFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
