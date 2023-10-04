/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author indir
 */
public class Cliente {
     private String nombre;
     private int  edad,id;
     
    

      //constructor      
    public Cliente(String nombre,  int edad,int id) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
            
    }

    //Encapsuladores 
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

   public void CrearCliente(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre : ");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad  :"));
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de identificacion :"));
            
   }
    
}
