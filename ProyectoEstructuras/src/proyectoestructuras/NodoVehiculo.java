package proyectoestructuras;

/**
 *
 * @author JeffryCH
 */

package proyectoestructuras;

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

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public NodoVehiculo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoVehiculo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return vehiculo.toString();
    }
}

