package presentation;

import java.util.Scanner;
import java.util.Vector;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureBasket {
	private Vector<VLecture> vLectureVector;
	public PLectureBasket() {
		this.vLectureVector = new Vector<VLecture>();
	}
	public int add(VLecture vLecture) {
		if(vLecture.getCode()!=0) {
		this.vLectureVector.add(vLecture);
		}
		return vLecture.getCode();
	}
	public void delete(VLecture vLecture, Scanner keyboard) {
		System.out.println("삭제할 강좌 코드를 입력해주세요");
		this.show();
		int code=keyboard.nextInt();
		int i=0;
		for(VLecture vLecture1 : vLectureVector) {
			if(vLecture1.getCode()==code) {
				vLectureVector.remove(i);
				break;
			}
			i++;
		}
		System.out.println("강좌가 삭제되었습니다.");
	}
	public void show() {
		for(VLecture vLecture : vLectureVector) {
			vLecture.show();
		}
		// TODO Auto-generated method stub
		
	}
	public boolean checkName(VLecture vLecture) {
		for(VLecture vLecture1 : vLectureVector) {
			if(vLecture1.getName().equals(vLecture.getName())) {
				return false;
			}
		}
		return true;
	}
	public int totalCredit() {
		// TODO Auto-generated method stub
		int totalCredit=0;
		for(VLecture vLecture : vLectureVector) {
			totalCredit+=vLecture.getCredit();
		}
		return totalCredit;
	}
	public boolean checkTime(VLecture vLecture) {
		// TODO Auto-generated method stub
		for(VLecture vLecture1 : vLectureVector) {
			if(vLecture1.getTime().equals(vLecture.getTime())) {
				return false;
			}
		}
		return true;
	}
	public boolean checkLevel(VLecture vLecture, VUserInfo vUserInfo) {
		// TODO Auto-generated method stub
		if(vUserInfo.getLevel().equals("R2")) {
			if(!vLecture.getName().equals("영어1")) {
				return false;
			}
		}
			return true;
	}
	public boolean isEmpty(PLectureBasket pSincheongBasket,int code) {
		// TODO Auto-generated method stub
		for(VLecture vLecture1 : vLectureVector) {
			if(vLecture1.getCode()==code) {
				pSincheongBasket.add(vLecture1);
				return true;
			}
		}
		return false;
	}
	public boolean Empty() {
		// TODO Auto-generated method stub
		return vLectureVector.isEmpty();
	}
}
