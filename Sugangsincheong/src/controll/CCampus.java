package controll;

import java.util.Scanner;

import model.MCampusAccount;
import valueObject.VCampus;
import valueObject.VUserInfo;

public class CCampus {

	public VUserInfo campus(VCampus vCampus){
		// TODO Auto-generated method stub
		MCampusAccount mCampusAccount = new MCampusAccount();
		VUserInfo vUserInfo = mCampusAccount.campus(vCampus); 
		return vUserInfo;
	}

}
