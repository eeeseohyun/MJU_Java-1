package presentation;

import java.util.Scanner;

import controll.CCollege;
import valueObject.VCollege;
import valueObject.VUserInfo;

public class PCollege {
	static VUserInfo vUserInfo;
	public PCollege(VUserInfo vUserInfo) {
		this.vUserInfo=vUserInfo;
	}

	public static VUserInfo run(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("단과 대학을 선택하세요.");
		String collegeCode = scanner.next();
		
		VCollege vCollege = new VCollege();
		vCollege.setCollege(collegeCode);
		
		CCollege cCollege = new CCollege(vUserInfo);
		vUserInfo = cCollege.college(vCollege);
		if(vUserInfo==null) {
			System.out.println("잘 못 입력하였습니다.");
		}
		return vUserInfo;
	}

}
