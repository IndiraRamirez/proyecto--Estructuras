/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;
 import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author indir
 */
public class ManejoArchivos {
   
    private final String nombreARmaster= "LoginMaestro.txt";
    private final String nombreARempleado= "LoginEmpleado.txt";
    private final File ARmaster = new File(nombreARmaster);
    private final File ARempleado = new File(nombreARempleado);
    
    public int ComprobarAR(){
        if(ARmaster.exists() || ARempleado.exists()){
            return 1;
        }else{
            try{
                ARmaster.createNewFile();
                ARempleado.createNewFile();
                return 2;
            }catch(IOException e){
            System.out.println("Hubo un error creando el archivo.\nError: "+e.getMessage());
            return 3;}
        }
    }
    
    public boolean ComprobarMASTER(String nombre, String contra) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(ARmaster));
        String linea;
        String comprobarNB = "Nombre:"+nombre;
        String comprobarCT = "Contrasenna:"+contra;
        while((linea = br.readLine())!=null) {
            if(linea.equals(comprobarNB)){
                linea = br.readLine();
                if(linea.equals(comprobarCT)){
                    br.close();
                    return true;
                }}
        }
        br.close();
        return false;
    }

    public boolean ComprobarEMPLEADO(String nombre, String contra) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(ARempleado));
        String linea;
        String comprobarNB = "Nombre:"+nombre;
        String comprobarCT = "Contrasenna:"+contra;
        while((linea = br.readLine())!=null) {
            if(linea.equals(comprobarNB)){
                linea = br.readLine();
                if(linea.equals(comprobarCT)){
                    br.close();
                    return true;
                }}}
        br.close();
        return false;
    }
    
    public void AgregarUM(String nombre, String contra) throws IOException{
        String datosArchivo = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(ARmaster));
            String linea;
            while ((linea = br.readLine())!= null) {
                datosArchivo+=linea;
                datosArchivo+="\n";
            }
        }catch(IOException e) {System.out.println("Error al leer el archivo: " + e.getMessage());}
        
        String datosClienteNuevo = "Nombre:" + nombre +"\nContrasenna:"+ contra + "\n\n";
        datosArchivo+=datosClienteNuevo;
        try{
            BufferedWriter escribir = new BufferedWriter(new FileWriter(ARmaster));
            escribir.write(datosArchivo);
            JOptionPane.showMessageDialog(null, "Usuario agregado!");
            escribir.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo: " + e.getMessage());
        }}
    
    public void AgregarUE(String nombre, String contra) throws IOException{
        String datosArchivo = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(ARempleado));
            String linea;
            while ((linea = br.readLine())!= null) {
                datosArchivo+=linea;
                datosArchivo+="\n";
            }
        }catch(IOException e) {System.out.println("Error al leer el archivo: " + e.getMessage());}
        
        String datosClienteNuevo = "Nombre:" + nombre +"\nContrasenna:"+ contra + "\n\n";
        datosArchivo+=datosClienteNuevo;
        try{
            BufferedWriter escribir = new BufferedWriter(new FileWriter(ARempleado));
            escribir.write(datosArchivo);
            JOptionPane.showMessageDialog(null, "Usuario agregado!");
            escribir.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo: " + e.getMessage());
        }}
        
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
     
     
    
     
    public static void archivar(String nombreArchivo, String contenido){    /// en este escribio debajo de lo que ya estaba
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
 

