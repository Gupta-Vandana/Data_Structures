
// Enqueue->Rear-> ||||||||||||| <-front<-Dequeue
//  last item/insertion          FIFO        first   item /deleteion                    
public class Queue {

	int front, rear, size;

	int data[];

	public Queue(int cap) {

		front = this.size = 0;
		rear = cap - 1;
		data = new int[cap];

	}

	// Queue is full when size becomes equal to
	// the capacity
	boolean isFull(Queue queue) {
		return (this.size == this.data.length);
	}

	// Queue is empty when size is 0
	boolean isEmpty(Queue queue) {
		return (this.size == 0);
	}

	// Method to add an item to the queue.
	// It changes rear and size
	void Enqueue(int item) {
		if (isFull(this)) {
			System.out.println("Queue is full");
			return;
		}
		this.rear = (this.rear + 1) % this.data.length;
		this.data[this.rear] = item;
		this.size = this.size + 1;
		System.out.println(item + " enqueued to queue");
	}

	// Method to remove an item from queue.
	// It changes front and size
	int Dequeue() {
		if (isEmpty(this)) {
			System.out.println("queue is empty");

			return Integer.MIN_VALUE;
		}

		int item = this.data[this.front];
		this.front = (this.front + 1) % this.data.length;
		this.size = this.size - 1;
		return item;
	}

	// Method to get front of queue
	int front() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		return this.data[this.front];
	}

	// Method to get rear of queue
	int rear() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		return this.data[this.rear];
	}

	public void display() {
		System.out.println("-------------------");

		for (int i = 0; i < this.size; i++) {
			System.out.print(this.data[(front + i) % this.data.length]);
		}
		System.out.println(".");
		System.out.println("-------------------");
	}

}
