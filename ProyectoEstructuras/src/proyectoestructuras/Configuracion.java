/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

/**
 
 * @author Jeffe
 */
public class Configuracion {
    public static String nombre = "AzzaCar";
    public static String telefono = "8888-8888";
    public static String direccion = " Cartago, Occidental";

    
    public static String info(){
        return nombre+"\n"+telefono+"\n"+direccion;
    }
    
    
    
        //System.out.println("Nombre: " + nombre);
        //System.out.println("Teléfono: " + telefono);
        //System.out.println("Dirección: " + direccion);
    
    public String toString() {
        return """
               Empresa
               """ +nombre+"\n"+
                "Nos encontramos en "+direccion+"\n"+
                "Para más informacion contactanos "+"numero de telefono"+telefono+"\n";
    }
}

//ConfiguracionEmpresa.mostrarInformacionEmpresa();
   

