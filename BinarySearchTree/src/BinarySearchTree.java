import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	Node root;
	int size;

	public class Node {
		Node left;
		Node right;
		int data;

		public Node(int val) {
			data = val;
			left = right = null;
		}
	}

	public BinarySearchTree() {
		this.root = null;
	}

	public void add(int key) {
		root = add(root, key);
	}

	public Node add(Node node, int val) {

		if (node == null) {
			node = new Node(val);
			return node;
		}

		if (val < node.data)
			node.left = add(node.left, val);
		else if (val > node.data)
			node.right = add(node.right, val);

		return node;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String s = "";
		if (node.left != null) {
			s = s + node.left.data;
		}
		s = s + "=>" + node.data + "<=";
		if (node.right != null) {
			s = s + node.right.data;
		}
		System.out.println(s);
		display(node.left);
		display(node.right);
	}

	public boolean find(int val) {
		return find(root, val);
	}

	public boolean find(Node node, int val) {
		if (node == null) {
			return false;
		} else if (node.data == val) {
			return true;
		}

		else if (node.data < val) {
			return find(node.right, val);
		} else if (node.data > val) {
			return find(node.left, val);
		} else {
			return false;
		}
	}

	public int Minimum() {
		return Minimum(root);
	}

	public int Minimum(Node node) {
		if (node.left == null) {
			return node.data;
		}
		return Minimum(node.left);

	}

	public int Maximum() {
		return Maximum(root);
	}

	public int Maximum(Node node) {
		if (node.right == null) {
			return node.data;
		}
		return Maximum(node.right);
	}

	public int Size(Node node) {
		if (node == null) {
			return 0;
		}
		return Size(node.left) + Size(node.right) + 1;
	}

	public int height() {
		return height(root);
	}

	public int height(Node node) {
		if (node == null) {
			return 0;
		}
		int l = height(node.left);
		int r = height(node.right);
		return Math.max(l, r) + 1;
	}

	public void InOrder() {
		InOrder(this.root);

	}

	private void InOrder(Node node) {
		if (node == null) {
			return;
		}
		InOrder(node.left);
		System.out.println(node.data);
		InOrder(node.right);
	}

	/////////
	// Level Order Traversal of a binary tree
	public void levelOrder() {
		levelOrder(this.root);
	}

	private static void levelOrder(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (true) {
			int count = q.size();
			if (count == 0) {
				break;
			}
			while (count > 0) {
				Node poll = q.poll();
				System.out.print(poll.data + " ");
				// System.out.println(poll);
				if (poll.left != null)
					q.add(poll.left);
				if (poll.right != null)
					q.add(poll.right);
				count--;
			}
			System.out.println();
		}
	}

	// Lowest Common Ancestor in a Binary Search Tree.
	public int LCA(int node1, int node2) {
		return LCA(this.root, node1, node2).data;
	}

	private Node LCA(Node node, int node1, int node2) {
		if (node == null) {
			return null;
		}
		if (node.data > node1 && node.data > node2) {
			return LCA(node.left, node1, node2);
		}
		if (node.data < node1 && node.data < node2) {
			return LCA(node.right, node1, node2);
		}

		else
			return node;
	}

	// Find k-th smallest element in BST
	

}
