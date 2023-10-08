/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author indir
 */
public class Cliente {
    
     public String nombre,correo;
     public int  edad,id, numeroTel;

    public Cliente(String nombre, int edad, int id, int numeroTel, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.id = id;
        this.numeroTel = numeroTel;
    }

    Cliente() {
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

    public int getNumeroTel() {
        return numeroTel;}
    public void setNumeroTel(int numeroTel) {
        this.numeroTel = numeroTel;}
    
    

   public String getCorreo(){
        if(correo.equals("")){
            return "Error: correo no ingresado";
        }
        
        return correo.substring(0, 3)+"....."+
                correo.substring(correo.indexOf("@"));
    }
    
    public void setCorreo(String correo){{this.correo = correo;}  
    }
    public String correoDado(){
        String correoDado;
        do{   
        correoDado=JOptionPane.showInputDialog("Ingrese su correo: ");
            if(correoDado.contains("@")){
                if(correoDado.substring(correoDado.indexOf("@"))
                        .equals("@gmail.com")){
                    this.correo=correoDado;
                if(correoDado.substring(correoDado.indexOf("@"))
                        .equals("@hotmail.com")){
                        this.correo=correoDado;
                        }
                }else{
                    JOptionPane.showInputDialog("Error: correo no valido"+
                            " debe ser una cuenta valida");
                }
            }else{
               JOptionPane.showInputDialog("Error: correo no valido"+
                    " debe contener @");
            }
        }while(this.correo==null ||this.correo.equals(""));
        return correoDado;
     }

     public  Cliente CrearCliente() {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre : ");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad  :"));
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de identificacion :"));
            int numeroTel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero telefono:"));
            String correo=correoDado();
              return new Cliente(nombre,edad,id,numeroTel,correo);
            } 

     @Override
    public String toString() { 
        return """
                Cliente
                Nombre=""" + this.nombre +"\n"+
                "Edad=" + this.edad +"\n"+
                "Id=" + this.id +"\n"+
                "Numero telefonico="+this.numeroTel+"\n"+
                "Correo electronico="+getCorreo()+"\n";
    }


   
     
}
