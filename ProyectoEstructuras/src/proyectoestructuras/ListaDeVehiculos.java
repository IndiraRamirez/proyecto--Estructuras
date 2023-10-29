/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;
import java.io.*;

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
        String resultado = "";
        NodoVehiculo aux = cabeza;
        while (aux != null) {
            resultado += aux.getVehiculo().toString() + "\n";
            aux = aux.getSiguiente();
        }
        return resultado;
    }
    

    public void guardarEnArchivo(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            NodoVehiculo actual = cabeza;
            while (actual != null) {
                bw.write(actual.getVehiculo().toString());
                bw.newLine();  // para saltar a la siguiente línea
                actual = actual.getSiguiente();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    }
    
    public void cargarDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar desde archivo: " + e.getMessage());
        }
    }
}
  
