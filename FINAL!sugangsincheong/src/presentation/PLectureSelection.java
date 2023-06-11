package presentation;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureSelection {
	private CIndex cIndex;
	private CLecture cLecture;
	
	public PLectureSelection() {
		this.cIndex = new CIndex();
		this.cLecture = new CLecture();
	}
	private String findIndex(String message, String fileName, Scanner keyboard) {
		System.out.println(message + "코드를 입력하세요");
		Vector<VIndex> vIndexVector = cIndex.getVIndexVector(fileName);
		for (VIndex vIndex: vIndexVector) {
			System.out.println(vIndex.getCode() + " " + vIndex.getName() );
		}
		
		String sCode = keyboard.next();		
		int iCode = Integer.parseInt(sCode);
		int selectedIndex = 0;
		int i=1;
		for(VIndex vIndex: vIndexVector) {
			int code =vIndex.getCode();
			if(code==iCode) {
				selectedIndex=i;
			}
			i++;
		}
		String selectedFileName=null;
		if(selectedIndex==0) {
			System.out.println("잘못된 코드입니다. 다시 입력해주세요.");
			selectedFileName=this.findIndex(message,fileName,keyboard);
		}else {
			selectedIndex--;
			selectedFileName = vIndexVector.get(selectedIndex).getFileName();
		}
		
		return selectedFileName;
	}
	private VLecture findLecture(String message, String fileName, Scanner keyboard) {
		System.out.println(message + "코드를 입력하세요");
		Vector<VLecture> vLectureVector = cLecture.getVLectureVector(fileName);
		for (VLecture vLecture: vLectureVector) {
			System.out.println(vLecture.getCode() 
					+ " " + vLecture.getName() 
					+ " " + vLecture.getLecturer()
					+ " " + vLecture.getCredit()
					+ " " + vLecture.getTime());
		}
		
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		int selectedIndex = 0;
		int i=1;
		for(VLecture vLecture: vLectureVector) {
			int code =vLecture.getCode();
			if(code==iCode) {
				selectedIndex=i;
			}
			i++;
		}
		if(selectedIndex==0) {
			System.out.println("잘못된 코드입니다. 다시 입력해주세요.");
			this.findLecture(message,fileName,keyboard);
		}else {
			selectedIndex--;
		}
		VLecture vLecture = vLectureVector.get(selectedIndex);
		return vLecture;
	}
	
	public VLecture selectLecture(VUserInfo vUserInfo, Scanner keyboard) {		
			String campusFileName = this.findIndex("캠퍼스","root",keyboard );
			String collegeFileName = this.findIndex("대학",campusFileName,keyboard );
			String departmentFileName = this.findIndex("학과",collegeFileName,keyboard );
			
			VLecture vLecture = this.findLecture("강좌",departmentFileName,keyboard);
			return vLecture;
	}
	
}
