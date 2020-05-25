
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(8);
		bst.add(10);
		bst.add(3);
		bst.add(6);
		bst.add(1);
		bst.add(4);
		bst.add(7);
		bst.add(14);
		bst.add(13);
		bst.display();
		// System.out.println(bst.height());
		// System.out.println(bst.find(60));
		// System.out.println(bst.Minimum());
		// System.out.println(bst.Maximum());
		// bst.levelOrder();
		//System.out.println(bst.LCA(1, 14));
		bst.InOrder();
		
	}

}
