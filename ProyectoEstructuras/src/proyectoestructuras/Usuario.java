/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;



/**
 *
 * @author indir
 */
public class Usuario {

    public String nombre, contra;
    public int contadorV, contadorR,id;

    public Usuario() {
    }

    ManejoArchivos m = new ManejoArchivos();

    public Usuario(String nombre, String contra, int contadorV, int contadorR,int id) {
        this.nombre = nombre;
        this.contra = contra;
        this.contadorV = contadorV;   /// cantidad de carros vendidos
        this.contadorR = contadorR;   ///Cantidad de carros reservados
        this.id=id;
    }

    public int getContadorV() {
        return contadorV;
    }

    public void setContadorV(int contadorV) {
        this.contadorV = contadorV;
    }

    public int getContadorR() {
        return contadorR;
    }

    public void setContadorR(int contadorR) {
        this.contadorR = contadorR;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenna() {
        return contra;
    }

    public void setContrasenna(String contra) {
        this.contra = contra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contra=" + contra + ", contadorV=" + contadorV + ", contadorR=" + contadorR + ", id=" + id + '}';
    }
    
}
