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
    public void testRangesEqual() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(2, 1, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 1, 3, 4));
        int index1 = 1; int index2 = 3;
        assertTrue(App.isSumOfRangeEqual(array1, array2, index1, index2));
    }
    public void testRangesNotEqual() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(2, 1, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 1, 3, 4));
        int index1 = 0; int index2 = 3;
        assertFalse(App.isSumOfRangeEqual(array1, array2, index1, index2));
    }

    public void testSorted() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(2, 1, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 1, 3, 4));
        int index1 = 0; int index2 = 3;
        assertFalse(App.isSumOfRangeEqual(array1, array2, index1, index2));
    }

    public void testEmptyArray() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(2, 1, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 1, 3, 4));
        int index1 = 0; int index2 = 3;
        assertFalse(App.isSumOfRangeEqual(array1, array2, index1, index2));
    }

}
