package workshop.circularbuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AppTest {

	@Test
	public void caseCreateCircularbuffer_ByDefaultSize() {
		CircularBuffer<String> c = new CircularBuffer<String>();
		assertEquals(10, c.getSize());
	}

	@Test
	public void caseCreateCircularbuffer_ByInitialSize() {
		CircularBuffer<String> c = new CircularBuffer<String>(30);
		assertEquals(30, c.getSize());
	}

	@Test
	public void caseTest_ReadAndWrite() throws Exception {
		CircularBuffer<String> c = new CircularBuffer<String>();
		assertEquals(10, c.getSize());
		c.write("BOBOOBUA");
		assertEquals("BOBOOBUA", c.read());
	}

	@Test
	public void caseTest_WriteOverflow() throws Exception {
		CircularBuffer<String> c = new CircularBuffer<String>(1);
		assertEquals(1, c.getSize());
		c.write("BOBOOBUA1");
		assertThrows(Exception.class, () -> {
			c.write("OverFlow");
		});
	}

	@Test
	public void caseTest_ReadOverflow() throws Exception {
		final CircularBuffer<String> c = new CircularBuffer<String>(1);
		assertEquals(1, c.getSize());
		c.write("BOBOOBUA1");
		assertThrows(Exception.class, () -> {
			System.out.println(c.read());
			System.out.println(c.read());
			System.out.println(c.read());
		});

	}

}
