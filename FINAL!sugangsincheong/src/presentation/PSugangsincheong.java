package presentation;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VLecture;
import valueObject.VUserInfo;



public class PSugangsincheong {	

	private PLectureSelection pLectureSelection; 
	private PLectureBasket pMiridamgiBasket;
	private PLectureBasket pSincheongBasket;
	private VLecture vLecture;
	private int creditLimit=6;
	public PSugangsincheong() {
		this.pLectureSelection = new PLectureSelection();
		this.pMiridamgiBasket = new PLectureBasket();
		this.pSincheongBasket = new PLectureBasket();
		this.vLecture = new VLecture();
	}
		
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
		boolean pRunning = true;
		while(true) {
			System.out.println("강좌선택 0, 미리담기 1, 수강신청 2, 종료9");
			String sCode = keyboard.next();
			int iCode = Integer.parseInt(sCode);
			switch(iCode) {
			case 0 :
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
				run(vUserInfo,keyboard);
				break;
			case 1 :
				PMiridamgi pMiridamgi= new PMiridamgi(pMiridamgiBasket,vLecture,keyboard,creditLimit,vUserInfo,pSincheongBasket);
				pSincheongBasket=pMiridamgi.run();
					if(pMiridamgiBasket.Empty()) {
						System.out.println("우선 강좌를 선택해주세요.");
					}
					run(vUserInfo,keyboard);
					break;
				
			case 2 :
				PSincheong pSincheong = new PSincheong(pSincheongBasket,vLecture,keyboard,creditLimit,vUserInfo);
				pSincheongBasket=pSincheong.run();
				if(pSincheongBasket.Empty()) {
					System.out.println("우선 강좌를 선택해주세요.");
				}
				run(vUserInfo,keyboard);
				break;
			case 9 :
				pRunning = false;
				vLecture =null;
				break;
			default:
				break;
			}
			if(pRunning ==false) {
				System.exit(0);
			}
		}
	}
}
