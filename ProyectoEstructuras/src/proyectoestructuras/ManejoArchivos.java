/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;
 import java.io.*;

/**
 *
 * @author indir
 */
public class ManejoArchivos {
   

public class manejoArchivos {
    public static void crearArchivo(String nombreArchivo){
        File archivo= new File(nombreArchivo);
         
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            //System.out.println("Se creo archivo");
        } catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }
    
     public static void escribirArchivo(String nombreArchivo, String contenido){
        File archivo= new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();
            //System.out.println("Se escribio informacion en archivo");
        } catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }
     
     
     ///actualizar
     
     
    
     
    public static void archivarTiquete(String nombreArchivo, String contenido){
        File archivo= new File(nombreArchivo);
        
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();
            //System.out.println("Se escribio informacion en archivo");
        } catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);     
        }
    }
    
}

}
