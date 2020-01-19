
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		int []arr={5, 2, 6, 1, 3};
//		bst.add(8);
//		bst.add(10);
//		bst.add(3);
//		bst.add(6);
//		bst.add(1);
//		bst.add(4);
//		bst.add(7);
//		bst.add(14);
//		bst.add(13);
//		bst.display();
//		System.out.println(bst.find(60));
//		System.out.println(bst.find(70));
//		System.out.println(bst.Minimum());
//		System.out.println(bst.LCA(10, 14));
//		System.out.println(bst.LCA(14, 8));
//		System.out.println(bst.LCA(10, 22));
//		System.out.println(bst.height());
//		System.out.println(bst.isBST());
//		System.out.println(bst.Maximum());
//		System.out.println(bst.Minimum());
//		System.out.println(bst.kthlargest(2));
//		System.out.println(bst.SubSeqExist(arr));
		bst.sort(arr, 0, arr.length-1);

	}

}
