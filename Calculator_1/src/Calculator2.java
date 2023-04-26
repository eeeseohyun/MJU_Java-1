import java.io.IOException;

public class Calculator2 {
	final static int CR = 0x0d;
	final static int Space=0x20;
	final static int Tab=0x09;
	final static int LF =0x10;
	final static int WORDZERO='0';

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

	public void run(int end) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("infix 형식으로 계산식을 입력해주세요.");
		System.out.println("연산자 : + _ * / ");
		int result=0;
		int input1=getInt();
		int Op = getOperator();
		while(input1!=end) {
			while(Op!='=') {
				int input2=getInt2(end);
				result= compute(input1,Op,input2);
				input1=result;
				Op = getOperator();
		}
		System.out.println(result);
		System.out.println("숫자와 연산자 식을 입력해주세요");
		input1=getInt();
		Op = getOperator();
	}
	}

	private int getInt2(int end) throws IOException {
		// TODO Auto-generated method stub
		int input2=System.in.read();
		input2=checkInt2(input2,end);
		return input2;
	}

	private int checkInt2(int input2,int end) throws IOException {
		// TODO Auto-generated method stub
		if(input2=='(') {
			int result=0;
			int input1=getInt();
			int Op = getOperator();
			while(Op!=')') {
			int input3=getInt2(end);
			input3=changeInt(input3);
			result= compute(input1,Op,input3);
			input1=result;
			Op=getOperator();
		}
			return result;
		}
		while(!(input2 >= '0' && input2 <= '9')) {
			input2=System.in.read();
		}
		input2=changeInt(input2);
			return input2;
	}

	private int compute(int input1, int Op, int input2) {
		// TODO Auto-generated method stub
		int result=0;
		switch(Op) {
		case '+' : result = input1+input2;
			break;
		case '-' : result = input1-input2;
			break;
		case '*' : result = input1*input2;
			break;
		case '/' : result = input1/input2;
			break;
		}
		return result;
	}

	private int getOperator() throws IOException {
		// TODO Auto-generated method stub
		int Op= System.in.read();
		while(!(Op == '*' || Op == '-' || Op == '+' || Op == '/' || Op==')' || Op=='=')) {
			System.out.println("+ - * / 중에서 다시 입력해주세요.");
			Op=System.in.read();
		}
		return Op;
	}

	private int getInt() throws IOException {
		// TODO Auto-generated method stub
		int input1=System.in.read();
		input1=checkInt(input1);
		return input1;
	}

	private int checkInt(int input1) throws IOException {
		// TODO Auto-generated method stub
		while(!(input1 >= '0' && input1 <= '9')) {
			input1=System.in.read();
		}
		input1=changeInt(input1);
			return input1;
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
}



