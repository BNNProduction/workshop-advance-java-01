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
	private static final int DEFAULT_SIZE = 10;
	private int size;
	private int writerPointer = -1;
	private int readPointer = 0;
	private E[] data;

	private void create() {
		this.size = DEFAULT_SIZE;
		this.data = (E[]) new Object[DEFAULT_SIZE];
	}

	public void create(int size) {
		this.size = size;
		this.data = (E[]) new Object[size];
	}

	public void write(E input) throws Exception {
		if (!isFull()) {
			
			data[(++writerPointer) % size] = input;
		}else {
			throw new Exception("Buffer Overflow");
		}
	}

	public E read() throws Exception {
		if (readPointer <= writerPointer) {
			E val = data[(readPointer++) % size];
			return val;
		}else {
			throw new Exception("Read Overflow");
		}
	}

	public int getSize() {

		return data.length;
	}

	public boolean isEmpty() {

		return readPointer - writerPointer == 0;
	}

	public boolean isFull() {

		if ((writerPointer - readPointer) + 1 == size) {
			return true;
		}
		return false;
	}
}
