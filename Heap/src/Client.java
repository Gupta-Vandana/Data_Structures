import java.util.PriorityQueue;

public class Client {

	public static void main(String[] args) {
		int[] arr = { 100, 200, 500, 300, 150, 10, 250 };
		Heap rnklst = new Heap(true, arr);

		rnklst.display();

		while (rnklst.size() != 0) {
			System.out.println(rnklst.removeHP());
		}

	}

}
// import java.util.Comparator;
//
// public class MyComparator implements Comparator<Integer>
// {
// public int compare( Integer x, Integer y )
// {
// return y - x;
// }
// }
// PriorityQueue minHeap=new PriorityQueue();
// PriorityQueue maxHeap=new PriorityQueue(size, new MyComparator());