package valueObject;

import java.util.Scanner;

public class VIndex {
	private int code;
	private String name;
	private String fileName;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() { //안의 name을 읽어서 밖으로 전달
		return name;
	}
	public void setName(String name) { //밖에서 name을 읽어서 내용을 바꿈
		this.name = name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void load(Scanner file) {
		this.setCode(file.nextInt());
		this.setName(file.next());
		this.setFileName(file.next());
	}
	public void show() {
		System.out.println(this.getCode()+" " +this.getName());
	}
}