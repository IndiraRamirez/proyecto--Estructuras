package proyectoestructuras;

public class NodoGrafo {
    private String tipoVehiculo;
    private Promocion promocion;

    public NodoGrafo(String tipoVehiculo, Promocion promocion) {
        this.tipoVehiculo = tipoVehiculo;
        this.promocion = promocion;
    }

    // Getters y Setters
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }
}


