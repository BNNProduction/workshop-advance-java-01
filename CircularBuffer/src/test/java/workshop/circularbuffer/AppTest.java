package workshop.circularbuffer;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AppTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
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
		exceptionRule.expect(Exception.class);
		exceptionRule.expectMessage("Buffer Overflow");
		c.write("OVERFLOW");
	}

}
