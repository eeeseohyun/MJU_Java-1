package controll;
import java.io.FileNotFoundException;

import model.MAccount;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class CLogin {

	public VUserInfo login(VLogin vLogin) throws FileNotFoundException {
		// TODO Auto-generated method stub
		MAccount mAccount = new MAccount();
		VUserInfo vUserInfo= mAccount.login(vLogin);
		return vUserInfo;
	}

}
