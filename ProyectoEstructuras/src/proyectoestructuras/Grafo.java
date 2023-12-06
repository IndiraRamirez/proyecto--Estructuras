package proyectoestructuras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Grafo {
    private HashMap<String, HashMap<String, Promocion>> grafo;

    public Grafo() {
        this.grafo = new HashMap<>();
    }

    public void leerArchivoYCrearGrafo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Marca, Tipo, %Cashback, KmGarantia, MantenimientosGratis
                String[] data = line.split(",");
                String marca = data[0].trim();
                String tipo = data[1].trim();
                double cashback = Double.parseDouble(data[2].trim());
                int kmGarantia = Integer.parseInt(data[3].trim());
                int mantenimientosGratis = Integer.parseInt(data[4].trim());

                this.agregarPromocion(marca, tipo, new Promocion(cashback, kmGarantia, mantenimientosGratis));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarPromocion(String marca, String tipo, Promocion promocion) {
        HashMap<String, Promocion> tipos = grafo.getOrDefault(marca, new HashMap<>());
        tipos.put(tipo, promocion);
        grafo.put(marca, tipos);
    }

    public Promocion obtenerPromocion(String marca, String tipo) {
        return grafo.getOrDefault(marca, new HashMap<>()).get(tipo);
    }

    public boolean eliminarPromocion(String marca, String tipo) {
        HashMap<String, Promocion> tipos = grafo.get(marca);
        if (tipos != null && tipos.containsKey(tipo)) {
            tipos.remove(tipo);
            // Si después de eliminar la promoción no quedan más tipos para la marca, eliminar también la marca.
            if (tipos.isEmpty()) {
                grafo.remove(marca);
            }
            return true; // Retornar true si la promoción fue eliminada con éxito.
        }
        return false; 
    }    

    public void mostrarPromociones(String marca) {
        HashMap<String, Promocion> tipos = grafo.get(marca);
        if (tipos != null) {
            String sb = new StringBuilder("Promociones para " + marca + ":\n");
            for (String tipo : tipos.keySet()) {
                Promocion p = tipos.get(tipo);
                sb.append(tipo).append(": %Cashback ").append(p.getCashback())
                  .append(", Km Garantía ").append(p.getKmGarantia())
                  .append(", Mantenimientos Gratis ").append(p.getCantMantenimientosGratis())
                  .append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay promociones disponibles para la marca " + marca);
        }
    }
}

