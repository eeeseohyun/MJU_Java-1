package controll;

import model.MCollegeAccount;
import valueObject.VCollege;
import valueObject.VUserInfo;

public class CCollege {
	private String CampusEngName;
	public CCollege(VUserInfo vUserInfo) {
		// TODO Auto-generated constructor stub
		this.CampusEngName = vUserInfo.getCampusEngName();
	}


	public VUserInfo college(VCollege vCollege) {
		// TODO Auto-generated method stub
		MCollegeAccount mCollegeAccount = new MCollegeAccount(CampusEngName);
		VUserInfo vUserInfo = mCollegeAccount.college(vCollege);
		return vUserInfo;
	}

}
