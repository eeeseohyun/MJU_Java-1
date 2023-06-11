package presentation;
import java.util.Scanner;

import valueObject.VLecture;
import valueObject.VUserInfo;



public class PSugangsincheong {	

	private PLectureSelection pLectureSelection; 
	private PLectureBasket pMiridamgiBasket;
	private PLectureBasket pSincheongBasket;
	private VLecture vLecture;
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
			int emptyCheck=0;
			switch(iCode) {
			case 0 :
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
				run(vUserInfo,keyboard);
				break;
			case 1 :
				emptyCheck=pMiridamgiBasket.add(vLecture);
				if(emptyCheck==0) {
					System.out.println("우선 강좌를 선택해주세요.");
				}else {
				pMiridamgiBasket.show();
				}
				run(vUserInfo,keyboard);
				break;
			case 2 :
				emptyCheck=pSincheongBasket.add(vLecture);
				if(emptyCheck==0) {
					System.out.println("우선 강좌를 담아주세요.");
				}else {
					pMiridamgiBasket.show();
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
