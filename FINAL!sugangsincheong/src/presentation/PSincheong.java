package presentation;

import java.util.Scanner;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSincheong {
	private VLecture vLecture;
	private PLectureBasket pSincheongBasket;
	private int creditLimit=0;
	private Scanner keyboard;
	boolean emptycheck=false;
	private VUserInfo vUserInfo;
	public PSincheong(PLectureBasket pSincheongBasket, VLecture vLecture, Scanner keyboard,int creditLimit, VUserInfo vUserInfo) {
		// TODO Auto-generated constructor stub
		this.vLecture = vLecture;
		this.pSincheongBasket = pSincheongBasket;
		this.creditLimit=creditLimit;
		this.keyboard= keyboard;
		this.vUserInfo =vUserInfo;
	}
	public PLectureBasket select() {
		System.out.println("담기 0, 보기 1, 삭제 2");
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		if(iCode==0) {
			this.setLecture();
	}else if(iCode==1) {
			this.showLecture();
	}else if(iCode==2) {
			this.deleteLecture();
	}
		return pSincheongBasket;
}
	private void deleteLecture() {
		// TODO Auto-generated method stub
		pSincheongBasket.delete(vLecture,keyboard);
	}
	private void showLecture() {
		// TODO Auto-generated method stub
		pSincheongBasket.show();
		emptycheck=true;
	}
	public void setLecture() {
		if(pSincheongBasket.totalCredit()+vLecture.getCredit() > creditLimit) {
			System.out.println("미리담기 가능 학점 초과입니다.");
			pSincheongBasket.show();
		}else if(!pSincheongBasket.checkName(vLecture)) {
			System.out.println("이미 담긴 강좌입니다.");
			emptycheck=true;
			this.select();
		}else if(!pSincheongBasket.checkTime(vLecture)) {
			System.out.println("해당 시간에 이미 강좌가 신청되었습니다.");
			emptycheck=true;
			this.select();
		}else if(!pSincheongBasket.checkLevel(vLecture,vUserInfo)) {
			System.out.println("해당 레벨의 수업이 아닙니다.");
			emptycheck=true;
			this.select();
		}else {
			emptycheck=true;
			pSincheongBasket.add(vLecture);
		}
	}
	public PLectureBasket run() {
		return this.select();
	}
}


