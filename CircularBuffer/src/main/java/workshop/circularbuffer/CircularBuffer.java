package workshop.circularbuffer;

public class CircularBuffer<E> {
	public CircularBuffer() {
		super();
		create();
	}

	public CircularBuffer(int size) {
		super();
		create(size);
	}

	private int size;
	private int writerPointer = -1;
	private int readPointer = 0;
	private E[] data;

	private void create() {
		this.size = 10;
		this.data = (E[]) new Object[10];
	}

	public void create(int size) {
		this.size = size;
		this.data = (E[]) new Object[size];
	}

	public void write(E input) throws Exception {
		if (!isFull()) {
			int next = writerPointer + 1;
			data[next % size] = input;
			writerPointer++;
		}else {
			throw new Exception("Buffer Overflow");
		}
	}

	public E read() throws Exception {
		if (readPointer >= writerPointer) {
			E val = data[readPointer % size];
			readPointer++;
			return val;
		}
		return null;
	}

	public int getSize() {

		return this.size;
	}

	public boolean isEmpty() {

		return this.size == 0;
	}

	public boolean isFull() {

		if ((writerPointer - readPointer) + 1 == size) {
			return true;
		}
		return false;
	}
}
