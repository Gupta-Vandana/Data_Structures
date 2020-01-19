import java.util.Scanner;

public class Client {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);

		String str = scn.next();
		Stack s = new Stack<>(str.length());
	}

	@SuppressWarnings("unchecked")
	public static void DuplicateParen(String str, Stack s) {

		for (int i = 0; i <= str.length(); i++) {
			char ch = str.charAt(i);
			s.Push(ch);
		}

	}

}
