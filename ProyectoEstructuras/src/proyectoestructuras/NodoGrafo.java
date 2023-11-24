package proyectoestructuras;

import java.util.HashMap;
import java.util.Map;

public class NodoGrafo {
    private String tipoVehiculo;
    private Map<NodoGrafo, Promocion> vecinos;

    public NodoGrafo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        vecinos = new HashMap<>();
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Map<NodoGrafo, Promocion> getVecinos() {
        return vecinos;
    }

    public void agregarVecino(NodoGrafo vecino, Promocion promocion) {
        vecinos.put(vecino, promocion);
    }

    public void modificarVecino(NodoGrafo vecino, Promocion promocion) {
        if (vecinos.containsKey(vecino)) {
            vecinos.put(vecino, promocion);
        }
    }

    public void eliminarVecino(NodoGrafo vecino) {
        vecinos.remove(vecino);
    }
}
