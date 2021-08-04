//A unit test is a piece of code written by a developer that executes a specific functionality in the code to 
//be tested.
import static org.junit.Assert.*;
import org.junit.Test;
public class CalculatorTest 
{
	Calculator cal=new Calculator();
	@Test  //Used to identify that a method is a test method

	public void testSquares()
	{
		
		assertEquals(25,cal.square(5));
		assertEquals(5*5,cal.square(5));
		
	}
	
	@Test
	public void testUser()
	{
		assertEquals("sandip",cal.user("sandip"));
	}
	
	@Test
	public void stringtest1()
	{
	String result = cal.concat("Hello", "World");
	assertEquals("HelloWorld", result);
	String s1="Hello";
	String s2="Hello";
	assertSame(s1,s2); 
	}
	
	
}