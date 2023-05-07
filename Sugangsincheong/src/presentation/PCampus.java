package presentation;

import java.util.Scanner;

import controll.CCampus;
import valueObject.VCampus;
import valueObject.VUserInfo;

public class PCampus {
	static VUserInfo vUserInfo;
	
	public PCampus(VUserInfo vUserInfo) {
		// TODO Auto-generated constructor stub
		this.vUserInfo =vUserInfo;
	}

	public VUserInfo run(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print(vUserInfo.getName()+"님!");
		System.out.println("캠퍼스 코드를 선택하세요.");
		
//		Scanner scanner = new Scanner(System.in);
		String campus= scanner.next();
		
		VCampus vCampus = new VCampus(); 
		vCampus.setCampus(campus);
		
		CCampus cCampus = new CCampus();
		vUserInfo = cCampus.campus(vCampus);
		if(vUserInfo==null) {
			System.out.println("잘 못 입력하였습니다.");
		}
		return vUserInfo;
	}

}
