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
public class Customer {
    public String nombre,apellido,correo;
     public int  edad,id, numeroTel;
     
    Customer() {
      }
    public Customer(String nombre, String apellido, int edad, int id, int numeroTel, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.edad = edad;
        this.id = id;
        this.numeroTel = numeroTel;
    }

   

    
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

     public void setCorreo(String pCorreo){
        if(pCorreo.contains("@")){
           
            if(pCorreo.substring(pCorreo.indexOf("@"))
                    .equals("@ufide.ac.cr")){
                correo=pCorreo;
            }else{
                JOptionPane.showMessageDialog(null,"Error: correo no valido"+
                            " debe ser una cuenta valida" , "Error", 0);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: correo no valido"+
                    " debe contener @", "Alerta", 0);
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(int numeroTel) {
        this.numeroTel = numeroTel;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     public String correoDado(String correo){
        String correoDado;
        do{   
        correoDado=JOptionPane.showInputDialog("Ingrese su correo: ");
            if(correoDado.contains("@")){
            switch (correoDado.substring(correoDado.indexOf("@"))) {
                case "@gmail.com" -> correo=correoDado;
                case "@hotmail.com" -> correo=correoDado;
                default -> JOptionPane.showMessageDialog(null,"Error: correo no valido"+
                            " debe ser una cuenta valida" , "Error", 0);
            }
            }else{
               JOptionPane.showMessageDialog(null, "Error: correo no valido"+
                    " debe contener @", "Alerta", 0);
            }
        
       }while(correo==null ||correo.equals(""));
        return correoDado;
     }

    @Override
    public String toString() {
        return """
               Cliente
                [id= """ + id + "\n"+
                "nombre= " + nombre +"  apellido= "+apellido+"\n"+
                "edad= "+edad+"  numTel= "+numeroTel+"\n"+
                "correo= "+correo+"]"+"\n"+
        "----------------------------------";
    }
}

