package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

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
    public void testOneSwapNeeded() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(2, 1, 3, 4));
        assertEquals(1,App.minAmountOfSwapsToSort(array));
    }
    public void testTwoSwapNeeded() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(2, 1, 4, 3));
        assertEquals(2,App.minAmountOfSwapsToSort(array));
    }

    public void testSorted() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(0,App.minAmountOfSwapsToSort(array));
    }

    public void testEmptyArray() {
      ArrayList<Integer> array = new ArrayList<>();
      assertEquals(0,App.minAmountOfSwapsToSort(array));
    }

    public void testNull() {
      assertEquals(0,App.minAmountOfSwapsToSort(null));
    }

}
