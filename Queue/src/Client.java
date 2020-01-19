
public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue q = new Queue(5);
		q.Enqueue(0);
		q.Enqueue(1);
		q.Enqueue(2);
		q.Enqueue(3);
		q.Enqueue(4);
		q.Enqueue(5);
		int r = q.Dequeue();
		q.Enqueue(6);
		q.display();

	}

}
