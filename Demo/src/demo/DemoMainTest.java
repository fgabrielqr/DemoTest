package demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class DemoMainTest {
	
	static private ByteArrayOutputStream baOut;
	static private PrintStream psOut;
	
	@BeforeClass
	public static void beforeClassInit() {
		baOut = new ByteArrayOutputStream();
		psOut = new PrintStream(baOut);
		System.setOut(psOut);
	}
	
	@AfterClass
	public static void afterClassFinalize() {
		psOut.close();
	}
	
	@Before
	public void setUp() {
		baOut.reset();
	}

	@Test
	public void test_is_triangle_1() {
		assertEquals("true", DemoMain.isTriangle(10.0, 14.0, 8.0));
	}

	@Test
	public void test_is_triangle_2() {
		assertEquals("true", DemoMain.isTriangle(1, 5, 3));
	}
	
	@Test
	public void testMain_1() {
		DemoMain.main(new String [] {""});
		String output = baOut.toString();
		
		assertEquals("This is a triangle.", output);
	}

	@Test
	public void testMain_2() {
		DemoMain.main(new String [] {""});
		String output = baOut.toString();
		
		assertEquals("This is not a triangle.", output);
	}
}
