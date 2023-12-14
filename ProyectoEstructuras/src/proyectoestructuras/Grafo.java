package proyectoestructuras;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Grafo {
    private String nombre;
    private NodoGrafo[][] matriz;  

    public Grafo(String nombre) {
        this.nombre = nombre;

        this.matriz = new NodoGrafo[3][3];
    }

    public void agregarPromocion(int indiceMarca, int indiceTipo, Promocion promocion) {

        if (indiceMarca >= 0 && indiceMarca < matriz.length && 
            indiceTipo >= 0 && indiceTipo < matriz[indiceMarca].length) {
            matriz[indiceMarca][indiceTipo] = new NodoGrafo(obtenerTipoVehiculo(indiceMarca), promocion);
        }
    }

    public Promocion obtenerPromocion(int indiceMarca, int indiceTipo) {
        if (indiceMarca >= 0 && indiceMarca < matriz.length && 
            indiceTipo >= 0 && indiceTipo < matriz[indiceMarca].length) {
            NodoGrafo nodo = matriz[indiceMarca][indiceTipo];
            return nodo != null ? nodo.getPromocion() : null;
        }
        return null;
    }

    public void guardarPromocionEnArchivo(String nombreArchivo, Promocion promocion, String marca, String tipo) {
        try (FileWriter fw = new FileWriter(nombreArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(marca + "," + tipo + "," + promocion.getCashback() + "," + promocion.getKmGarantia() + "," + promocion.getCantMantenimientosGratis());
        } catch (IOException e) {
            System.err.println("Error al guardar la promoción en el archivo: " + e.getMessage());
        }
    }



    private String obtenerTipoVehiculo(int index) {
        switch (index) {
            case 0: return "suv";
            case 1: return "sedan";
            case 2: return "hatchback";
            default: return "desconocido";
        }
    }

    public Promocion obtenerPromocion(String marca, String tipo) {
        // Una manera de obtener el índice de la marca y el tipo basado en strings
        int indiceMarca = obtenerIndiceMarca(marca);
        int indiceTipo = obtenerIndiceTipo(tipo);
        
        if (indiceMarca >= 0 && indiceTipo >= 0) {
            NodoGrafo nodo = matriz[indiceMarca][indiceTipo];
            return nodo != null ? nodo.getPromocion() : null;
        }
        return null;
    }

    private int obtenerIndiceMarca(String marca) {
        
        return -1; 
    }

    private int obtenerIndiceTipo(String tipo) {
        
        return -1; 
    }
    

}
