/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;


/**
 *
 * @author indir
 */
public class Customer {
       public String nombre,apellido,correo;
     public int  edad,id, numeroTel;

    public  Customer (String nombre,String apellido , int edad, int id, int numeroTel, String correo) {
        this.nombre = nombre;
        this.apellido=apellido;
        this.edad = edad;
        this.apellido=apellido;
        this.id = id;
        this.numeroTel = numeroTel;
        this.correo = correo;
    }

    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(int numeroTel) {
        this.numeroTel = numeroTel;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
   public String getCorreo(){
        return correo;
    }
    @Override
    public String toString() { 
        return """
                Cliente
                Nombre=""" + nombre +"\n"+
                "Apellido=" + apellido+"\n"+
                "Edad=" + edad +"\n"+
                "Id=" + id +"\n"+
                "Numero telefonico="+numeroTel+"\n"+
                "Correo electronico="+correo+"\n"+
                "----------------------------------------";
    }
}

