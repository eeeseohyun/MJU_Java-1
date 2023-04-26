
import java.io.IOException;


public class Calculator {
	final static int CR = 0x0d;
	final static int Space=0x20;
	final static int Tab=0x09;
	final static int LF =0x0a;
	final static int WORDZERO='0';
	private int readOperator(int end) throws IOException {
		System.out.println("prefix 형식으로 계산식을 입력해주세요.");
		System.out.println("연산자 : + _ * / ");
		int code = System.in.read();
		while (!(code == '*' || code == '-' || code == '+' || code == '/')) {
			if(code==end) {
				return end;
			}
			code = System.in.read();
		}
		return code;
	}

	public int main(int code) throws IOException {
		int result = 0;
		int input1 = System.in.read();
		input1 = getInput(input1);

		int input2 = System.in.read();
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
		int result = input1 - WORDZERO;
		int input = System.in.read();
		while ((input >= '0' && input <= '9')) {
			result = (result * 10) + (input - WORDZERO);
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

		} else {
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

	public void Print() throws IOException {
		System.out.println("prefix와 infix 대해서 알고싶다면 Y 아니면 N을 입력하세요.");
		int prefix= System.in.read();
		if(prefix=='Y') {
			System.out.println("prefix 형식은 '연산자가 먼저오고 피연산자가 오는 형식입니다.");
			System.out.println("예시 : * 3 + 4 5 =");
			System.out.println("infix 형식은 '숫자 연산자 숫자 연산자 .. '= 형식입니다.");
			System.out.println("예시 : 3 - 4 + 6 =");
		}
	}
	public void run() {
		try {
			Print();
			int version = getVer();
			int end = getEnd();
			if(version=='1') {
			int code = readOperator(end);
			while (code != end) {
				int result = main(code);
				System.out.println(result);
				code = readOperator(end);
			}
			}
			if(version=='2') {
				Calculator2 calculator2 = new Calculator2();
				calculator2.run(end);
			}
			System.out.println("끝!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int getVer() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("계산기의 버전을 선택하세요.");
		System.out.println("1번 : prefix ,2번 : infix");
		int version = System.in.read();
		while(!(version=='1'||version=='2')) {
			version = System.in.read();
		}
		return version;
	}

	private int getEnd() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("계산기를 끝낼 제어 문자(한 글자)를 입력해주세요: ");
		int end = System.in.read();
		while(end==CR || end==LF || end==Space || end==Tab) {
			if(end==CR) {
				System.in.read();
			}
			end=System.in.read();
		}
		return end;
	}
}