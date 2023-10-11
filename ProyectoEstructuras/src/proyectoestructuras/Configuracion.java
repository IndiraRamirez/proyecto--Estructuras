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
    
    
    
  
    
    public String toString() {
        return """
               Bienvenidos a
               """ +"                            ¡"+nombre+"!"+"\n"+
                "Nos encontramos en "+direccion+"\n"+
                "Para más informacion contactanos "+"numero de telefono "+telefono+"\n";
    }
}

//ConfiguracionEmpresa.mostrarInformacionEmpresa();
   

