package demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class DemoMainTest {

	@Test
	public void test_is_triangle_1() {
		assertTrue(DemoMain.isTriangle(2.5, 2.5, 3.8));
	}

	@Test
	public void test_is_triangle_2() {
		assertFalse(DemoMain.isTriangle(2.5, 2.5, 0));
	}

	@Test
	public void test_is_triangle_3() {
		assertTrue(DemoMain.isTriangle(4, 3, 2));
	}

	@Test
	public void test_is_triangle_4() {
		assertFalse(DemoMain.isTriangle(4, 3, 0));
	}

	@Test
	public void test_is_triangle_5() {
		assertTrue(DemoMain.isTriangle(4, 4, 4));
	}

	@Test
	public void test_is_triangle_6() {
		assertFalse(DemoMain.isTriangle(0, 0, 0));
	}

	@Test
	public void test_is_triangle_7() {
		assertTrue(DemoMain.isTriangle(28, 21, 35));
	}
	@Test
	public void test_is_triangle_8 () {
		assertFalse(DemoMain.isTriangle (-28, -21, -35));
	}

	@Test
	public void test_main_program1() {
		String input = "5\n12\n13\n";
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		String[] args = {};
		DemoMain.main(args);

		String consoleOutput = "Enter side 1: " + System.lineSeparator();
		consoleOutput += "Enter side 2: " + System.lineSeparator();
		consoleOutput += "Enter side 3: " + System.lineSeparator();
		consoleOutput += "This is a triangle." + System.lineSeparator();

		assertEquals(consoleOutput, out.toString());
	}

	@Test
	public void test_main_program2() {
		String input = "0\n12\n13\n";
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		String[] args = {};
		DemoMain.main(args);

		String consoleOutput = "Enter side 1: " + System.lineSeparator();
		consoleOutput += "Enter side 2: " + System.lineSeparator();
		consoleOutput += "Enter side 3: " + System.lineSeparator();
		consoleOutput += "This is not a triangle." + System.lineSeparator();

		assertEquals(consoleOutput, out.toString());
	}

}
