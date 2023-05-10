package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VIndex;
import valueObject.VLectureIndex;

public class MLectureIndex {

	public Vector<VLectureIndex> getVIndexVector(String fileName) {
		// TODO Auto-generated method stub
		Vector<VLectureIndex> vIndexVector=null;
		try {
			vIndexVector = new Vector<VLectureIndex>();
			Scanner file = new Scanner(new File("data/"+fileName+".txt"));
			while(file.hasNext()) {	
				VLectureIndex vIndex = new VLectureIndex();
				vIndex.load(file);
				vIndexVector.add(vIndex);
			}
		
			file.close();
		

			} 	catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		return vIndexVector;  
	}

}
