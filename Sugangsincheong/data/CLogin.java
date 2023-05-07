import java.io.FileNotFoundException;

public class CLogin {

	public OMember login(VLogin vLogin) throws FileNotFoundException {
		// TODO Auto-generated method stub
		MAccount mAccount = new MAccount();
		OMember vUserInfo= mAccount.login(vLogin);
		return vUserInfo;
	}

}
