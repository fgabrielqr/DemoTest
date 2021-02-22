package demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
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
		assertEquals("false", DemoMain.isTriangle(1, 5, 3));
	}

	@Test
	public void test_main_program1() {
		ByteArrayInputStream in = new ByteArrayInputStream("5\n6\n9\n".getBytes());
		System.setIn(in);
		
		
		String[] args = {};
		DemoMain.main(args);
		String output = baOut.toString();

		String consoleOutput = "Enter side 1: " + System.lineSeparator();
		consoleOutput += "Enter side 2: " + System.lineSeparator();
		consoleOutput += "Enter side 3: " + System.lineSeparator();
		consoleOutput += "This is a triangle." + System.lineSeparator();

		assertEquals(consoleOutput, output);
	}
	
	@Test
	public void test_main_program2() {
		ByteArrayInputStream in = new ByteArrayInputStream("4\n4\n12\n".getBytes());
		System.setIn(in);
		
		String[] args = {};
		DemoMain.main(args);
		String output = baOut.toString();

		String consoleOutput = "Enter side 1: " + System.lineSeparator();
		consoleOutput += "Enter side 2: " + System.lineSeparator();
		consoleOutput += "Enter side 3: " + System.lineSeparator();
		consoleOutput += "This is not a triangle." + System.lineSeparator();

		assertEquals(consoleOutput, output);
	}

}
