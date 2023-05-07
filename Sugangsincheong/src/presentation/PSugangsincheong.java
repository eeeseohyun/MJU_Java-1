package presentation;
import java.util.Scanner;

import controll.CCampus;
import controll.CCollege;
import valueObject.VCampus;
import valueObject.VCollege;
import valueObject.VUserInfo;

public class PSugangsincheong {
private VUserInfo vUserInfo;
	
	public PSugangsincheong(VUserInfo vUserInfo) {
		this.vUserInfo = vUserInfo;
	}

	public void run(Scanner scanner){
		
		PCampus pCampus = new PCampus(vUserInfo);
		vUserInfo=pCampus.run(scanner);
	
		if(vUserInfo != null) {
			PCollege pCollege = new PCollege(vUserInfo);
			vUserInfo=PCollege.run(scanner);
		}
		if(vUserInfo != null) {
			PMajor pMajor = new PMajor(vUserInfo);
			vUserInfo =pMajor.run(scanner);
		}
		if(vUserInfo!=null) {
			PLecture pLecture = new PLecture(vUserInfo);
			vUserInfo = pLecture.run(scanner);
		}
	  }
	


}
