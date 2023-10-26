/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

/**
 *
 * @author JeffryCH
 */
public class ListaDeVehiculos {
    private NodoVehiculo cabeza;
    private int size;

    public ListaDeVehiculos() {
        cabeza = null;
        size = 0;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        NodoVehiculo nuevoNodo = new NodoVehiculo(vehiculo);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoVehiculo aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevoNodo);
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public String listarVehiculos() {
        StringBuilder sb = new StringBuilder();
        NodoVehiculo aux = cabeza;
        while (aux != null) {
            sb.append(aux.getVehiculo().toString()).append("\n");
            aux = aux.getSiguiente();
        }
        return sb.toString();
    }

    // me falta algo?
}
