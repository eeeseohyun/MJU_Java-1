package controll;

import model.MMajorAccount;
import valueObject.VMajor;
import valueObject.VUserInfo;

public class CMajor {
	private String CollegeEngName;
	public CMajor(VUserInfo vUserInfo) {
		// TODO Auto-generated constructor stub
		this.CollegeEngName = vUserInfo.getCollegeEngName();
	}

	public VUserInfo major(VMajor vMajor) {
		// TODO Auto-generated method stub
		MMajorAccount mMajorAccount = new MMajorAccount(CollegeEngName);
		VUserInfo vUserInfo = mMajorAccount.major(vMajor);
		return vUserInfo;
	}

}
