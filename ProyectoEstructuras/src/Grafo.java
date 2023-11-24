package proyectoestructuras;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class Grafo {
    private Map<String, Nodo> nodos;

    public Grafo() {
        nodos = new HashMap<>();
    }

    public void agregarNodo(String tipoVehiculo) {
        if (!nodos.containsKey(tipoVehiculo)) {
            nodos.put(tipoVehiculo, new Nodo(tipoVehiculo));
        }
    }

    public void agregarArista(String origen, String destino, Promocion promocion) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            Nodo nodoOrigen = nodos.get(origen);
            Nodo nodoDestino = nodos.get(destino);
            nodoOrigen.agregarVecino(nodoDestino, promocion);
        }
    }

public void modificarNodo(String tipoVehiculo, String nuevoTipoVehiculo) {
    if (nodos.containsKey(tipoVehiculo)) {
        Nodo nodo = nodos.get(tipoVehiculo);
        nodos.remove(tipoVehiculo);
        nodo.setTipoVehiculo(nuevoTipoVehiculo);
        nodos.put(nuevoTipoVehiculo, nodo);
    }
}

public void eliminarNodo(String tipoVehiculo) {
    if (nodos.containsKey(tipoVehiculo)) {
        Nodo nodo = nodos.get(tipoVehiculo);
        nodos.remove(tipoVehiculo);

        for (Nodo vecino : nodo.getVecinos()) {
            vecino.getVecinos().remove(nodo);
        }
    }
}

public void modificarArista(String origen, String destino, Promocion promocion) {
    if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
        Nodo nodoOrigen = nodos.get(origen);
        Nodo nodoDestino = nodos.get(destino);
        nodoOrigen.modificarVecino(nodoDestino, promocion);
    }
}

public void eliminarArista(String origen, String destino) {
    if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
        Nodo nodoOrigen = nodos.get(origen);
        Nodo nodoDestino = nodos.get(destino);
        nodoOrigen.eliminarVecino(nodoDestino);
    }
}
}