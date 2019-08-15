/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep;
import java.io.*;
/**
 *
 * @author Amalia
 */
public class Ejercicio {
    /**
     * readData Lee los datos de un archivo y crea una LinkedList con
     * los mismos.
     * @param url Dirección en la que se encuentra el archivo a ser leído
     * @throws FileNotFoundException Indica que hubo un error al encontrar le archivo
     * @throws IOException Indica qu hubo u nerror de E/S 
     * @return linkedList Con los datos leídos del archivo
     */
    public static LinkedList readData(String url) throws FileNotFoundException, IOException{
        double date;
        LinkedList linkedList;
        File archivo = new File (url);
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        linkedList = new LinkedList();
        while (linea!=null){
            date = Double.parseDouble(linea);
            linkedList.addNode(date);
            linea = br.readLine();
        }
        return linkedList;
        //System.out.println(linkedList.showLinkedList());
    }
    
    /**
     * calculateMean Calcula la media de los datos almacenados en la linkedList dada.
     * @param linkedList Lista enlazada a la que se le encontrará la media
     * @return Media de los datos de la linkedList
     */
    public static double calculateMean(LinkedList linkedList){
        double mean;
        double suma = 0.0;
        Node item = linkedList.getHead();
        while (item.getNext()!= null){            
            suma += item.getValue();
            item = item.getNext();
        }
        suma += item.getValue();        
        int length = linkedList.getLength();
        mean = suma/length;
        //System.out.println(">>>>>La Media es: "+mean);
        return mean;
    }
    
    /**
     * calculateStandardDeviation Calcula la desviación estándar de los datos almacenados en la linkedList dada.
     * @param linkedList Lista enlazada a la que se le encontrará la desviación estándar
     * @return Desviación estándar de los datos de la linkedList
     */
    public static double calculateStandardDeviation(LinkedList linkedList){
        double standardDeviation;
        double mean = calculateMean(linkedList);
        double suma = 0.0;
        Node item = linkedList.getHead();     
        while (item.getNext()!= null){
            suma += Math.pow(Math.abs(item.getValue() - mean), 2);
            item = item.getNext();
        }
        suma += Math.pow(Math.abs(item.getValue() - mean), 2);
        int length = linkedList.getLength();
        standardDeviation = Math.sqrt(suma/(length-1));        
        //System.out.println(">>>>>La Desviacion estándar es: "+standardDeviation);
        return standardDeviation;
    }
    
    
    public static void main (String [ ] args) throws IOException {
        String url = "src/main/resources/datos.txt";
        LinkedList linkedList = readData(url);
        System.out.print("Empezamos la ejecución del programa");
        Double mean = calculateMean(linkedList);
        System.out.println("La media es: "+ String.format("%.2f", mean));
        Double standardDeviation = calculateStandardDeviation(linkedList);
        System.out.println("La desviación estándar es: "+ String.format("%.2f", standardDeviation));
    }
}
