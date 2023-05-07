package controll;

import model.MLectureAccount;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class CLecture {
	private String MajorEngName;
	public CLecture(VUserInfo vUserInfo) {
		// TODO Auto-generated constructor stub
		this.MajorEngName=vUserInfo.getMajorEngName();
	}

	public VUserInfo lecture(VLecture vLecture) {
		// TODO Auto-generated method stub
		MLectureAccount mLectureAccount = new MLectureAccount(MajorEngName);
		VUserInfo vUserInfo = mLectureAccount.lecture(vLecture);
		return vUserInfo;
	}

}
