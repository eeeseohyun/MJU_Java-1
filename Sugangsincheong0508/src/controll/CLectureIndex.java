package controll;

import java.util.Vector;

import model.MLectureIndex;
import valueObject.VIndex;
import valueObject.VLectureIndex;

public class CLectureIndex {
	private MLectureIndex mLectureIndex;
	public CLectureIndex() {
		this.mLectureIndex = new MLectureIndex();
	}
	public Vector<VLectureIndex> getVIndexVector (String parentFileName) {
		Vector<VLectureIndex> vIndexVector= this.mLectureIndex.getVIndexVector(parentFileName);
		return vIndexVector;
	}
}
