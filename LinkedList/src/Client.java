import java.util.Stack;

public class Client {

	public static void main(String[] args) throws Exception {
		//size of a ll --> n-1 elements starts from 0

		LinkedList l = new LinkedList();
		l.addAt(10, 0);
		l.addAt(20, 1);
		l.addAt(30, 2);
		l.addAt(40, 3);
		l.addAt(50, 4);
		l.addAt(60, 5);
		l.addAt(70, 6);
		l.addAt(80, 7);
		l.addAt(90, 8);
		l.addAt(100, 9);
		l.addAt(110, 10);
		l.display();
		Stack<Integer> s = new Stack<>();
		System.out.println(l.palindrome(l.head, s));
		

	}

}
