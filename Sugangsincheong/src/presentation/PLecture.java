package presentation;

import java.util.Scanner;

import controll.CLecture;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLecture {
	private VUserInfo vUserInfo;
	public PLecture(VUserInfo vUserInfo) {
		// TODO Auto-generated constructor stub
		this.vUserInfo = vUserInfo;
	}

	public VUserInfo run(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("강좌를 선택하세요");
		String lectureCode = scanner.next();
		
		VLecture vLecture = new VLecture();
		vLecture.setLecture(lectureCode);
		
		CLecture cLecture = new CLecture(vUserInfo);
		vUserInfo = cLecture.lecture(vLecture);
		if(vUserInfo==null) {
			System.out.println("잘 못 입력하였습니다.");
		}
		
		return vUserInfo;
	}

}
