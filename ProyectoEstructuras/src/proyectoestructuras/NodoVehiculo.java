/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

/**
 *
 * @author JeffryCH
 */
public class NodoVehiculo {
    private Vehiculo vehiculo;
    private NodoVehiculo siguiente;

    public NodoVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.siguiente = null;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public NodoVehiculo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoVehiculo siguiente) {
        this.siguiente = siguiente;
    }
}

