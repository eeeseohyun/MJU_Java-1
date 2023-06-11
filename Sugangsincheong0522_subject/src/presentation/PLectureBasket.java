package presentation;

import java.util.Vector;

import valueObject.VLecture;

public class PLectureBasket {
	private Vector<VLecture> vLectureVector;
	public PLectureBasket() {
		this.vLectureVector = new Vector<VLecture>();
	}
	public int add(VLecture vLecture) {
		if(vLecture.getCode()!=0) {
		this.vLectureVector.add(vLecture);
		}
		return vLecture.getCode();
	}
	public void show() {
		for(VLecture vLecture : vLectureVector) {
			vLecture.show();
		}
		// TODO Auto-generated method stub
		
	}
}
