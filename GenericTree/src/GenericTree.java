import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
	Node root;
	int size;

	public class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public GenericTree() {
		this.root = this.takeInput(new Scanner(System.in), null, -1);
	}

	public void display() {
		this.display(root);
	}

	public void display(Node node) {
		String str = node.data + "=>";
		for (Node child : node.children) {
			str += child.data + ",";

		}
		System.out.println(str + " ,");
		for (Node child : node.children) {
			this.display(child);
		}
	}

	public Node takeInput(Scanner scn, Node parent, int i) {
		if (parent == null) {
			System.out.println("enter the root");
		} else {
			System.out.println("enter the " + i + "  child of " + parent.data);
		}

		int val = scn.nextInt();
		Node child = new Node();
		child.data = val;
		this.size++;

		System.out.println("enter the number of " + child.data);
		int numchild = scn.nextInt();

		for (int j = 0; j < numchild; j++) {
			Node grandchildren = takeInput(scn, child, numchild);
			child.children.add(grandchildren);
		}

		return child;
	}

	public int size2() {
		return this.size2(root);
	}

	public int size2(Node node) {
		int size = 0;
		for (Node child : node.children) {
			int csize = this.size2(child);
			size += csize;
		}
		return size + 1;
	}

	public int maximum() {
		return maximum(root);
	}

	public int maximum(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			int cmax = maximum(child);
			max = Math.max(max, cmax);

		}
		return max;
	}

	public boolean find(int val) {
		return find(this.root, val);
	}

	public boolean find(Node node, int val) {
		if (node.data == val) {
			return true;
		}
		for (Node child : node.children) {
			boolean fic = find(child, val);
			if (fic == true) {
				return true;
			}
		}
		return false;
	}

	public int height() {
		return this.height(this.root);
	}

	public int height(Node node) {
		int h = -1;
		for (Node child : node.children) {
			int ch = height(child);
			h = Math.max(h, ch);
		}
		return h + 1;
	}

	public void mirror() {

	}
}
