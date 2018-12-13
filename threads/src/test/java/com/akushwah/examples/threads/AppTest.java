package com.akushwah.examples.threads;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        
        try {
        	throw new Error("Hi Error");
//        	int i = 1/0;
        }catch (ArithmeticException e) {
        	System.out.println("2");
        }catch (Exception e) {
			System.out.println("3");
		}catch (Error e) {
			System.out.println("5");
		}finally {
			System.out.println("4");
		}
    }
}
