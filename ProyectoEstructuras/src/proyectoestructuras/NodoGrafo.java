package proyectoestructuras;

public class NodoGrafo {
    private String tipoVehiculo;
    private Promocion promocion;

    public NodoGrafo(String tipoVehiculo, Promocion promocion) {
        this.tipoVehiculo = tipoVehiculo;
        this.promocion = promocion;
    }

    // Getters
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    // Setters
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    @Override
    public String toString() {
        return "Tipo de Vehículo: " + tipoVehiculo + ", Promoción: " + promocion;
    }
}



