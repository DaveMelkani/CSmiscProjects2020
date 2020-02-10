public class QueQue<T> {
	private Stack<T> data1;
	private Stack<T> data2;
	private int size;

	public QueQue() {
		data1 = new Stack<T>();
		data2 = new Stack<T>();
	}

	public void add(T t) {
		// for (int i = 0; i < data2.size(); i++) {
		// data1.push(data2.pop());
		// }
		int i = 0;
		while (i < data2.size()) {
			data1.push(data2.pop());
		}
		data1.push(t);
		size++;
	}

	public T remove() {
		int i = 0;
		while(i < data1.size()) {
			data2.push(data1.pop());
		}
		if(size == 0) {
			return null;
		}
		size--;
		return data2.pop();
	}

	/*
	 * [1,2,3] [3,2,1] 1
	 */
	public T peek() {
		int temp = data2.size();
		for (int i = 0; i < temp; i++) {
			data1.push(data2.pop());
		}
		temp = data1.size();
		for (int i = 0; i < temp; i++) {
			data2.push(data1.pop());

		}
		return data2.peek();
	}


	public int size() {
		for (int i = 0; i < data2.size(); i++) {
			data1.push(data2.pop());
		}
		return size;
	}

	public String toString() {
		return data1.toString();
	}
}
