import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class BinaryTree {
	Node root;
	int size;

	public class Node {
		Node left;
		Node right;
		int data;
	}

	public BinaryTree() {
		this.root = this.takeInput(null, new Scanner(System.in), false);
	}

	public Node takeInput(Node parent, Scanner scn, boolean ic) {
		if (parent == null) {
			System.out.println("enter data for root");
		} else {
			if (ic) {
				System.out.println("enter data for left child");
			} else {
				System.out.println("enter data for right child");
			}
		}

		Node child = new Node();
		child.data = scn.nextInt();
		size++;

		System.out.println("do you have left for " + child.data);
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			child.left = takeInput(child, scn, true);
		}

		System.out.println("do you have right child for " + child.data);
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			child.right = takeInput(child, scn, false);
		}

		return child;

	}

	public void display() {
		display(root);
	}

	public void display(Node node) {
		if (node == null) {
			return;
		}
		String src = "";
		if (node.left != null) {
			src += node.left.data;
		} else {
			src += ".";
		}
		src += "=>" + node.data + "<=";
		if (node.right != null) {
			src += node.right.data;
		} else {
			src += ".";
		}
		System.out.println(src);
		this.display(node.left);
		this.display(node.right);
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int Size() {
		return this.Size(root);
	}

	private int Size(Node node) {
		if (node == null) {
			return 0;
		}
		int l = this.Size(node.left);
		int r = this.Size(node.right);
		return l + r + 1;

	}

	public boolean find(int val) {
		return this.find(val, root);
	}

	public boolean find(int val, Node node) {
		if (node == null) {
			return false;
		}
		if (val == node.data) {
			return true;
		}
		boolean l = find(val, node.left);
		if (l) {
			return true;
		}

		boolean r = find(val, node.right);
		if (r) {
			return true;
		}

		return false;
	}

	public int max() {
		return this.max(root);
	}

	public int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int max1 = max(node.left);
		int max2 = max(node.right);

		return Math.max(node.data, Math.max(max1, max2));

	}

	public int height() {
		return this.height(root);
	}

	public int height(Node node) {
		if (node == null) {
			return 0;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		return Math.max(lh, rh) + 1;
	}

	public int diameter() {
		return this.diameter(root);
	}

	public int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int lh = height(node.left);
		int rh = height(node.right);

		int ld = diameter(node.left);
		int rd = diameter(node.right);

		return Math.max(lh + rh + 1, Math.max(ld, rd));
	}

	public class Diapair {
		int height;
		int diameter;
	}

	public int diameter2() {
		return diameter2(root).diameter;
	}

	public Diapair diameter2(Node node) {
		if (node == null) {
			Diapair bp = new Diapair();
			bp.height = -1;
			bp.diameter = 0;
			return bp;
		}
		Diapair l = diameter2(node.left);
		Diapair r = diameter2(node.right);

		Diapair rp = new Diapair();
		rp.height = Math.max(l.height, r.height) + 1;
		rp.diameter = Math.max(l.height + r.height + 2, Math.max(l.diameter, r.diameter));
		return rp;
	}

	public boolean isBalanced() {
		return this.isBalanced(this.root);
	}

	public boolean isBalanced(Node node) {
		if (node == null) {
			return false;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		int check = Math.abs(lh - rh);
		if (check <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
			return true;
		} else
			return false;
	}

	public void PreOrder() {
		this.PreOrder(this.root);
	}

	public void PreOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		PreOrder(node.left);
		PreOrder(node.right);
	}

	public void PostOrder() {
		this.PostOrder(this.root);
	}

	public void PostOrder(Node node) {
		if (node == null) {
			return;
		}

		PostOrder(node.left);
		PostOrder(node.right);
		System.out.println(node.data);
	}

	public void InOrder() {
		this.InOrder(this.root);
	}

	public void InOrder(Node node) {
		if (node == null) {
			return;
		}

		InOrder(node.left);
		System.out.println(node.data);
		InOrder(node.right);

	}

	// 24-MAY
	// Question asked in TA interview
	// nai hua tha mjse but utkarsh se ho gya tha kyu ki usne mehnat kri thi
	// AND MENE NAI KARI THI MEHNAT 
	public int maximum() {
		return maximum(root);
	}

	public int maximum(Node node) {
		if (node == null) {
			return 0;
		}
		int lh = max(node.left);
		int rh = max(node.right);

		int ld = maximum(node.left);
		int rd = maximum(node.right);

		return Math.max(lh + rh + node.data, Math.max(ld, rd));
	}

	// GEEKS FOR GEEKS
	// SUMMATION
	// 1.Sum of all nodes in a binary tree
	public int sumAllNode() {
		return sumAllNode(root);
	}

	public int sumAllNode(Node node) {
		if (node == null) {
			return 0;
		}
		int suml = sumAllNode(node.left);
		int sumr = sumAllNode(node.right);
		return suml + sumr + node.data;
	}

	// 2.Sum of all the parent nodes having child node x
	public int ParentOfX(int x) {
		ParentOfX(root, x);
		return sum;
	}

	public void ParentOfX(Node node, int x) {
		if (node == null) {
			return;
		}
		if (isLeaf(node)) {
			return;
		}
		if (node.left != null && node.left.data == x) {
			sum += node.data;
		}
		if (node.right != null && node.right.data == x) {
			sum += node.data;
		}

		ParentOfX(node.left, x);
		ParentOfX(node.right, x);

	}

	// 3.Find sum of all left leaves in a given Binary Tree
	static int sum = 0;

	public int leftsum() {

		leftsum(root, false);
		return sum;
	}

	public void leftsum(Node node, boolean isLeft) {
		if (node == null) {
			return;
		}
		if ((node.left == null && node.right == null) && isLeft) {
			sum += node.data;
		}
		leftsum(node.left, true);
		leftsum(node.right, false);
	}
	// 4.Find sum of all right leaves in a given Binary Tree

	public int rightsum() {

		rightsum(root, false);
		return sum;
	}

	public void rightsum(Node node, boolean isRight) {
		if (node == null) {
			return;
		}
		if ((node.left == null && node.right == null) && isRight) {
			sum += node.data;
		}
		rightsum(node.left, false);
		rightsum(node.right, true);
	}
	// 5.Find sum of all nodes of the given perfect binary tree

	// 6.Diagonal Sum of a Binary Tree
	public HashMap<Integer, Integer> diagonalSum() {
		HashMap<Integer, Integer> hm = new HashMap<>();
		diagonalSum(root, hm, 0);
		return hm;
	}

	public void diagonalSum(Node node, HashMap<Integer, Integer> hm, int d) {
		if (node == null) {
			return;
		}
		if (hm.containsKey(d)) {
			int v = hm.get(d);
			v += node.data;
			hm.put(d, v);
		} else {
			hm.put(d, node.data);
		}
		diagonalSum(node.left, hm, d + 1);
		diagonalSum(node.right, hm, d);
	}

	// 7.Find if there is a pair in root to a leaf path with sum equals to
	// root’s data
	public boolean PairInRootToLeafPath() {
		ArrayList<Integer> a = new ArrayList<>();
		return PairInRootToLeafPath(root.left, root.data, a) || PairInRootToLeafPath(root.right, root.data, a);
	}

	private boolean PairInRootToLeafPath(Node node, int data, ArrayList<Integer> a) {
		if (node == null) {
			return false;
		}
		int rem = data - node.data;
		if (a.contains(rem) == true) {
			return true;
		}
		a.add(node.data);
		boolean res = PairInRootToLeafPath(node.left, data, a) || PairInRootToLeafPath(node.right, data, a);
		a.remove(node.data);
		return res;
	}

	// 8.Sum of nodes on the longest path from root to leaf node
	static int maxSum;
	static int maxLen;

	public int longestPathSum() {
		longestPathSum(root, 0, 0);
		return maxSum;
	}

	public void longestPathSum(Node node, int sum, int len) {
		if (node == null) {
			if (maxLen < len) {
				maxSum = sum;
				maxLen = len;
			} else if (maxLen == len) {
				if (maxSum < sum) {
					maxSum = sum;
				}
			}
			return;
		}
		longestPathSum(node.left, sum + node.data, len + 1);
		longestPathSum(node.right, sum + node.data, len + 1);

	}

	// 9.Remove all nodes which don’t lie in any path with sum>= k
	// we have to delete it only in case when all paths from it have sum less
	// than K.
	public void RemoveNodes(int k) {
		Node n = RemoveNodes(root, k, 0);
		display(n);
	}

	private Node RemoveNodes(Node node, int k, int sum) {
		if (node == null) {
			return null;
		}
		int lsum = node.data + sum;
		int rsum = lsum;
		Node l = RemoveNodes(node.left, k, lsum);
		Node r = RemoveNodes(node.right, k, rsum);
		if (sum < k) {
			node = null;
		}
		return node;
	}

	// 10.Find the maximum path sum between two leaves of a binary tree
	public int maxPathSum() {
		pair p = maxPathSum(root);
		// return Math.max(mps,p.mpsrooted);
		// return mps;
		return p.mpsrooted;
	}

	private class pair {
		int mpsrooted = 0;
		String mpsrootedpath = "";

		pair(int mpsrooted, String mpsrootedpath) {
			this.mpsrooted = mpsrooted;
			this.mpsrootedpath = mpsrootedpath;
		}
	}

	static int mps = Integer.MIN_VALUE;
	static String mpspath = "";

	private pair maxPathSum(Node node) {
		if (node.left == null && node.right == null) {
			return new pair(node.data, node.data + " ");
		} else if (node.left == null) {
			pair rp = maxPathSum(node.right);
			return new pair(rp.mpsrooted + node.data, rp.mpsrootedpath + "" + node.data);
		} else if (node.right == null) {
			pair lp = maxPathSum(node.left);
			return new pair(lp.mpsrooted + node.data, lp.mpsrootedpath + "" + node.data);
		} else {
			pair lp = maxPathSum(node.left);
			pair rp = maxPathSum(node.right);
			pair mp = new pair(0, "");
			if (lp.mpsrooted >= rp.mpsrooted) {
				mp.mpsrooted = lp.mpsrooted + node.data;
				mp.mpsrootedpath = lp.mpsrootedpath + node.data;
			}
			if (lp.mpsrooted <= rp.mpsrooted) {
				mp.mpsrooted = rp.mpsrooted + node.data;
				mp.mpsrootedpath = rp.mpsrootedpath + node.data;
			}
			if (lp.mpsrooted + node.data + rp.mpsrooted + node.data > mps) {
				mps = lp.mpsrooted + node.data + rp.mpsrooted + node.data;
				mpspath = lp.mpsrootedpath + "" + node.data + "" + rp.mpsrootedpath;
			}
			return mp;
		}
	}

	public int maximumPathSum() {
		res rs = new res();
		rs.val = Integer.MIN_VALUE;
		maximumPathSum(root, rs);
		return rs.val;
	}

	private class res {
		int val;
	}

	private int maximumPathSum(Node node, res rs) {
		if (node == null) {
			return 0;
		}
		if (isLeaf(node)) {
			return node.data;
		}
		int l = maximumPathSum(node.left, rs);
		int r = maximumPathSum(node.right, rs);
		if (node.left != null && node.right != null) {
			rs.val = Math.max(rs.val, l + r + node.data);
			return Math.max(l, r) + node.data;
		}
		return (node.left == null) ? r + node.data : l + node.data;

	}

	// 11.Find the maximum sum leaf to root path in a Binary Tree
	public boolean isLeaf(Node node) {
		if (node.left == null && node.right == null) {
			return true;
		} else {
			return false;
		}
	}

	public int LeafToRootSum() {
		LeafToRootSum(root, 0);
		return maxSum;
	}

	public void LeafToRootSum(Node node, int sum) {
		if (node == null) {
			if (maxSum < sum) {
				maxSum = sum;
			}
			return;

		}
		if (isLeaf(node) && (maxSum < sum)) {
			maxSum = sum;
		}
		LeafToRootSum(node.left, sum + node.data);
		LeafToRootSum(node.right, sum + node.data);
	}
	// 12.Maximum sum of nodes in Binary tree such that no two are adjacent
	// 13.
	// 14.Find largest subtree sum in a tree

	public int MaxSubTreeSum() {
		MaxSubTreeSum(root);
		return maxSum;
	}

	public int MaxSubTreeSum(Node node) {
		if (node == null) {
			return 0;
		}

		int lsum = MaxSubTreeSum(node.left);
		int rsum = MaxSubTreeSum(node.right);
		int sum = node.data + lsum + rsum;

		maxSum = Math.max(maxSum, sum);
		return sum;
	}

	// 15.Print all k-sum paths in a binary tree

	// 16.Sum of heights of all individual nodes in a binary tree
	public void HeightsIndividual() {
		int h = height(root);
		HeightsIndividual(root, h);
	}

	private void HeightsIndividual(Node node, int h) {
		if (node == null) {
			return;
		}
		HeightsIndividual(node.left, h - 1);
		HeightsIndividual(node.right, h - 1);
		System.out.println(node.data + "=>" + h);
	}
	// 17. Subtree with given sum in a Binary Tree

	// You are given a binary tree and a given sum. The task is to check
	// if there exist a subtree whose sum of all nodes is equal to the given sum

	public class SubTreePair {
		int sum;
		boolean isEqualToX;
	}

	public boolean SubTreeWithXSum(int x) {
		SubTreeWithXSum(root, x);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	static int count;

	public SubTreePair SubTreeWithXSum(Node node, int x) {
		if (node == null) {
			SubTreePair pair = new SubTreePair();
			pair.sum = 0;
			pair.isEqualToX = false;
			return pair;

		}
		SubTreePair l = SubTreeWithXSum(node.left, x);
		SubTreePair r = SubTreeWithXSum(node.right, x);

		SubTreePair newPair = new SubTreePair();
		newPair.sum = node.data + l.sum + r.sum;
		if (x == newPair.sum) {
			newPair.isEqualToX = true;
			count++;

		} else {
			newPair.isEqualToX = false;
			// return newPair;
		}
		return newPair;

	}

	// 18. Count subtrees that sum up to a given value x
	public int CountSubTrees(int x) {
		SubTreeWithXSum(root, x);
		return count;
	}

	// 19.Sum of nodes at maximum depth of a Binary Tree
	public int SumAtMaxDepth() {
		int h = height(root);
		SumAtMaxDepth(root, h, 1);
		return sum;
	}

	private void SumAtMaxDepth(Node node, int h, int lev) {
		if (node == null) {
			return;
		}
		SumAtMaxDepth(node.left, h, lev + 1);
		SumAtMaxDepth(node.right, h, lev + 1);
		if (lev == h) {
			sum += node.data;
		}
	}

	// 20.Difference between sums of odd level and even level nodes of a Binary
	// Tree
	static int sumOdd;
	static int sumEven;

	public int DiffOddEvenLevel() {
		DiffOddEvenLevel(root, 1);
		return sumOdd - sumEven;
	}

	private void DiffOddEvenLevel(Node node, int lev) {
		if (node == null) {
			return;
		}
		if (lev % 2 == 0) {
			sumEven += node.data;
		} else {
			sumOdd += node.data;
		}
		DiffOddEvenLevel(node.left, lev + 1);
		DiffOddEvenLevel(node.right, lev + 1);
	}

	// 21.Find maximum level sum in Binary Tree
	public int maxSumInLevel() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int res = root.data;

		while (!q.isEmpty()) {
			int nodecount = q.size();
			int sum = 0;
			while (nodecount > 0) {
				Node temp = q.remove();
				sum += temp.data;
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
			res = Math.max(res, sum);
		}
		return res;
	}

	// 22.maximum spiral sum in a binary tree
	// spiral order traversal of a binary tree
	public void spiralTraversal() {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node temp = s1.pop();
				System.out.println(temp.data);
				if (temp.right != null) {
					s2.add(temp.right);
				}
				if (temp.left != null) {
					s2.add(temp.left);
				}
			}
			while (!s2.isEmpty()) {
				Node temp = s2.pop();
				System.out.println(temp.data);
				if (temp.left != null) {
					s1.add(temp.left);
				}
				if (temp.right != null) {
					s1.add(temp.right);
				}
			}
		}

	}
	// 23.Sum of nodes at k-th level in a tree represented as string

	// 24.Sum of all leaf nodes of binary tree

	public int sumLeaves() {
		sumLeaves(root);
		return sum;
	}

	public void sumLeaves(Node node) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			sum += node.data;
		}
		sumLeaves(node.left);
		sumLeaves(node.right);
	}

	// 25.Sum of leaf nodes at minimum level
	public int MinLevelLeaf() {
		int minh = minDepth(root);
		MinLevelLeaf(root, 1, minh);
		return sum;
	}

	public void MinLevelLeaf(Node node, int lev, int minh) {

		if (isLeaf(node) && minh == lev) {
			sum += node.data;
		}
		if (node.left != null) {
			MinLevelLeaf(node.left, lev + 1, minh);
		}
		if (node.right != null) {
			MinLevelLeaf(node.right, lev + 1, minh);
		}
	}

	// 26.Root to leaf path sum equal to a given number
	public boolean rootLeafPathK(int k) {
		return rootLeafPathK(k, root);
	}

	public boolean rootLeafPathK(int k, Node node) {
		if (node == null) {
			if (k == 0) {
				return true;
			} else
				return false;
		}
		// if(isLeaf(node) && (k-node.data==0)){
		// return true;
		// }
		boolean l = rootLeafPathK(k - node.data, node.left);
		boolean r = rootLeafPathK(k - node.data, node.right);

		if (l) {
			return true;
		} else if (r) {
			return true;
		} else {
			return false;
		}
	}

	// 27.Sum of all the numbers that are formed from root to leaf paths
	public int SumOfAllPathNumber() {
		SumOfAllPathNumber(root, 0);
		return sum;
	}

	public void SumOfAllPathNumber(Node node, int data) {

		if (isLeaf(node)) {
			sum += data;
			return;
		}
		if (node.left != null) {
			SumOfAllPathNumber(node.left, data * 10 + node.data);
		}
		if (node.right != null) {
			SumOfAllPathNumber(node.right, data * 10 + node.data);
		}

	}

	public int RootToLeafPathSums() {
		RootToLeafPathSums(root, 0);
		return sum;
	}

	public void RootToLeafPathSums(Node node, int dtn) {
		if (node == null) {
			return;
		}
		if (isLeaf(node)) {
			sum += dtn;
		}
		RootToLeafPathSums(node.left, dtn + node.data);
		RootToLeafPathSums(node.right, dtn + node.data);
	}

	// 29.Vertical Sum in a given Binary Tree | Set 1
	public HashMap<Integer, Integer> VerticalSum() {
		HashMap<Integer, Integer> hm = new HashMap<>();
		VerticalSum(root, hm, 0);
		return hm;
	}

	public void VerticalSum(Node node, HashMap<Integer, Integer> hm, int vd) {
		if (node == null) {
			return;
		}
		if (hm.containsKey(vd)) {
			int n = hm.get(vd);
			n += node.data;
			hm.put(vd, n);
		} else {
			hm.put(vd, node.data);
		}
		VerticalSum(node.left, hm, vd - 1);
		VerticalSum(node.right, hm, vd + 1);
	}
	// 30.Vertical Sum in Binary Tree | Set 2 (Space Optimized)

	// 31.Find root of the tree where children id sum for every node is given

	// 32.Replace each node in binary tree with the sum of its inorder
	// predecessor and successor
	public void Replace() {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(0);
		replaceInInorder(root, al);
		al.add(0);
		Replace(root, al, 1);
		display(root);
	}

	public void replaceInInorder(Node node, ArrayList<Integer> al) {
		if (node == null) {
			return;
		}
		replaceInInorder(node.left, al);
		al.add(node.data);
		replaceInInorder(node.right, al);
	}

	public void Replace(Node node, ArrayList<Integer> al, int i) {
		if (node == null) {
			return;
		}
		Replace(node.left, al, i);
		node.data = al.get(i - 1) + al.get(i + 1);
		++i;
		Replace(node.right, al, i);
	}
	// 33.Find largest subtree sum in a tree
	// same as question 14

	// MISC

	// 1.Succinct Encoding of Binary Tree
	// 2.Binary Indexed Tree : Range Updates and Point Queries
	// 3.The Great Tree-List Recursion Problem.
	// 4.Custom Tree Problem
	// 5.Tree Isomorphism Problem
	public boolean areIsomorphism(Node a, Node b) {
		if (a == null && b == null) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		if (a.data != b.data) {
			return false;
		}
		boolean l = areIsomorphism(a.left, b.left);
		boolean r = areIsomorphism(a.right, b.right);
		boolean l0 = areIsomorphism(a.left, b.right);
		boolean r0 = areIsomorphism(a.right, b.left);
		return ((l || r) && (l0 || r0));
	}

	// 6.Ways to color a skewed tree such that parent and child have different
	// colors
	// 7.Write a program to Delete a Tree.
	public void delete() {
	}

	public void delete(Node node) {
		if (node == null) {
			return;
		}
		delete(node.left);
		delete(node.right);
		node = null;
	}

	// 8.Delete leaf nodes with value as x
	public void deleteX(int x) {
		deleteX(root, x);
	}

	public void deleteX(Node node, int x) {
		if (node == null) {
			return;
		}
		deleteX(node.left, x);
		deleteX(node.right, x);
		if (node.data == x && isLeaf(node)) {
			node = null;
		}
	}
	// 9.Non-recursive program to delete an entire binary tree

	// 15.Height of binary tree considering even level leaves only
	public int EvenLevelHeight() {
		EvenLevelHeight(root, 1);
		return evenHeight;
	}

	static int evenHeight;

	public void EvenLevelHeight(Node node, int lev) {
		if (node == null) {
			return;
		}
		if (isLeaf(node) && lev % 2 == 0) {
			evenHeight = Math.max(lev, evenHeight);
		}

		EvenLevelHeight(node.left, lev + 1);
		EvenLevelHeight(node.right, lev + 1);
	}

	// 16.Find Height of Binary Tree represented by Parent array
	// 17.How to determine if a binary tree is height-balanced?
	public boolean heightBalanced(Node node) {
		if (node == null) {
			return true;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		int chk = Math.abs(lh - rh);
		if (chk <= 1 && heightBalanced(node.left) && heightBalanced(node.right)) {
			return true;
		} else {
			return false;
		}

	}

	// 18.Find height of a special binary tree whose leaf nodes are connected
	// 19.Height of a generic tree from parent array
	// 20.Diameter of a Binary Tree
	// 21.Diameter of a Binary Tree in O(n) [A new method]
	// 22.Possible edges of a tree for given diameter, height and vertices
	// 23.Deepest right leaf node in a binary tree | Iterative approach
	public int DeepestRightLeaf() {
		int h = height(root);
		DeepestRightLeaf(root, false, 0, h);
		return leafMax;
	}

	public void DeepestRightLeaf(Node node, boolean isRight, int lev, int h) {
		if (node == null) {
			return;
		}
		if (isRight && isLeaf(node) && h == lev + 1) {
			leafMax = node.data;
		}
		DeepestLeftLeaf(node.left, false, lev + 1, h);
		DeepestLeftLeaf(node.right, true, lev + 1, h);
	}
	// 24.Sink Odd nodes in Binary Tree

	// 25.Depth of the deepest odd level node in Binary Tree
	// 26.Find depth of the deepest odd level leaf node
	public int DeepestOddLevelLeaf() {
		int h = height(root);
		if (h % 2 == 1) {
			DeepestOddLevelLeaf(root, 0, h);
		} else {
			DeepestOddLevelLeaf(root, 0, h - 1);
		}

		return Deepestleaf;
	}

	public void DeepestOddLevelLeaf(Node node, int lev, int h) {
		if (node == null) {
			return;
		}
		if (isLeaf(node) && h == lev + 1) {
			Deepestleaf = node.data;
		}
		DeepestOddLevelLeaf(node.left, lev + 1, h);
		DeepestOddLevelLeaf(node.right, lev + 1, h);
	}

	// 27.Find the Deepest Node in a Binary Tree
	public int DeepestLeaf() {
		int h = height(root);
		DeepestLeaf(root, 0, h);
		return Deepestleaf;
	}

	static int Deepestleaf;

	public void DeepestLeaf(Node node, int lev, int h) {
		if (node == null) {
			return;
		}
		if (isLeaf(node) && h == lev + 1) {
			Deepestleaf = node.data;
		}
		DeepestLeaf(node.left, lev + 1, h);
		DeepestLeaf(node.right, lev + 1, h);
	}

	// 28.Deepest left leaf node in a binary tree | iterative approach
	// 29.Deepest left leaf node in a binary tree
	public int DeepestLeftLeaf() {
		int h = height(root);
		DeepestLeftLeaf(root, false, 0, h);
		return leafMax;
	}

	static int leafMax;

	public void DeepestLeftLeaf(Node node, boolean isLeft, int lev, int h) {
		if (node == null) {
			return;
		}
		if (isLeft && isLeaf(node) && h == lev + 1) {
			leafMax = node.data;
		}
		DeepestLeftLeaf(node.left, true, lev + 1, h);
		DeepestLeftLeaf(node.right, false, lev + 1, h);
	}

	// 30.Find Minimum Depth of a Binary Tree
	public int minDepth() {
		return minDepth(root);
	}

	public int minDepth(Node node) {
		if (node == null) {
			return 0;
		}
		int l = minDepth(node.left);
		int r = minDepth(node.left);

		return Math.min(r, l) + 1;

	}

	// 31.Replace node with depth in a binary tree
	public void ReplaceWithDepth() {
		ReplaceWithDepth(root, 0);
		display(root);
	}

	public void ReplaceWithDepth(Node node, int lev) {
		if (node == null) {
			return;
		}

		ReplaceWithDepth(node.left, lev + 1);
		ReplaceWithDepth(node.right, lev + 1);
		node.data = lev;

	}

	// 32.Maximum width of a binary tree
	public int MaxWidth() {

		int maxWidth = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int count = q.size();
			maxWidth = Math.max(maxWidth, count);
			while (count > 0) {
				Node temp = new Node();
				temp = q.remove();
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				count--;
			}

		}
		return maxWidth;
	}

	// 33.Vertical width of Binary tree | Set 1
	public int VerticalWidth() {
		Set<Integer> s = new HashSet<Integer>();
		VerticalWidth(root, s, 0);
		return s.size();
	}

	public void VerticalWidth(Node node, Set<Integer> s, int hd) {
		if (node == null) {
			return;
		}
		s.add(hd);
		VerticalWidth(node.left, s, hd - 1);
		VerticalWidth(node.right, s, hd + 1);
	}
	// 34.Vertical width of Binary tree | Set 2
	// 35.Find if given vertical level of binary tree is sorted or not
	// 36.Check if a binary tree is sorted level-wise or not

	// 37.Bottom View of a Binary Tree

	// 38.Program to count leaf nodes in a binary tree
	static int numLeaf;

	public int CountLeaf() {
		CountLeaf(root);
		return numLeaf;
	}

	public void CountLeaf(Node node) {
		if (node == null) {
			return;
		}
		if (isLeaf(node)) {
			numLeaf++;
		}
		CountLeaf(node.left);
		CountLeaf(node.right);
	}

	// 40.Count Non-Leaf nodes in a Binary Tree
	public int counNonLeaf() {
		countNonLeaf(root);
		return numLeaf;
	}

	public void countNonLeaf(Node node) {
		if (node == null) {
			return;
		}
		if (!isLeaf(node)) {
			numLeaf++;
		}
		countNonLeaf(node.left);
		countNonLeaf(node.right);

	}

	// 41.Count half nodes in a Binary tree
	public int CountHalfNodes() {
		CountHalfNodes(root);
		return numLeaf;
	}

	public void CountHalfNodes(Node node) {
		if (node == null) {
			return;
		}
		if ((node.left != null) && (node.right == null)) {
			numLeaf++;
		}
		if ((node.left == null) && (node.right != null)) {
			numLeaf++;
		}
		CountHalfNodes(node.left);
		CountHalfNodes(node.right);
	}

	// 42.Count full nodes in a Binary tree
	public int CountFullNodes() {
		CountFullNodes(root);
		return numLeaf;
	}

	public void CountFullNodes(Node node) {
		if (node == null) {
			return;
		}
		if ((node.left != null) && (node.right != null)) {
			numLeaf++;
		}

		CountHalfNodes(node.left);
		CountHalfNodes(node.right);
	}

	// 43.Connect Nodes at same Level

	// 44.Connect nodes at same level using constant extra space
	// 45.Connect nodes at same level
	// 46.Level with maximum number of nodes
	public int MaximumNodes() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		int maxNode = Integer.MIN_VALUE;
		int level = 0;
		int levelno = 0;
		while (true) {
			int nodeCount = q.size();
			if (nodeCount == 0) {
				break;
			}
			if (nodeCount > maxNode) {
				maxNode = nodeCount;
				levelno = level;
			}
			while (nodeCount > 0) {
				Node temp = q.remove();
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				nodeCount--;
			}
			level++;
		}
		return levelno;
	}

	// 47.Averages of Levels in Binary Tree
	// 48.Largest value in each level of Binary Tree | Set-2 (Iterative
	// Approach)
	public void LargestValueInLevel() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int max;

		while (true) {
			int nodeCount = q.size();
			if (nodeCount == 0) {
				break;
			}
			max = Integer.MIN_VALUE;

			while (nodeCount > 0) {
				Node temp = q.remove();
				max = Math.max(max, temp.data);
				if (temp.left != null) {
					q.add(temp.left);
					max = Math.max(max, temp.data);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				nodeCount--;
				// System.out.println(max);
			}
			System.out.println(max);

		}

	}

	// 49.Smallest value in each level of Binary Tree
	public void SmallestValueInLevel() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int min;

		while (true) {
			int nodeCount = q.size();
			if (nodeCount == 0) {
				break;
			}
			min = Integer.MAX_VALUE;

			while (nodeCount > 0) {
				Node temp = q.remove();
				min = Math.min(min, temp.data);
				if (temp.left != null) {
					q.add(temp.left);

				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				nodeCount--;
				// System.out.println(max);
			}
			System.out.println(min);

		}

	}

	// 50.Get Level of a node in a Binary Tree
	public int LevelOfaNode(int val) {
		LevelOfaNode(root, val, 1);
		return level;
	}

	static int level;

	public void LevelOfaNode(Node node, int val, int lev) {
		if (node == null) {
			return;
		}
		if (node.data == val) {
			level = lev;
		}
		LevelOfaNode(node.left, val, lev + 1);
		LevelOfaNode(node.right, val, lev + 1);

	}

	// 51.Get level of a node in binary tree | iterative approach
	public int Leveliterative(int val) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int lev = 0;
		while (q.isEmpty() == false) {
			int nodeCount = q.size();

			while (nodeCount > 0) {
				Node temp = q.remove();
				if (temp.data == val) {
					return lev;
				}
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				nodeCount--;
			}
			lev++;
		}
		return -1;
	}

	// 52.Find mirror of a given node in Binary tree
	public int MirrorOfANode(int val) throws Exception {
		MirrorOfANode(root, root, val);
		return mirror;
	}

	static int mirror;

	public void MirrorOfANode(Node a, Node b, int val) throws Exception {
		if (a == null && b == null) {
			return;
		}
		if (a == null || b == null) {
			// System.out.println("Mirror value does not exist");
			return;
		}
		if (a.data == val) {
			mirror = b.data;
		}
		if (b.data == val) {
			mirror = a.data;
		}
		MirrorOfANode(a.left, b.right, val);
		MirrorOfANode(a.right, b.left, val);

	}
	// 53.Find largest subtree having identical left and right subtrees

	// 55.Closest leaf to a given node in Binary Tree

	// 57.Iterative Search for a key ‘x’ in Binary Tree
	public boolean FindIterative(int x) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (q.isEmpty() == false) {
			Node temp = q.remove();
			if (temp.data == x) {
				return true;
			}
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
		return false;
	}

	// 58.Given a binary tree, how do you remove all the half nodes?
	// 59.Swap Nodes in Binary tree of every k’th level
	public void SwapNodeAtK(int k) {
		SwapNodeAtK(root, 1, k);
	}

	public void SwapNodeAtK(Node node, int kEqual, int k) {
		if (node == null) {
			return;
		}
		if (kEqual == k) {
			Node n = new Node();
			n = node.left;
			node.left = node.right;
			node.right = n;
		}
		SwapNodeAtK(node.left, kEqual + 1, k);
		SwapNodeAtK(node.right, kEqual + 1, k);
	}

	// 60.Pairwise Swap leaf nodes in a binary tree
	// 61.Root to leaf paths having equal lengths in a Binary Tree
	public HashMap<Integer, Integer> rootToLeafPathEqualLength() {
		HashMap<Integer, Integer> hm = new HashMap<>();
		rootToLeafPathEqualLength(root, 1, hm);
		return hm;
	}

	public void rootToLeafPathEqualLength(Node node, int lev, HashMap<Integer, Integer> hm) {
		if (node == null) {
			return;
		}
		if (isLeaf(node)) {
			if (hm.containsKey(lev)) {
				int l = hm.get(lev);
				int n = l + 1;
				hm.put(lev, n);

			} else {
				hm.put(lev, 1);
			}
		}
		rootToLeafPathEqualLength(node.left, lev + 1, hm);
		rootToLeafPathEqualLength(node.right, lev + 1, hm);
	}

	// 62.Root to leaf path with maximum distinct nodes
	public void distinctNodes(Node node, HashMap<Integer, Integer> hm) {
		if (node == null) {
			return;
		}
		if (hm.containsKey(node.data)) {
			return;
		} else {
			hm.put(node.data, 1);
		}
		distinctNodes(node.left, hm);
		distinctNodes(node.right, hm);
	}

	// 63.Maximum Consecutive Increasing Path Length in Binary Tree
	public void MaxConsecutiveIncPath(Node node, int lev) {
		if (node == null) {
			return;
		}
		if (node.left != null && node.left.data > node.data) {
			lev++;
		}
	}

	// 64.Longest Path with Same Values in a Binary Tree
	public int LongestPathSameValue() {
		return LongestPathSameValue(root, root.data, 0);
	}

	private int LongestPathSameValue(Node node, int pre, int ltn) {
		if (node == null) {
			return ltn;
		}
		int curr = node.data;
		if (curr == pre) {
			return Math.max(LongestPathSameValue(node.left, curr, ltn + 1),
					LongestPathSameValue(node.right, curr, ltn + 1));
		}
		int res = Math.max(LongestPathSameValue(node.left, curr, 1), LongestPathSameValue(node.right, pre, 1));
		return Math.max(res, ltn);
	}

	// 65.Remove nodes on root to leaf paths of length < K
	// 66.Longest consecutive sequence in Binary tree

	// 71.Get maximum left node in binary tree
	public int MaxNodeLeft() {
		MaxNodeLeft(root, false);
		return maxSum;
	}

	public void MaxNodeLeft(Node node, boolean isLeft) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			if (maxSum < node.left.data && isLeft) {
				maxSum = node.left.data;
			}

		}
		MaxNodeLeft(node.left, true);
		MaxNodeLeft(node.right, true);

	}

	// 72.Find a number in minimum steps
	// 73.Factor Tree of a given Number
	// 74.Number of full binary trees such that each node is product of its
	// children
	// 75.Number of subtrees having odd count of even numbers
	// 76.Find distance from root to given node in a binary tree
	static int distance;

	public int distanceFromRoot(int val) {
		distanceFromRoot(root, val, 0);
		return distance;
	}

	public void distanceFromRoot(Node node, int val, int lev) {
		if (node == null) {
			return;
		}
		if (node.data == val) {
			distance = lev;
		}
		distanceFromRoot(node.left, val, lev + 1);
		distanceFromRoot(node.right, val, lev + 1);

	}

	// 77.Find distance between two nodes of a Binary Tree
	// 78.Find right sibling of a binary tree with parent pointers
	// 79.Find next right node of a given key | Set 2
	// 80.Tilt of Binary Tree
	static int tilt;

	public int tilt() {
		return tilt(root);
	}

	public int tilt(Node node) {
		if (node == null) {
			return 0;
		}
		int lt = tilt(node.left);
		int rt = tilt(node.right);
		tilt += Math.abs(lt - rt);
		return lt + rt + node.data;
	}
	// 81.Find All Duplicate Subtrees

	// 82.top three elements in a binary tree

	// 83.Find minimum in Binary Tree

	public int min() {
		return min(root);
	}

	public int min(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int l = min(node.left);
		int r = min(node.right);
		return Math.min(node.data, Math.min(l, r));
	}
	// LONGEST COMMON ANCESTOR:
	// 1.Lowest Common Ancestor in a Binary Tree | Set 1

	public int LCA(int n1, int n2) {
		Node n = LCA(root, n1, n2);
		if (n != null)
			return n.data;
		else {
			return -1;
		}
	}

	public Node LCA(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}
		if (node.data == n1 || node.data == n2) {
			return node;
		}
		Node l = LCA(node.left, n1, n2);
		Node r = LCA(node.right, n1, n2);

		if (l == null && r != null) {
			return r;
		} else if (l != null && r == null) {
			return l;
		} else if (l != null && r != null) {
			return node;
		} else {
			return null;
		}

	}
	// 2.Lowest Common Ancestor in a Binary Tree | Set 2 (Using Parent Pointer)
	// 3.Lowest Common Ancestor in a Binary Tree | Set 3 (Using RMQ)
	// 4.Find distance between two nodes of a Binary Tree
	// 5.Print common nodes on path from root (or common ancestors)

	// CHECKING AND PRINTING
	// 1.Check for Children Sum Property in a Binary Tree
	public boolean ChildrenSum() {
		return ChildrenSum(root);
	}

	public boolean ChildrenSum(Node node) {
		int l = 0;
		int r = 0;
		if (node == null || isLeaf(node)) {
			return true;
		}
		if (node.left != null) {
			l = node.left.data;
		}
		if (node.right != null) {
			r = node.right.data;
		}
		boolean lc = ChildrenSum(node.left);
		boolean rc = ChildrenSum(node.right);

		if (node.data == l + r && lc && rc) {
			return true;
		} else {
			return false;
		}

	}

	// 6. Check if a given Binary Tree is SumTree //MAKE IT MORE EFFICIENT
	public boolean isSumTree() {
		return isSumTree(root);
	}

	public boolean isSumTree(Node node) {
		if (node == null || isLeaf(node)) {
			return true;
		}
		int ls = sumAllNode(node.left);
		int rs = sumAllNode(node.right);

		boolean l = isSumTree(node.left);
		boolean r = isSumTree(node.right);
		if (node.data == ls + rs && l && r) {
			return true;
		} else {
			return false;
		}

	}

	// 2.Check sum of Covered and Uncovered nodes of Binary Tree
	public int UncoveredLeft(Node node) {
		if (isLeaf(node)) {
			return node.data;

		}
		if (node.left != null) {
			return node.data + UncoveredLeft(node.left);
		} else {
			return node.data + UncoveredLeft(node.right);
		}
	}

	public int UncoveredRight(Node node) {
		if (isLeaf(node)) {
			return node.data;

		}
		if (node.right != null) {
			return node.data + UncoveredLeft(node.right);
		} else {
			return node.data + UncoveredLeft(node.left);
		}
	}

	public int uncoverSum(Node t) {
		/*
		 * Initializing with 0 in case we don't have left or right boundary
		 */
		int lb = 0, rb = 0;

		if (t.left != null)
			lb = UncoveredLeft(t.left);
		if (t.right != null)
			rb = UncoveredRight(t.right);

		/*
		 * returning sum of root node, left boundry and right boundry
		 */
		return t.data + lb + rb;
	}

	public boolean chkIsSame() {
		int sum = sumAllNode(root);
		int uncoversum = uncoverSum(root);
		int coversum = sum - uncoversum;
		return coversum == uncoversum;

	}

	// 3.Check if two nodes are cousins in a Binary Tree
	// Two nodes are cousins of each other if they are at same level and have
	// different parents.

	// 4.Check if removing an edge can divide a Binary Tree in two halves

	// 5.Check if all leaves are at same level

	// 7.Check whether a given binary tree is perfect or not
	// A Binary tree is Perfect Binary Tree in which all internal nodes have two
	// children and all leaves are at same level.

	// 8.Given level order traversal of a Binary Tree, check if the Tree is a
	// Min-Heap
	// 9.Check if leaf traversal of two Binary Trees is same?

	// 10.Check if a given Binary Tree is SumTree
	// SAME AS QUESTION 2
	// 11.Check whether a given binary tree is perfect or not
	// A Binary tree is Perfect Binary Tree in which all internal nodes have two
	// children and all leaves are at same level.

	// 12.Check whether a binary tree is a full binary tree or not
	// A full binary tree is defined as a binary tree in which all nodes have
	// either zero or two child nodes.
	public boolean FullBinaryTree() {
		return FullBinaryTree(root);
	}

	public boolean FullBinaryTree(Node node) {
		if (node == null)
			return true;

		// if leaf node
		if (node.left == null && node.right == null)
			return true;
		if (node.left != null && node.right != null) {
			return true;

		}
		boolean l = FullBinaryTree(node.left);
		boolean r = FullBinaryTree(node.right);
		if (node.left != null && node.right != null) {
			return (l && r);
		} else {
			return false;
		}
	}

	// 13.Check whether a binary tree is a full binary tree or not | Iterative
	// Approach
	// 14.Check whether a given Binary Tree is Complete or not | Set 1
	// (Iterative Solution)

	// 15.Check if a given Binary Tree is height balanced like a Red-Black Tree
	// 16.Check if a binary tree is subtree of another binary tree | Set 2

	// 17.Check if a Binary Tree (not BST) has duplicate values
	public boolean checkDuplicates() {
		HashMap<Integer, Boolean> hm = new HashMap<>();
		return checkDuplicates(root, hm);
	}

	public boolean checkDuplicates(Node node, HashMap<Integer, Boolean> hm) {
		if (node == null) {
			return false;
		}
		if (hm.containsKey(node.data)) {
			return true;
		} else {
			hm.put(node.data, true);
		}
		boolean l = checkDuplicates(node.left, hm);
		boolean r = checkDuplicates(node.right, hm);

		if (l || r) {
			return true;
		} else {
			return false;
		}
	}
	// 20.Check if two trees are Mirror

	public boolean isMirror(Node node1, Node node2) {
		if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) {
			return false;
		}
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1.data == node2.data && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left)) {
			return true;
		} else {
			return false;
		}

	}
	// 21.Iterative method to check if two trees are mirror of each other
	// 22.Write Code to Determine if Two Trees are Identical

	public boolean isIdentical(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		boolean l = isIdentical(node1.left, node2.left);
		boolean r = isIdentical(node1.right, node2.right);
		if (node1.data == node2.data && l && r) {
			return true;
		} else {
			return false;
		}

	}

	public void leftView() {
		leftView(root, 1);
	}

	static int maxLevel;

	private void leftView(Node node, int lev) {
		if (node == null) {
			return;
		}
		if (maxLevel < lev) {
			System.out.println(node.data);
			maxLevel = lev;
		}
		leftView(node.left, lev + 1);
		leftView(node.right, lev + 1);

	}

	public void RightView() {
		RightView(root, 1);
	}

	private void RightView(Node node, int lev) {
		if (node == null) {
			return;
		}
		if (maxLevel < lev) {
			System.out.println(node.data);
			maxLevel = lev;
		}
		RightView(node.right, lev + 1);
		RightView(node.left, lev + 1);

	}

	// 30.Given a binary tree, print all root-to-leaf paths
	public void AllRootToLeafPaths() {

	}

	private void AllRootToLeafPaths(Node node, int sum) {

	}

	// 33.Print all nodes that are at distance k from a leaf node

	// 34.Print Levels of all nodes in a Binary Tree
	public void PrintLevels() {
		PrintLevels(root, 1);
	}

	private void PrintLevels(Node node, int lev) {
		if (node == null) {
			return;
		}
		System.out.println(node.data + "=>" + lev);
		PrintLevels(node.left, lev + 1);
		PrintLevels(node.right, lev + 1);
	}
	// 36.Print leftmost and rightmost nodes of a Binary Tree

	// TRAVERSALS
	// 16.Reverse Level Order Traversal

	public void ReverseOrder() {
		Queue<Node> q = new LinkedList<>();
		Stack<Node> s = new Stack<>();
		q.add(root);
		while (q.isEmpty() == false) {
			Node temp = q.remove();
			s.add(temp);
			if (temp.right != null) {
				q.add(temp.right);
			}
			if (temp.left != null) {
				q.add(temp.left);
			}
		}
		while (s.isEmpty() == false) {
			Node n = s.pop();
			System.out.println(n.data);
		}
	}

	// 17.reverse tree path
	// 18.Perfect Binary Tree Specific Level Order Traversal
	// 19.Perfect Binary Tree Specific Level Order Traversal | set 2
	// 20.Reverse alternate levels of a perfect binary tree
	// 21.Morris traversal for Preorder
	// 26.Diagonal Traversal of Binary Tree
	public void DiagonalTraversal(Node node, int d, HashMap<Integer, ArrayList<Integer>> hm) {
		if (node == null) {
			return;
		}
		if (hm.containsKey(node.data)) {

		}

		DiagonalTraversal(node.left, d + 1, hm);
		DiagonalTraversal(node.right, d, hm);
	}

	// Construction & Conversion
	// 1.
	// 28. Convert a Binary Tree into its Mirror Tree
	private Node InvertBinaryTree(Node node) {
		if (node == null) {
			return null;
		}
		Node left = InvertBinaryTree(node.left);
		Node right = InvertBinaryTree(node.right);

		node.left = left;
		node.right = right;
		return node;

	}

}
