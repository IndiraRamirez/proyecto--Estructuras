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
       public String nombre,correo;
     public int  edad,id, numeroTel;

    public  Customer (String nombre, int edad, int id, int numeroTel, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.numeroTel = numeroTel;
        this.correo = correo;
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
        if(correo.equals("")){
            return "Error: correo no ingresado";
        }
        
        return correo.substring(0, 3)+"....."+
                correo.substring(correo.indexOf("@"));
    }
    @Override
    public String toString() { 
        return """
                Cliente
                Nombre=""" + nombre +"\n"+
                "Edad=" + edad +"\n"+
                "Id=" + id +"\n"+
                "Numero telefonico="+numeroTel+"\n"+
                "Correo electronico="+getCorreo()+"\n";
    }
}
