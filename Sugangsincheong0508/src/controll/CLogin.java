package controll;

import model.MAccount;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class CLogin {

	public VUserInfo login(VLogin vLogin) {
		MAccount mAccount = new MAccount();
		VUserInfo vUserInfo = mAccount.login(vLogin);
		
		return vUserInfo;
	}

}
