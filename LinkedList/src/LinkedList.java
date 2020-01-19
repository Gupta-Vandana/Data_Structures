import java.util.HashMap;
import java.util.Stack;

public class LinkedList {
	public class Node {
		private int data;
		public Node next;
	}

	public Node head;
	private Node tail;
	private int size;

	private void handleAdd0(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		this.head = node;
		this.tail = node;
		this.size = 1;
	}

	// o1
	public void addFirst(int data) {
		if (this.size == 0) {
			this.handleAdd0(data);
		} else {
			Node node = new Node();
			node.data = data;
			node.next = this.head;

			this.head = node;
			this.size++;
		}
	}

	// o1
	public void addLast(int data) {
		if (this.size == 0) {
			this.handleAdd0(data);
		} else {
			Node node = new Node();
			node.data = data;
			node.next = null;

			this.tail.next = node;
			this.tail = node;
			this.size++;
		}
	}

	// on
	public void addAt(int data, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Out of bound");
		}

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size) {
			this.addLast(data);
		} else {
			Node m1 = getNodeAt(idx - 1);
			Node p1 = m1.next;

			Node node = new Node();
			node.data = data;

			m1.next = node;
			node.next = p1;

			this.size++;
		}
	}

	// o1
	public int size() {
		return this.size;
	}

	// o1
	public boolean isEmpty() {
		return this.size == 0;
	}

	// on
	public void display() {
		System.out.println("-------------------------------------------------");
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("-------------------------------------------------");
	}

	// o1
	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		return this.head.data;
	}

	// o1
	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		return this.tail.data;
	}

	// on
	public int getAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Out of bound");
		}

		int cidx = 0;
		Node cnode = this.head;

		while (cidx < idx) {
			cnode = cnode.next;
			cidx++;
		}

		return cnode.data;
	}

	// on
	private Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Out of bound");
		}

		int cidx = 0;
		Node cnode = this.head;

		while (cidx < idx) {
			cnode = cnode.next;
			cidx++;
		}

		return cnode;
	}

	// o1
	private int handleRemove1() {
		int rv = this.head.data;

		this.head = null;
		this.tail = null;
		this.size = 0;

		return rv;
	}

	// o1
	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}

		if (this.size == 1) {
			return handleRemove1();
		} else {
			int rv = this.head.data;

			this.head = this.head.next;
			this.size--;

			return rv;
		}
	}

	// on
	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}

		if (this.size == 1) {
			return handleRemove1();
		} else {
			int rv = this.tail.data;

			this.tail = this.getNodeAt(this.size - 2);
			this.tail.next = null;
			this.size--;

			return rv;
		}
	}

	// on
	public int removeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Out of bound");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size - 1) {
			return this.removeLast();
		} else {
			Node m1 = getNodeAt(idx - 1);
			Node n = m1.next;
			Node p1 = n.next;

			m1.next = p1;
			this.size--;

			return n.data;
		}
	}

	// GFG
	// Singly Linked List
	// 1.
	// 2.
	// 3.
	// 4.
	// 5.
	// 6.Write a function to delete a linked list
	public void DeleteLinkedList() {
		this.head = null;
	}

	// 7.
	// 8.
	// 9.
	// 10.Program for n’th node from the end of a Linked List
	public int nthNodeFromEnd(int idx) throws Exception {
		Node ahead = this.getNodeAt(idx);
		Node slow = this.head;
		while (ahead != null) {
			slow = slow.next;
			ahead = ahead.next;
		}
		return slow.data;
	}

	// 11.Find the middle of a given linked list
	// 12.
	// 13.Detect loop in linked list
	public boolean DetectLoop() {
		HashMap<Node, Integer> hm = new HashMap<>();
		Node strt = this.head;
		while (strt != null) {
			if (hm.containsKey(strt)) {
				return true;
			}
			hm.put(strt, strt.data);
		}
		return true;
	}

	// 14.Find the length of loop in linked list
	public int LengthOfLoop() {
		int length = 0;
		HashMap<Node, Integer> hm = new HashMap<>();
		Node strt = this.head;
		while (strt.next != null) {
			if (hm.containsKey(strt.next)) {
				int getl = hm.get(strt);
				int getl1 = hm.get(strt.next);
				return getl1 - getl;
			}
			hm.put(strt, length++);
		}

		return 0;
	}

	// 31-12-2019
	// 20. Move last element to front of a given Linked List
	// eg-1->2->3->4->5 5->1->2->3->4
	public void RotateLL() throws Exception {
		Node temp = this.tail;
		this.tail = this.getNodeAt(this.size - 2);
		this.tail.next = null;
		// System.out.println(this.head);
		temp.next = this.head;
		// System.out.println(temp);
		this.head = temp;
		// System.out.println(this.head);

	}

	// 19.Pairwise swap elements of a given linked list
	// 1->2->3->4->5->NULL 2->1->4->3->5->NULL
	public void SwapElements() {
		Node cnode = this.head;
		while (cnode != null && cnode.next != null) {
			int temp = cnode.data;
			cnode.data = cnode.next.data;
			cnode.next.data = temp;
			cnode = cnode.next.next;

		}
	}

	Node temp = this.head;

	// Recursive Solution
	// 18.Swap nodes in a linked list without swapping data
	// Linked List Assignment
	// 7. Check if a linked list is a palindrome
	public boolean palindrome(Node node, Stack<Integer> stack) {
		if (node == null) {
			return true;
		}
		stack.push(node.data);
		if (node.data == (int) stack.pop() && palindrome(node.next, stack)) {
			return true;
		} else {
			return false;
		}

	}

}