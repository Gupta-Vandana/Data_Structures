import java.io.*;
import java.util.HashMap;

class GFG {

	    static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	    static Node newNode(int key) {
			Node temp = new Node(key);

			return temp;
		}

//	// Returns count of nodes present in loop.
//	static int countNodes(Node n) {
//		int res = 1;
//		Node temp = n;
//		while (temp.next != n) {
//			res++;
//			temp = temp.next;
//		}
//		return res;
//	}
//
//	/*
//	 * This function detects and counts loop nodes in the list. If loop is not
//	 * there in then returns 0
//	 */
//	static int countNodesinLoop(Node list) {
//		Node slow_p = list, fast_p = list;
//
//		while (slow_p != null && fast_p != null && fast_p.next != null) {
//			slow_p = slow_p.next;
//			fast_p = fast_p.next.next;
//
//			/*
//			 * If slow_p and fast_p meet at some point then there is a loop
//			 */
//			if (slow_p == fast_p)
//				return countNodes(slow_p);
//		}
//
//		/* Return 0 to indeciate that ther is no loop */
//		return 0;
//	}	
	    public static int LengthOfLoop(Node n) {
			int length = 0;
			HashMap<Node, Integer> hm = new HashMap<>();
			Node strt = n;
			while (n != null) {
				if (hm.containsKey(n)) {
					int getl = hm.get(strt);
					int getl1 = hm.get(n);
					return getl1 - getl;
				}
				hm.put(n, length++);
				strt=n;
				n=n.next;
			}

			return 0;
		}
		public static void main(String[] args) {
		Node head = newNode(1);
		head.next = newNode(2);
		head.next.next = newNode(3);
		head.next.next.next = newNode(4);
		head.next.next.next.next = newNode(5);

		/* Create a loop for testing */
		head.next.next.next.next.next = head.next;

		System.out.println(LengthOfLoop(head));
	}
}

