package edu.escuelaing.arep;

import static edu.escuelaing.arep.Ejercicio.calculateMean;
import static edu.escuelaing.arep.Ejercicio.calculateStandardDeviation;
import java.io.IOException;
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
    
    public void testDeberiaCaluclarLaMediaCorrectamente()
    {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(160);
        linkedList.addNode(591);
        linkedList.addNode(114);
        linkedList.addNode(229);
        linkedList.addNode(230);
        linkedList.addNode(270);
        linkedList.addNode(128);
        linkedList.addNode(1657);
        linkedList.addNode(624);
        linkedList.addNode(1503);
        Double expectedMean = 550.6 ;
        
        Ejercicio ejercicio = new Ejercicio();
        Double generateMean= ejercicio.calculateMean(linkedList);
        assertEquals(expectedMean, generateMean, 10);
        
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addNode(15.0);
        linkedList2.addNode(69.9);
        linkedList2.addNode(6.5);
        linkedList2.addNode(22.4);
        linkedList2.addNode(28.4);
        linkedList2.addNode(65.9);
        linkedList2.addNode(19.4);
        linkedList2.addNode(198.7);
        linkedList2.addNode(38.8);
        linkedList2.addNode(138.2);
        expectedMean = 60.32;
        generateMean = ejercicio.calculateMean(linkedList2);
        assertEquals(expectedMean, generateMean, 10);
        
        LinkedList linkedList3 = new LinkedList();
        linkedList3.addNode(8.3);
        linkedList3.addNode(591);
        linkedList3.addNode(3691);
        linkedList3.addNode(0);
        linkedList3.addNode(33210);
        linkedList3.addNode(5);
        linkedList3.addNode(11111);
        linkedList3.addNode(91.0001);
        linkedList3.addNode(999);
        linkedList3.addNode(69.28);
        linkedList3.addNode(647);
        linkedList3.addNode(222.65);
        linkedList3.addNode(3697);
        
        expectedMean = 4180.17155;
        generateMean = ejercicio.calculateMean(linkedList3);
        assertEquals(expectedMean, generateMean, 10);
        
        LinkedList linkedList4 = new LinkedList();
        linkedList4.addNode(9324853.012);
        linkedList4.addNode(366.032);
        linkedList4.addNode(122.055);
        linkedList4.addNode(545678412.25);
        linkedList4.addNode(2545.2);
        linkedList4.addNode(111.001);
        linkedList4.addNode(0);        
        
        expectedMean = 79286629.9;
        generateMean = ejercicio.calculateMean(linkedList4);
        assertEquals(expectedMean, generateMean, 10);
    }
    
    public void testDeberiaCaluclarLaDesviacionEstandarCorrectamente()
    {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(160);
        linkedList.addNode(591);
        linkedList.addNode(114);
        linkedList.addNode(229);
        linkedList.addNode(230);
        linkedList.addNode(270);
        linkedList.addNode(128);
        linkedList.addNode(1657);
        linkedList.addNode(624);
        linkedList.addNode(1503);
        
        Double expectedStandardDeviation = 572.03 ;        
        Ejercicio ejercicio = new Ejercicio();
        Double generateStandardDeviation = ejercicio.calculateStandardDeviation(linkedList);
        assertEquals(expectedStandardDeviation, generateStandardDeviation, 10);
        
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addNode(15.0);
        linkedList2.addNode(69.9);
        linkedList2.addNode(6.5);
        linkedList2.addNode(22.4);
        linkedList2.addNode(28.4);
        linkedList2.addNode(65.9);
        linkedList2.addNode(19.4);
        linkedList2.addNode(198.7);
        linkedList2.addNode(38.8);
        linkedList2.addNode(138.2);
        
        expectedStandardDeviation = 62.26;
        generateStandardDeviation = ejercicio.calculateStandardDeviation(linkedList2);
        assertEquals(expectedStandardDeviation, generateStandardDeviation, 10);
        
        LinkedList linkedList3 = new LinkedList();
        linkedList3.addNode(8.3);
        linkedList3.addNode(591.0);
        linkedList3.addNode(3691.0);
        linkedList3.addNode(0.0);
        linkedList3.addNode(33210.0);
        linkedList3.addNode(5.0);
        linkedList3.addNode(11111.0);
        linkedList3.addNode(91.0001);
        linkedList3.addNode(999.0);
        linkedList3.addNode(69.28);
        linkedList3.addNode(647.0);
        linkedList3.addNode(222.65);
        linkedList3.addNode(3697.0);
        
        expectedStandardDeviation = 9257.062644;
        generateStandardDeviation = ejercicio.calculateStandardDeviation(linkedList3);
        assertEquals(expectedStandardDeviation, generateStandardDeviation, 10);
        
        LinkedList linkedList4 = new LinkedList();
        linkedList4.addNode(9324853.012);
        linkedList4.addNode(366.032);
        linkedList4.addNode(122.055);
        linkedList4.addNode(545678412.25);
        linkedList4.addNode(2545.2);
        linkedList4.addNode(111.001);
        linkedList4.addNode(0);        
        
        expectedStandardDeviation = 205688800.0;
        generateStandardDeviation = ejercicio.calculateStandardDeviation(linkedList4);
        assertEquals(expectedStandardDeviation, generateStandardDeviation, 10);
    }
    
    public void testDeberiaLeerLosArchivosYGenerarRespuestasCorrectas() throws IOException
    {
        String url = "src/main/resources/datos.txt";       
        Ejercicio ejercicio = new Ejercicio();
        LinkedList linkedList = ejercicio.readData(url);
        Double expectedMean = 550.6 ;
        Double expectedStandardDeviation = 572.03 ;
        Double mean = calculateMean(linkedList);
        assertEquals(expectedMean, mean, 10);
        
        Double generateStandardDeviation = ejercicio.calculateStandardDeviation(linkedList);
        assertEquals(expectedStandardDeviation, generateStandardDeviation, 10);
        
        url = "src/main/resources/datos2.txt";
        linkedList = ejercicio.readData(url);
        expectedMean = 60.32;
        expectedStandardDeviation = 62.26;
        mean = calculateMean(linkedList);
        assertEquals(expectedMean, mean, 10);
        
        generateStandardDeviation = ejercicio.calculateStandardDeviation(linkedList);
        assertEquals(expectedStandardDeviation, generateStandardDeviation, 10);
        
        url = "src/main/resources/datos3.txt";
        linkedList = ejercicio.readData(url);
        expectedMean = 4180.17155;
        expectedStandardDeviation = 9257.062644;
        mean = calculateMean(linkedList);
        assertEquals(expectedMean, mean, 10);
        
        generateStandardDeviation = ejercicio.calculateStandardDeviation(linkedList);
        assertEquals(expectedStandardDeviation, generateStandardDeviation, 10);
        
        url = "src/main/resources/datos4.txt";
        linkedList = ejercicio.readData(url);
        expectedMean = 79286629.9;
        expectedStandardDeviation = 205688800.0;
        mean = calculateMean(linkedList);
        assertEquals(expectedMean, mean, 10);
        
        generateStandardDeviation = ejercicio.calculateStandardDeviation(linkedList);
        assertEquals(expectedStandardDeviation, generateStandardDeviation, 10);
    }
}
