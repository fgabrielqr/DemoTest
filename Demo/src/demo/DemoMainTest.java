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
		assertTrue(DemoMain.isTriangle(3, 4, 5));
	}

	@Test
	public void test_is_triangle_2() {
		assertTrue(DemoMain.isTriangle(5, 12, 13));
	}

	@Test
	public void test_is_triangle_3() {
		assertTrue(DemoMain.isTriangle(5, 13, 12));
	}

	@Test
	public void test_is_triangle_4() {
		assertTrue(DemoMain.isTriangle(12, 5, 13));
	}

	@Test
	public void test_is_triangle_5() {
		assertTrue(DemoMain.isTriangle(12, 13, 5));
	}

	@Test
	public void test_is_triangle_6() {
		assertTrue(DemoMain.isTriangle(0.2, 0.2, 0.2));
	}

	@Test
	public void test_is_NOT_triangle_1() {
		assertFalse(DemoMain.isTriangle(5, 7, 13));
	}
	@Test
	public void test_is_NOT_triangle_2 () {
		assertFalse(DemoMain.isTriangle (5, 13, 7));
	}

	@Test
	public void test_main_program1() {
		ByteArrayInputStream in = new ByteArrayInputStream("10\n14\n8\n".getBytes());
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
		ByteArrayInputStream in = new ByteArrayInputStream("1\n5\n3\n".getBytes());
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
