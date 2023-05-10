package valueObject;

import java.util.Scanner;

public class VLectureIndex {

	private int code;
	private String name;
	private String professor;
	private int grade;
	private String time;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code =code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name =name;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade =grade;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time =time;
	}

	public void load(Scanner file) {
		// TODO Auto-generated method stub
		this.setCode(file.nextInt());
		this.setName(file.next());
		this.setProfessor(file.next());
		this.setGrade(file.nextInt());
		this.setTime(file.next());
	}

}
