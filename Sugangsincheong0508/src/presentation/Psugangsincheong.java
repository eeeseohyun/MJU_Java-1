package presentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import controll.CIndex;
import controll.CLectureIndex;
import valueObject.VIndex;
import valueObject.VLectureIndex;
import valueObject.VUserInfo;

public class Psugangsincheong {
	

	private CIndex cIndex;
	private CLectureIndex cLectureIndex;
	public Psugangsincheong(){
		this.cIndex = new CIndex();
		this.cLectureIndex = new CLectureIndex();
	}
	
	public String selectIndex(String message, String fileName, Scanner keyboard) {
		System.out.println("코드를 입력하세요");
		Vector<VIndex> vIndexVector = cIndex.getVIndexVector(fileName);
		for(VIndex vIndex: vIndexVector) {
			System.out.println(vIndex.getCode() + " " + vIndex.getName());
		}
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode); 
		int selectedIndex = 5;
		int i=0;
		for(VIndex vIndex: vIndexVector) {
			int code =vIndex.getCode();
			if(code==iCode) {
				selectedIndex=i;
			}
			i++;
		}
		String selectedFileName = vIndexVector.get(selectedIndex).getFileName();
		return selectedFileName;
	}
	private void selectLectureIndex(String string, String fileName, Scanner keyboard) {
		// TODO Auto-generated method stub
		System.out.println("코드를 입력하세요");
		Vector<VLectureIndex> vIndexVector = cLectureIndex.getVIndexVector(fileName);
		for(VLectureIndex vLectureIndex : vIndexVector) {
			System.out.println(vLectureIndex.getCode()+" "+vLectureIndex.getName()+" "+vLectureIndex.getProfessor()+" "+vLectureIndex.getGrade()+" "+vLectureIndex.getTime());
		}
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		int selectedIndex = 5;
		int i=0;
		for(VLectureIndex vLectureIndex : vIndexVector) {
			int code =vLectureIndex.getCode();
			if(code==iCode) {
				selectedIndex=i;
			}
			i++;
		}
		System.out.println(vIndexVector.get(selectedIndex).getName());
		
	}
	
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
			String campusFileName = this.selectIndex("캠퍼스","root", keyboard);
			String collegeFileName = this.selectIndex("대학", campusFileName, keyboard);
			String departmentFileName = this.selectIndex("학과", collegeFileName, keyboard);
			this.selectLectureIndex("강좌",departmentFileName,keyboard);
	}

}
