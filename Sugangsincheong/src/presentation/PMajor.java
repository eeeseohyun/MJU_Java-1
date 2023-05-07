package presentation;

import java.util.Scanner;

import controll.CCollege;
import controll.CMajor;
import valueObject.VCollege;
import valueObject.VMajor;
import valueObject.VUserInfo;

public class PMajor {
	static VUserInfo vUserInfo;
	public PMajor(VUserInfo vUserInfo) {
		// TODO Auto-generated constructor stub
		this.vUserInfo = vUserInfo;
	}

	public VUserInfo run(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("전공을 선택하세요");
		String majorCode=scanner.next();
		
		VMajor vMajor = new VMajor();
		vMajor.setMajor(majorCode);
		
		CMajor cMajor = new CMajor(vUserInfo);
		vUserInfo = cMajor.major(vMajor);
		if(vUserInfo==null) {
			System.out.println("잘 못 입력하였습니다.");
		}
		return vUserInfo;
	}

}
