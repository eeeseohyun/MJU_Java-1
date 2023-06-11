package presentation;

import java.util.Scanner;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PMiridamgi {
	private VLecture vLecture;
	private PLectureBasket pMiridamgiBasket;
	private PLectureBasket pSincheongBasket;
	private int creditLimit=0;
	private Scanner keyboard;
	private VUserInfo vUserInfo;
	boolean emptycheck=false;
	public PMiridamgi(PLectureBasket pMiridamgiBasket, VLecture vLecture, Scanner keyboard,int creditLimit, VUserInfo vUserInfo, PLectureBasket pSincheongBasket) {
		// TODO Auto-generated constructor stub
		this.vLecture = vLecture;
		this.pMiridamgiBasket = pMiridamgiBasket;
		this.creditLimit=creditLimit;
		this.keyboard= keyboard;
		this.vUserInfo = vUserInfo;
		this.pSincheongBasket=pSincheongBasket;
	}
	public PLectureBasket select() {
		System.out.println("담기 0, 보기 1, 삭제 2 신청 3");
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		if(iCode==0) {
			this.setLecture();
	}else if(iCode==1) {
			this.showLecture();
	}else if(iCode==2) {
			this.deleteLecture();
	}else if(iCode==3) {
			this.showLecture();
			pSincheongBasket=this.sincheong();
	}
		return pSincheongBasket;
}
	private PLectureBasket sincheong() {
		// TODO Auto-generated method stub
		System.out.println("신청할 강좌 코드를 입력해주세요.");
		int code = keyboard.nextInt();
		if(!pMiridamgiBasket.isEmpty(pSincheongBasket,code)) {
			System.out.println("장바구니에 존재하지 않는 강좌입니다.");
		}else {
			this.select();
		}
		return pSincheongBasket;
	}
	private void deleteLecture() {
		// TODO Auto-generated method stub
		pMiridamgiBasket.delete(vLecture,keyboard);
	}
	private void showLecture() {
		// TODO Auto-generated method stub
		pMiridamgiBasket.show();
		emptycheck=true;
	}
	public void setLecture() {
		if(pMiridamgiBasket.totalCredit()+vLecture.getCredit() > creditLimit) {
			System.out.println("미리담기 가능 학점 초과입니다.");
		}else if(!pMiridamgiBasket.checkLevel(vLecture,vUserInfo)) {
			System.out.println("해당 레벨의 수업이 아닙니다.");
			emptycheck=true;
			this.select();
		}else {
			emptycheck=true;
			pMiridamgiBasket.add(vLecture);
	}
		pMiridamgiBasket.show();
	}
	public PLectureBasket run() {
		return this.select();
	}
}


