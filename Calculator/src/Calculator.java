
import java.io.IOException;

public class Calculator {
	int end=0;
	private int readOperator(int end) throws IOException {
		System.out.println("prefix 형식으로 계산식을 입력해주세요.");
		System.out.println("연산자 : + - * / ");
		int code = System.in.read();
		while (!(code == '*' || code == '-' || code == '+' || code == '/')) {
			if(code==end) {
				return end;
			}
			if(code=='c') {
				System.out.println("초기화");
			}
			code = System.in.read();
		}
		return code;
	}

	public int main(int code) throws IOException {
		int result = 0;
		int input1 = System.in.read();
		input1 = getInput(input1);
		if(input1=='c') {
			System.out.println("초기화");
			code = readOperator(end);
			input1 = System.in.read();
			input1 = getInput(input1);
			}
		

		int input2 = System.in.read();
		if(input2=='c') {
			System.out.println("초기화");
			code = readOperator(end);
			input1 = System.in.read();
			input1 = getInput(input1);
			input2 = System.in.read();
			result = getInput2(code, input1, input2);
		}
		return result = getInput2(code, input1, input2);

	}

	private int getInput2(int code, int input1, int input2) throws IOException {
		// TODO Auto-generated method stub
		int result = 0;
		while (!check(input2)) {
			input2 = System.in.read();
		}
		if (checkOperator(input2)) {
			int input3 = main(input2);
			result = compute(code, input1, input3);
			return result;
		}
		if (checkNum(input2)) {
			input2 = changeInt(input2);
		}
		if(input2=='c') {
			result=0;
			return result;
		}
		result = compute(code, input1, input2);
		return result;
	}

	private int getInput(int input1) throws IOException {
		// TODO Auto-generated method stub
		while (!check(input1)) {
			input1 = System.in.read();
		}
		if (checkOperator(input1)) {
			input1 = main(input1);
		}
		if (checkNum(input1)) {
			input1 = changeInt(input1);
		}
		if(input1=='c') {
		
		}
		return input1;
	}

	private int compute(int code, int input1, int input3) {
		// TODO Auto-generated method stub
		int result = 0;
		if (code == '+') {
			result = input1 + input3;
		} else if (code == '-') {
			result = input1 - input3;
		} else if (code == '*') {
			result = input1 * input3;
		} else if (code == '/') {
			result = input1 / input3;
		}
		return result;
	}

	private int changeInt(int input1) throws IOException {
		// TODO Auto-generated method stub
		int result = input1 - '0';
		int input = System.in.read();
		while ((input >= '0' && input <= '9')) {
			result = (result * 10) + (input - '0');
			input = System.in.read();
		}

		return result;
	}

	private boolean check(int input1) {
		// TODO Auto-generated method stub
		if (checkOperator(input1)) {
			return true;
		} else if (checkNum(input1)) {
			return true;

		} else if (input1=='c'){
			return true;
		}else {
			return false;
		}
	}

	private boolean checkNum(int input1) {
		// TODO Auto-generated method stub
		if ((input1 >= '0' && input1 <= '9')) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkOperator(int input1) {
		// TODO Auto-generated method stub
		if ((input1 == '*' || input1 == '-' || input1 == '+' || input1 == '/')) {
			return true;
		} else {
			return false;
		}
	}

	public void run() {
		try {
			end = getEnd();
			int code = readOperator(end);
			while (code != end) {
				int result = main(code);
				System.out.println(result);
				code = readOperator(end);
			}
			System.out.println("끝!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int getEnd() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("계산기를 끝낼 제어 문자(한 글자)를 입력해주세요: ");
		int end = System.in.read();
		return end;
	}
}