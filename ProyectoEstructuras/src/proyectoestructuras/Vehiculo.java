package proyectoestructuras;

public class Vehiculo {

    // Enumeración para el tipo de vehículo
    public enum TipoVehiculo {
        SEDAN, SUV, HATCHBACK
    }

    // Enumeración para el estado del vehículo
    public enum EstadoVehiculo {
        DISPONIBLE, RESERVADO, VENDIDO;
    
        public static EstadoVehiculo fromString(String estado) {
            switch(estado.toUpperCase()) {
                case "DISPONIBLE": return DISPONIBLE;
                case "RESERVADO": return RESERVADO;
                case "VENDIDO": return VENDIDO;
                default: throw new IllegalArgumentException("Estado no válido: " + estado);
            }
        }
    }

    private String color;
    private int anio;
    private int cilindraje;
    private String marca;
    private String modelo;
    private double kilometraje;
    private TipoVehiculo tipo;
    private String caracteristicas;
    private EstadoVehiculo estado;
    private String cliente;
    private String vendedor;

    // Constructor
    public Vehiculo(String marca, String modelo, String color, int anio, int cilindraje,
                    double kilometraje, TipoVehiculo tipo, String caracteristicas,
                    EstadoVehiculo estado, String cliente, String vendedor) {
        if (anio < 0) throw new IllegalArgumentException("El año no puede ser negativo");
        if (cilindraje < 0) throw new IllegalArgumentException("El cilindraje no puede ser negativo");
        if (kilometraje < 0) throw new IllegalArgumentException("El kilometraje no puede ser negativo");

        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
        this.cilindraje = cilindraje;
        this.kilometraje = kilometraje;
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.estado = estado;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    // Constructor sobrecargado para casos donde no todos los datos están disponibles
    public Vehiculo(String marca, String modelo, String color, int anio) {
        this(marca, modelo, color, anio, 0, 0.0, TipoVehiculo.SEDAN, "", EstadoVehiculo.DISPONIBLE, null, null);
    }
    
    // Métodos para actualizar el estado del vehículo
    public void reservarVehiculo(String cliente, String vendedor) {
        if (this.estado == EstadoVehiculo.DISPONIBLE) {
            this.cliente = cliente;
            this.vendedor = vendedor;
            this.estado = EstadoVehiculo.RESERVADO;
        } else {
            throw new IllegalStateException("El vehículo no está disponible para reserva.");
        }
    }

    public void venderVehiculo(String cliente, String vendedor) {
        if (this.estado == EstadoVehiculo.RESERVADO || this.estado == EstadoVehiculo.DISPONIBLE) {
            this.cliente = cliente;
            this.vendedor = vendedor;
            this.estado = EstadoVehiculo.VENDIDO;
        } else {
            throw new IllegalStateException("El vehículo no está disponible para la venta.");
        }
    }

    public void cancelarReserva() {
        if (this.estado == EstadoVehiculo.RESERVADO) {
            this.cliente = null;
            this.estado = EstadoVehiculo.DISPONIBLE;
        } else {
            throw new IllegalStateException("No hay reserva activa para cancelar.");
        }
    }

    // Método para retornar la información del vehículo en formato texto
    public String aFormatoTexto() {
        return "Marca: " + marca + "\n" + 
               "Modelo: " + modelo + "\n" +
               "Color: " + color + "\n" +
               "Annio: " + anio + "\n" +
               "Cilindraje: " + cilindraje + "\n" +
               "Kilometraje: " + kilometraje + "\n" +
               "Tipo: " + tipo + "\n" +
               "Características: " + caracteristicas + "\n" +
               "Estado: " + estado + "\n" +
               "Cliente: " + cliente + "\n" +
               "Vendedor: " + vendedor;
    }

    // Getters para todos los atributos
    public String getColor() {
        return color;
    }

    public int getAnio() {
        return anio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public String getCliente() {
        return cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    // Setters para todos los atributos
    public void setColor(String color) {
        this.color = color;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    // SIIIIIIIII
    @Override
    public String toString() {
        return "Marca:" + marca + "," + 
               "Modelo:" + modelo + "," +
               "Color:" + color + "," +
               "Año:" + anio + "," +
               "Cilindraje:" + cilindraje + "," +
               "Kilometraje:" + kilometraje + "," +
               "Tipo:" + tipo + "," +
               "Características:" + caracteristicas + "," +
               "Estado:" + estado + "," +
               "Cliente:" + (cliente != null ? cliente : "") + "," +
               "Vendedor:" + (vendedor != null ? vendedor : "");
    }
    
}
