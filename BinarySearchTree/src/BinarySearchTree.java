import java.util.ArrayList;

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

	// Checking and Searching :
	// 1.Find the node with minimum value in a Binary Search Tree
	public int Minimum() {
		return Minimum(root);
	}

	public int Minimum(Node node) {
		if (node.left == null) {
			return node.data;
		}
		return Minimum(node.left);

	}

	// 2.Check if the given array can represent Level Order Traversal of Bst
	// 3.Check if a given array can represent Preorder Traversal of Binary
	// Search Tree
	// 4.Lowest Common Ancestor in a Binary Search Tree.
	public int LCA(int val1, int val2) {
		Node n = LCA(root, val1, val2);
		if (n == null) {
			return 0;

		} else {
			return n.data;
		}
	}

	public Node LCA(Node node, int val1, int val2) {
		if (node == null) {
			return null;
		}
		if (node.data == val1 || node.data == val2) {
			return node;
		}

		if (node.data > val1 && node.data > val2)
			return LCA(node.left, val1, val2);

		if (node.data < val1 && node.data < val2)
			return LCA(node.right, val1, val2);
		return node;
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

	public int Maximum() {
		return Maximum(root);
	}

	public int Maximum(Node node) {
		if (node.right == null) {
			return node.data;
		}
		return Maximum(node.right);
	}

	// 5.A program to check if a binary tree is BST or not

	// 6.Find k-th smallest element in BST (Order Statistics in BST)
	public int kthlargest(int i) {
		ArrayList<Integer> a = new ArrayList<>();
		kthlargest(root, a);
		int s = a.size();
		return a.get(s - i);

	}

	// static ArrayList<Integer> al;

	public void kthlargest(Node node, ArrayList<Integer> a) {
		if (node == null) {
			return;
		}

		kthlargest(node.left, a);

		System.out.print(node.data + " ");
		a.add(node.data);

		kthlargest(node.right, a);
	}

	// 7.Check if each internal node of a BST has exactly one child
	// Given Preorder traversal of a BST, check if each non-leaf node has only
	// one child.Assume that the BST contains unique entries.
	// 8.Check for Identical BSTs without building the trees
	// 9.K’th Largest Element in BST when modification to BST is not allowed
	// 10.K’th Largest element in BST using constant extra space
	// 11.Second largest element in BST
	// 12.K’th smallest element in BST using O(1) Extra Space
	// 13.Check if given sorted sub-sequence exists in binary search tree
	public boolean SubSeqExist(int[] arr) {
		int i = 0;
        int size=arr.length;
		SubSeqExist(root, arr, i);
		return size == i;
	}

	public void SubSeqExist(Node node, int[] arr, int i) {
		if (node == null) {
			return;
		}
		SubSeqExist(node.left, arr, i);
		if (node.data == arr[i]) {
			i++;
		}
		SubSeqExist(node.right, arr, i);

	}
	// 14.Simple Recursive solution to check whether BST contains dead end
	//Here Dead End means, we are not able to insert any integer element after that node.
	//15.Check if an array represents Inorder of Binary Search tree or not
	
	
	//MISC.
	//1.Sorted order printing of a given array that represents a BST
	public void sort(int[]arr,int s,int e){
		if(s>e){
			return;
		}
		sort(arr, s*2+1, e);
		System.out.println(arr[s]);
		sort(arr, s*2+2, e);
	}
	//2.Two nodes of a BST are swapped, correct the BST
	//3.Floor and Ceil from a BST
	public void Floor(Node node){
		
	}
	}

