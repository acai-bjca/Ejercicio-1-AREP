/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep;

import static junit.framework.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Amalia
 */
public class LinkedListTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LinkedListTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LinkedListTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void testDeberiaAgregarNodos()
    {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(15.2);
        linkedList.addNode(11.3);
        linkedList.addNode(1);
        linkedList.addNode(0);
        linkedList.addNode(32.2);
        String rtaGenerada = linkedList.showLinkedList();
        String rtaEsperada = "[15.2]->[11.3]->[1.0]->[0.0]->[32.2]";
        assertTrue(rtaGenerada.equals(rtaEsperada));
    }
    
    public void testDeberiaDarElTamañoCorrecto()
    {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(15.2);
        linkedList.addNode(11.3);
        linkedList.addNode(1);
        linkedList.addNode(0);
        linkedList.addNode(32.2);
        int rtaGenerada = linkedList.getLength();
        int rtaEsperada = 5;
        assertEquals(rtaEsperada, rtaGenerada);
    }
    
    public void testDeberiaEliminarNodoCorrectamente()
    {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(15.2);
        linkedList.addNode(11.3);
        linkedList.addNode(963.2);
        linkedList.addNode(111.44);
        linkedList.addNode(32.2);
        
        Double dateToDelete = 111.44;
        linkedList.deleteNode(dateToDelete);
        String rtaGenerada = linkedList.showLinkedList();
        String rtaEsperada = "[15.2]->[11.3]->[963.2]->[32.2]";
        assertEquals(rtaEsperada, rtaGenerada);
        
        Double dateToDelet2 =  32.2;
        linkedList.deleteNode(dateToDelet2);
        rtaGenerada = linkedList.showLinkedList();
        rtaEsperada = "[15.2]->[11.3]->[963.2]";
        assertEquals(rtaEsperada, rtaGenerada);
        
        Double dateToDelet3 = 52.120;
        linkedList.deleteNode(dateToDelet3);
        rtaGenerada = linkedList.showLinkedList();
        rtaEsperada = "[15.2]->[11.3]->[963.2]";
        assertEquals(rtaEsperada, rtaGenerada);
    } 
}
