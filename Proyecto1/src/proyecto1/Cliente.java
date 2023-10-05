/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import javax.swing.JOptionPane;

/**
 *
 * @author indir
 */
public class Cliente {
     private String nombre, correo;
     private int  edad,id,numTelefono;
     
    

      //constructor      
    public Cliente(String nombre,  int edad,int id,  int numTelefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
         0correo="";
         this.numTelefono;
            
    }

    //Encapsuladores 
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

   public String getCorreo(){
        if(correo.equals("")){
            return "Error: correo no ingresado";
        }
        
        return correo.substring(0, 3)+"....."+
                correo.substring(correo.indexOf("@"));
    }
    
    public void setCorreo(String pCorreo){
        if(pCorreo.contains("@")){
          
            if(pCorreo.substring(pCorreo.indexOf("@"))
                    .equals("@gmail.com")){
                correo=pCorreo;
            }else{
                System.out.println("Error: correo no valido"+
                        " debe ser una cuenta gmail");
            }
        }else{
            System.out.println("Error: correo no valido"+
                " debe contener @");
        }
    }

   public void CrearCliente(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre : ");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad  :"));
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de identificacion :"));
            //si me deja xd
   }
    
}
