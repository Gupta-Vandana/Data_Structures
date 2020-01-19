
public class Stack<T> {
	T[] data;
	int top = -1;

	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		this.data = (T[]) new Object[capacity];
	}

	public void Push(T val) {
		if (this.top == this.data.length - 1) {
			System.out.println("Stack is full");
		}
		top++;
		this.data[top] = val;

	}

	public T Pop() {
		if (top == -1) {
			System.out.println("Underflow error");
			return null;
		} else {
			T element = data[top];
			top--;
			return element;
		}
	}

	public void display() {
		for (int i = top; i >= 0; i--) {
			System.out.println(this.data[i]);
		}
	}

	public T top() throws Exception {
		if (this.isempty()) {
			System.out.println("stack is empty");
		}
		T rv = this.data[top];
		return rv;
	}

	public boolean isempty() {
		return this.size() == 0;

	}

	public int size() {
		return this.top + 1;

	}

}
